import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class layoutManager {

    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private final static int GAME_BUTTON_X = 800;
    private final static int GAME_BUTTON_Y = 100;
    private static final String LOGO = "Images/Scrabble-logo.png";
    private ScrabbleHelp helpScene;
    private ScrabbleRack playerOneRack;
    private ScrabbleRack playerTwoRack;
    private ImageView ScrabbleLogo = new ImageView(LOGO);
    private boolean end_turn = true;

    boolean game_over = false;
    boolean begin_game = false;
    ScrabbleBoard fxBoard;
    Label player_turn = new Label("Welcome!");
    StackPane playerTurnlabel = new StackPane(player_turn);
    Label player_one = new Label("Player One:");
    StackPane playerOneLabel = new StackPane(player_one);
    Label score1 = new Label();
    Label score2 = new Label();


    Label player_two = new Label("Player Two:");
    StackPane playerTwoLabel = new StackPane(player_two);

    ArrayList<ScrabbleButton> gameButtons = new ArrayList<>();
    private int P1_Score = 10;
    private int P2_Score = 20;


    public layoutManager() {
        gameButtons = new ArrayList<ScrabbleButton>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,1024,650);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        setScrabbleBackground();
        fxBoard = new ScrabbleBoard();

        setButtons();
        addPlayerTurnLabel();
        player1ScoreLabel();
        player2ScoreLabel();

        fxBoard.setLayoutX(200);
        fxBoard.setLayoutY(75);
        mainPane.getChildren().add(fxBoard);
        addScrabbleLogo();
        addHelpScene();
        addScrabbleRack();
        fxBoard.board.player_one.frame.display_frame();
        System.out.println();
        fxBoard.board.player_two.frame.display_frame();
        System.out.println();
        System.out.println(Pool.game_pool.pool.size());

    }

    private void addButtons(ScrabbleButton button) {
        button.setLayoutX(GAME_BUTTON_X);
        button.setLayoutY(GAME_BUTTON_Y + gameButtons.size() * 100);
        gameButtons.add(button);
        mainPane.getChildren().add(button);
    }

    private void addPlayButton(){
        ScrabbleButton playButton = new ScrabbleButton("Play");

        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TranslateTransition transition = new TranslateTransition();
                TranslateTransition transitionboard = new TranslateTransition();
                TranslateTransition transitionTurnLabel = new TranslateTransition();
                TranslateTransition transitionTurnLabel2 = new TranslateTransition();
                TranslateTransition transitionTurnScore = new TranslateTransition();
                TranslateTransition transitionTurnLabel3 = new TranslateTransition();
                TranslateTransition transitionTurnScore1 = new TranslateTransition();
                System.out.println("Currently " + fxBoard.board.player_one_turn);
                //Transition Player Turn
                player_turn.setText("Player 1's Turn");
                transitionTurnLabel.setDuration(Duration.seconds(2));
                transitionboard.setDuration(Duration.seconds(2));
                transitionboard.setNode(fxBoard);
                transitionTurnLabel.setNode(playerTurnlabel);
                transitionTurnLabel.setToX(330);
                //End Player Transition

                //Transition Player One and Score
                transitionTurnLabel2.setDuration(Duration.seconds(2));
                transitionboard.setDuration(Duration.seconds(2));
                transitionboard.setNode(fxBoard);
                transitionTurnLabel2.setNode(playerOneLabel);
                transitionTurnLabel2.setToX(630);
                transitionTurnLabel2.setToY(55);

                transitionTurnScore.setDuration(Duration.seconds(2));
                transitionboard.setDuration(Duration.seconds(2));
                transitionboard.setNode(fxBoard);
                transitionTurnScore.setNode(score1);
                transitionTurnScore.setToX(630);
                transitionTurnScore.setToY(55);
                //end of Player one and score

                //Transition Player Two and Score
                transitionTurnLabel3.setDuration(Duration.seconds(2));
                transitionboard.setDuration(Duration.seconds(2));
                transitionboard.setNode(fxBoard);
                transitionTurnLabel3.setNode(playerTwoLabel);
                transitionTurnLabel3.setToX(50);
                transitionTurnLabel3.setToY(55);

                transitionTurnScore1.setDuration(Duration.seconds(2));
                transitionboard.setDuration(Duration.seconds(2));
                transitionboard.setNode(fxBoard);
                transitionTurnScore1.setNode(score2);
                transitionTurnScore1.setToX(50);
                transitionTurnScore1.setToY(55);
                //end of Player two and score

                transitionboard.setToY(-60);
                transitionboard.setToX(-150);

                transition.setDuration(Duration.seconds(2));
                transition.setNode(ScrabbleLogo);

                RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2));
                rotateTransition.setNode(ScrabbleLogo);
                rotateTransition.setByAngle(90);

                transition.setToY(300);
                transition.setToX(230);

                FadeTransition fadelogo = new FadeTransition();
                fadelogo.setNode(ScrabbleLogo);
                fadelogo.setFromValue(1.0);
                fadelogo.setToValue(0.0);
                fadelogo.setDuration(Duration.seconds(5));
                FadeTransition fadeinrack = playerOneRack.fadeIn();

                ParallelTransition movelayout = new ParallelTransition(transition,transitionboard,rotateTransition,transitionTurnLabel
                ,transitionTurnLabel2,transitionTurnLabel3,transitionTurnScore,transitionTurnScore1);
                ParallelTransition fadeinandout = new ParallelTransition(fadeinrack,fadelogo);
                playerOneRack.setOpacity(0.0);
                playerOneRack.setVisible(true);
                SequentialTransition sequence = new SequentialTransition(movelayout,fadeinandout);
                sequence.play();

                promptUser(end_turn);

            }
        });
        addButtons(playButton);

    }

    private void addQuitButton()
    {
        ScrabbleButton quitButton = new ScrabbleButton("Quit");
        quitButton.setEffect(new DropShadow());

        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();
            }
        });
        addButtons(quitButton);
    }

    private void addPassButton()
    {
        ScrabbleButton swapButton = new ScrabbleButton("Swap");
        addButtons(swapButton);
    }

    private void addHelpButton()
    {
        ScrabbleButton helpButton = new ScrabbleButton("Help");

        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                helpScene.Transition();
                fxBoard.board.player_one.frame.display_frame();
            }
        });
        addButtons(helpButton);
    }

    private void addEndTurnButton()
    {
        ScrabbleButton endTurnButton = new ScrabbleButton("End Turn");
        endTurnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                endTurn();
            }
        });
        addButtons(endTurnButton);
    }

    private void setButtons() {
        addPlayButton();
        addQuitButton();
        addPassButton();
        addHelpButton();
        addEndTurnButton();
    }

    public void createButton(String text){
        ScrabbleButton button  = new ScrabbleButton(text);
        mainPane.getChildren().add(button);
    }

    public Stage getStage(){
        return mainStage;
    }

    public AnchorPane getMainPane()
    {
        return mainPane;
    }

    public void setScrabbleBackground()
    {
        Image scrabbleBackgroundImage = new Image("Images/background.jpg",1024, 819,false,true);
        BackgroundImage scrabbleBackground = new BackgroundImage(scrabbleBackgroundImage, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);

        mainPane.setBackground(new Background(scrabbleBackground));
    }

    private void addScrabbleLogo()
    {
        ScrabbleLogo.setLayoutX(0);
        ScrabbleLogo.setLayoutY(100);
        ScrabbleLogo.setEffect(new DropShadow());

        mainPane.getChildren().add(ScrabbleLogo);
    }

    private void addHelpScene()
    {
        helpScene = new ScrabbleHelp();
        mainPane.getChildren().add(helpScene);
    }

    private void addScrabbleRack()
    {
        playerOneRack = new ScrabbleRack(fxBoard.board.player_one.frame,true);
        playerTwoRack = new ScrabbleRack(fxBoard.board.player_two.frame,false);
        playerTwoRack.setLayoutX(-500);
        playerOneRack.setLayoutX(100);
        playerOneRack.setVisible(false);
        playerTwoRack.setVisible(true);
        mainPane.getChildren().addAll(playerOneRack,playerTwoRack);
        //mainPane.getChildren().add(playerTwoRack);
    }
    private void addPlayerTurnLabel() {

        player_turn.setFont(new Font("Verdana", 24));
        playerTurnlabel.setStyle("-fx-background-color: #D8BFD8; " + "-fx-background-insets: 10; " + "-fx-background-radius: 10; " + "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
        playerTurnlabel.setPrefSize(200,50);
        playerTurnlabel.setLayoutX(420);
        playerTurnlabel.setLayoutY(0);

        mainPane.getChildren().add(playerTurnlabel);
    }

    public void player1ScoreLabel(){
        player_one.setFont(new Font("Verdana", 16));

        playerOneLabel.setStyle("-fx-background-color: #D8BFD8; " + "-fx-background-insets: 10; " + "-fx-background-radius: 10; " + "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
        playerOneLabel.setPrefSize(190,50);
        playerOneLabel.setLayoutX(0);
        playerOneLabel.setLayoutY(0);

        score1.setFont(new Font("Verdana", 13));
        score1.setLayoutX(125);
        score1.setLayoutY(-7);
        score1.setText(Integer.toString(P1_Score));
        score1.setPadding(new Insets(25, 30, 50, 25));

        mainPane.getChildren().addAll(playerOneLabel,score1);
    }

    public void player2ScoreLabel(){
        player_two.setFont(new Font("Verdana", 16));

        playerTwoLabel.setStyle("-fx-background-color: #D8BFD8; " + "-fx-background-insets: 10; " + "-fx-background-radius: 10; " + "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
        playerTwoLabel.setPrefSize(190,50);
        playerTwoLabel.setLayoutX(800);
        playerTwoLabel.setLayoutY(0);

        score2.setFont(new Font("Verdana", 13));
        score2.setLayoutX(925);
        score2.setLayoutY(-7);
        score2.setText(Integer.toString(P2_Score));
        score2.setPadding(new Insets(25, 30, 50, 25));

        mainPane.getChildren().addAll(playerTwoLabel,score2);
    }


    void promptUserBeginGame(){
        System.out.println("**WELCOME TO SCRABBLE**" +
                "\n1. Enter 'QUIT' to quit the game\n" +
                "2. Enter 'PLAY' to begin the game");
        boolean validinput = false;
        while(!validinput) {
            String input = getUserInput();
            if(input.equals("QUIT") || input.equals("Quit") || input.equals("quit")){
                System.out.println("**Thank You for Playing Our Game**");
                exit(0);
            }
            else if(input.equals("PLAY") || input.equals("Play") || input.equals("play")) validinput = true;
            else System.out.println("*You must enter either QUIT or PLAY*");
        }
    }


    public void promptUser() {
        System.out.println("\n**WELCOME TO PLAY MENU**" +
                "\n1. Enter 'QUIT' to quit the game\n" +
                "2. Enter 'HELP' to display HELP (again for display to disappear)\n" +
                "3. Enter 'PASS' to pass your turn\n" +
                "4. Enter 'EXCHANGE <letters>' to exchange these letters with random ones from the pool\n" +
                "5. Enter '<gridref><h/v><word>' to place your word e.g 0 0 V HELLO\n" +
                "6. Enter 'REPLAY' to redisplay this menu");
        getUserInput();
    }

        public void promptUser(boolean displaymenu) {
        if(!begin_game) begin_game=true;
        else {
            if(displaymenu)
            {
                System.out.println("\n**WELCOME TO PLAY MENU**" +
                        "\n1. Enter QUIT to quit the game\n" +
                        "2. Enter HELP to display HELP (again for display to disappear)\n" +
                        "3. Enter PASS to pass your turn\n" +
                        "4. Enter EXCHANGE <letters> to exchange these letters with random ones from the pool\n" +
                        "5. Enter <gridref><h/v><word> to place your word e.g 0 0 V HELLO\n" +
                        "6. Enter REPLAY to redisplay this menu");
            }
            end_turn = userMove(getUserInput());
            if(end_turn) endturn();
            else promptUser(true);
        }

    }
        private String getUserInput() {
        Scanner userinput = new Scanner(System.in);
        String input = userinput.nextLine();
        return input;
    }

        private boolean userMove(String input){
        switch (input){
            case "QUIT":exit(0);
                return false;

            case "HELP": helpScene.Transition();
                return false;

            case "PLAY": return true;

            case "PASS": endturn();
                return true;
        }

        //String pattern = "([0-1])([0-4])([0-1])([0-4])(H|V)([A-Z]+)";
       // Pattern pat = Pattern.compile(pattern);
        String pattern_xy = "([0-1])";
        String pattern_xy2 = "([0-9])";
        String pattern_direction_horizontal = "(h)";
        String pattern_direction_vertical = "(v)";
        String pattern_word = "([A-Z]+)";

        try{
            String inputtostring = input.replaceAll(" ","");
            System.out.println(inputtostring);
            char[] in = inputtostring.toCharArray();

            Pattern p_xy = Pattern.compile(pattern_xy);
            Pattern p_xy2 = Pattern.compile(pattern_xy2);
            Pattern p_direction_horizontal = Pattern.compile((pattern_direction_horizontal));
            Pattern p_direction_vertical = Pattern.compile(pattern_direction_vertical);
            Pattern p_word = Pattern.compile(pattern_word);

            Matcher x = p_xy.matcher(Character.toString(in[0]));
            Matcher x2 = p_xy2.matcher(Character.toString(in[1]));

            Matcher y = p_xy.matcher(Character.toString(in[2]));
            Matcher y2 = p_xy2.matcher(Character.toString(in[3]));

            Matcher word_direction_vertical = p_direction_vertical.matcher(Character.toString(in[4]));
            Matcher word_direction_horizontal = p_direction_horizontal.matcher(Character.toString(in[4]));

            System.out.println(in[4]);

            String w = "";
            for(int i=5;i<in.length;i++){
                w += in[i];
            }
            System.out.println(w);
            Matcher word = p_word.matcher(w);



            if(x.matches() && x2.matches() && y.matches() && y2.matches() && (word_direction_vertical.matches()  || word_direction_horizontal.matches()) && word.matches())
            {
                System.out.println("MATCHES");
                placeWord(inputtostring);
                return true;
            }
            else
            {
                System.out.println("Invalid move");
            }

        }catch(Exception e) {
            System.out.println("Invalid action");
        }

        return false;
    }

        private void endturn() {
        if (fxBoard.board.player_one_turn){
            SequentialTransition swapracks = new SequentialTransition(playerOneRack.RacKTransition2(), playerTwoRack.RacKTransition());
            fxBoard.board.player_one_turn = false;
            swapracks.play();
        } else{
            SequentialTransition swapracks = new SequentialTransition(playerTwoRack.RacKTransition(),playerOneRack.RacKTransition2());
            fxBoard.board.player_one_turn = true;
            swapracks.play();
        }
            System.out.println("Player One's Frame:");
            fxBoard.board.player_one.frame.display_frame();
    }

    private void placeWord(String input)  {
        System.out.println("je suis here");
        char[] in = input.toCharArray();
        int x1 = in[0] - 48;
        int x2 = in[1] - 48;
        int x = 10*x1 + x2;

        int y1 = in[2] - 48;
        int y2 = in[3] - 48;
        int y = 10*y1 + y2;

        char direction = in[4];

        String word = "";
        for(int i=5;i<in.length;i++) word += in[i];
        word.toUpperCase();
        ArrayList<Tile.letter> wordlist = new ArrayList<>();
        for(int i=0; i<word.length(); i++)
        {
            char temp = word.charAt(i);
            int index = temp - 65;
            wordlist.add(Pool.tile_array[index]);
        }
        int int_dir;
        if(direction == 'h')
            int_dir = 1;
        else
            int_dir = 0;
        for(int i = 0; i< wordlist.size(); i++)
        {
            System.out.print(wordlist.get(i));
        }
        System.out.println("je suis here2");

        fxBoard.board.place_word(wordlist,x,y,int_dir);

        if(fxBoard.board.player_one_turn) {

            System.out.println("Player one's turn");
            fxBoard.place_word(wordlist, x, y, int_dir, playerOneRack);

            //fxBoard.displayTiles(fxBoard.board);
            fxBoard.board.display_board();
        }
        else{
            System.out.println("Player two's turn");

            fxBoard.place_word(wordlist,x,y,int_dir,playerTwoRack);
            fxBoard.displayTiles(fxBoard.board);

        }
    }

    private void endTurn()
    {
        if (fxBoard.board.player_one_turn) {
            SequentialTransition swapracks = new SequentialTransition(playerOneRack.RacKTransition2(), playerTwoRack.RacKTransition());
            fxBoard.board.player_one_turn = false;
            swapracks.play();
        } else
        {
            SequentialTransition swapracks = new SequentialTransition(playerTwoRack.RacKTransition(),playerOneRack.RacKTransition2());
            fxBoard.board.player_one_turn = true;
            swapracks.play();
        }
    }
}