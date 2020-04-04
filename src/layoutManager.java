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
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.exit;
import static java.lang.System.in;

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
    private boolean isSwap = false;
    boolean game_over = false;
    boolean begin_game = false;
    ScrabbleBoard fxBoard;
    private boolean singleplayer = false;
    Label player_turn = new Label("Welcome!");
    StackPane playerTurnlabel = new StackPane(player_turn);
    Label player_one = new Label("Player One:");
    StackPane playerOneLabel = new StackPane(player_one);
    Label score1 = new Label();
    Label score2 = new Label();
    Tile getletter = new Tile();
    Dictionary dictionary = new Dictionary();

    Label player_two = new Label("Robocop");
    StackPane playerTwoLabel = new StackPane(player_two);

    ArrayList<ScrabbleButton> gameButtons = new ArrayList<>();
    private int P1_Score = 10;
    private int P2_Score = 20;

    //Constructor
    public layoutManager() {

        //Get and set elements
        gameButtons = new ArrayList<ScrabbleButton>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,1024,650);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        setScrabbleBackground();
        fxBoard = new ScrabbleBoard();

        setButtons();
        addPlayerTurnLabel();


        fxBoard.setLayoutX(200);
        fxBoard.setLayoutY(75);
        mainPane.getChildren().add(fxBoard);
        player1ScoreLabel();
        player2ScoreLabel();
        addScrabbleLogo();
        addHelpScene();
        addScrabbleRack();
        //fxBoard.board.player_one.frame.display_frame();
        //System.out.println();
        //.board.player_two.frame.display_frame();
       // System.out.println();
       // System.out.println(Pool.game_pool.pool.size());

    }

    //Function to add buttons
    private void addButtons(ScrabbleButton button) {
        button.setLayoutX(GAME_BUTTON_X);
        button.setLayoutY(GAME_BUTTON_Y + gameButtons.size() * 100);
        gameButtons.add(button);
        mainPane.getChildren().add(button);
    }

    //Adding the play Button
    private void addPlayButton(){
        ScrabbleButton playButton = new ScrabbleButton("Play");

        //Transitions for the buttons
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
                //System.out.println("Currently " + fxBoard.board.player_one_turn);
                //Transition Player Turn
                player_turn.setText(player_one.getText() + "'s turn");
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


    //Function to add the quit button
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
    ScrabbleRack.RackTile rackTile;

    private void addPassButton()//Button for passing
    {
        ScrabbleButton swapButton = new ScrabbleButton("Swap");
        addButtons(swapButton);
    }

    private void addHelpButton()//Help function button
    {
        ScrabbleButton helpButton = new ScrabbleButton("Help");

        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                helpScene.Transition();
                fxBoard.board.player_one.frame.display_frame();
            }
            Stack<Integer> askflj = new Stack<>();
            LinkedList asdf = new LinkedList(askflj);

        });
        addButtons(helpButton);
    }

    //Button when you're finished your turn
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

    //Different types of buttons
    private void setButtons() {
        addPlayButton();
        addQuitButton();
        addPassButton();
        addHelpButton();
        addChallengeButton();
        addEndTurnButton();
    }

    private void addChallengeButton() {
        ScrabbleButton challengeButton = new ScrabbleButton("Challenge");
        challengeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                challenge();} catch (Exception e) {
                    System.out.println("You can't challenge a word when one hasn't been placed");
                }

            }
        });
        addButtons(challengeButton);
    }

    //Function for creating a button
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

    //Setting the background to the specified image
    public void setScrabbleBackground()
    {
        Image scrabbleBackgroundImage = new Image("Images/background.jpg",1024, 819,false,true);
        BackgroundImage scrabbleBackground = new BackgroundImage(scrabbleBackgroundImage, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);

        mainPane.setBackground(new Background(scrabbleBackground));
    }

    //The addition of the Scrabble logo
    private void addScrabbleLogo()
    {
        ScrabbleLogo.setLayoutX(0);
        ScrabbleLogo.setLayoutY(100);
        ScrabbleLogo.setEffect(new DropShadow());

        mainPane.getChildren().add(ScrabbleLogo);
    }

    private void addHelpScene()//Adding Help Scene
    {
        helpScene = new ScrabbleHelp();
        mainPane.getChildren().add(helpScene);
    }

    //Adding the scrabble rack to the board
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

    //Showing the player whose turn it is
    private void addPlayerTurnLabel()
    {

        player_turn.setFont(new Font("Verdana", 16));
        playerTurnlabel.setStyle("-fx-background-color: #D8BFD8; " + "-fx-background-insets: 10; " + "-fx-background-radius: 10; " + "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
        playerTurnlabel.setPrefSize(200,50);
        playerTurnlabel.setLayoutX(420);
        playerTurnlabel.setLayoutY(0);

        mainPane.getChildren().add(playerTurnlabel);
    }

    //Showing the score for player one
    public void player1ScoreLabel(){
        player_one.setFont(new Font("Verdana", 16));

        playerOneLabel.setStyle("-fx-background-color: #D8BFD8; " + "-fx-background-insets: 10; " + "-fx-background-radius: 10; " + "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
        playerOneLabel.setPrefSize(190,50);
        playerOneLabel.setLayoutX(0);
        playerOneLabel.setLayoutY(0);

        score1.setFont(new Font("Verdana", 13));
        score1.setLayoutX(125);
        score1.setLayoutY(-7);
        score1.setText(Integer.toString(fxBoard.board.player_one.getScore()));
        score1.setPadding(new Insets(25, 30, 50, 25));

        mainPane.getChildren().addAll(playerOneLabel,score1);
    }

    //Showing the score for player two
    public void player2ScoreLabel()
    {
        player_two.setFont(new Font("Verdana", 16));

        playerTwoLabel.setStyle("-fx-background-color: #D8BFD8; " + "-fx-background-insets: 10; " + "-fx-background-radius: 10; " + "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
        playerTwoLabel.setPrefSize(190,50);
        playerTwoLabel.setLayoutX(800);
        playerTwoLabel.setLayoutY(0);

        score2.setFont(new Font("Verdana", 13));
        score2.setLayoutX(925);
        score2.setLayoutY(-7);
        score2.setText(Integer.toString(fxBoard.board.player_two.getScore()));
        score2.setPadding(new Insets(25, 30, 50, 25));

        mainPane.getChildren().addAll(playerTwoLabel,score2);
    }



    //Prompting user to play the game
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
                        "6. Enter NAME to set your name\n" +
                        "7. Enter CHALLENGE to challenge your opponents previous word\n");
            }
            end_turn = userMove(getUserInput());
            if(end_turn) endTurn();
            else promptUser(false);
        }

    }

    private String getUserInput() //Receiving user input
    {
        Scanner userinput = new Scanner(System.in);
        String input = userinput.nextLine();
        return input;
    }

    //Different cases when a player takes their turn
    private boolean userMove(String input)
    {
        boolean exchange = false;
        switch (input) {
            case "QUIT":
                exit(0);
                return false;

            case "HELP":
                helpScene.Transition();
                return false;

            case "PLAY":
                return true;

            case "PASS":
                return true;

            case "CHALLENGE":
                try{
                    challenge();} catch (Exception e) {
                    System.out.println("You can't challenge a word when one hasn't been placed");
                }
                return true;
        }


        //String pattern = "([0-1])([0-4])([0-1])([0-4])(H|V)([A-Z]+)";
        // Pattern pat = Pattern.compile(pattern);
        // Pattern pat = Pattern.compile(pattern);
        String pattern_xy = "([0-1])";
        String pattern_xy2 = "([0-9])";
        String pattern_direction_horizontal = "(h)";
        String pattern_direction_vertical = "(v)";
        String pattern_word = "([A-Z]+)";


        //Try to exchange tile
        try {
            String[] in = input.split(" ");
            String pattern = "([A-Z]+)";


            if (!(in[0].equals("EXCHANGE")) || in.length > 2) {
                throw new IllegalArgumentException();
            }

            Pattern pat = Pattern.compile(pattern);
            Matcher matchexchange = pat.matcher(in[1]);
            String letterstoexchange = in[1];
            System.out.println(letterstoexchange);

            if (matchexchange.matches()) {
                for (int i = 0; i < in[1].length(); i++) {
                    ExchangeTile(getletter.getTileFromLetter(in[1].charAt(i)));
                }
            }
            return true;


        } catch (Exception e) {}

        //String pattern = "([0-1])([0-4])([0-1])([0-4])(H|V)([A-Z]+)";
        // Pattern pat = Pattern.compile(pattern);


        //Try to place word
        try {
            String inputtostring = input.replaceAll(" ", "");
           // System.out.println(inputtostring);
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

           //System.out.println(in[4]);

            String w = "";
            for (int i = 5; i < in.length; i++) {
                w += in[i];
            }
           // System.out.println(w);
            Matcher word = p_word.matcher(w);
            String indexi = Character.toString(in[0]) + Character.toString(in[1]);
            String indexj = Character.toString(in[2]) + Character.toString(in[3]);
            int i = Integer.parseInt(indexi);
            int j = Integer.parseInt(indexj);

            if (x.matches() && x2.matches() && y.matches() && y2.matches() && (word_direction_vertical.matches() || word_direction_horizontal.matches()) && word.matches()) {
               // System.out.println("MATCHES");
                placeWord(inputtostring);
                fxBoard.board.addScore(w,i,j,in[4]);
               // System.out.println("score is "+fxBoard.board.player_one.getScore());
                setScoreLabels();
            } else {
                System.out.println("Invalid move");
            }
            return true;
        } catch (Exception e2) {
            System.out.println("Please try another move");
        }
        return false;
    }


    //Function when placing a word on the board
    private void placeWord(String input)  {
       // System.out.println("je suis here");
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
          //  System.out.print(wordlist.get(i));
        }



        fxBoard.board.place_word(wordlist,x,y,int_dir);

        if(fxBoard.board.player_one_turn) {

            fxBoard.place_word(wordlist, x, y, int_dir, playerOneRack);


            //fxBoard.board.display_board();
        }
        else{
          //  System.out.println(player_two.getText() + "'s turn");

            fxBoard.place_word(wordlist,x,y,int_dir,playerTwoRack);
            fxBoard.displayTiles(fxBoard.board);

        }
    }

    //Determining who is called whether it is a single player or multiplayer
    private void changePlayerLabel(boolean player_one_turn)
    {
        if(player_one_turn)
        {
            if(!singleplayer)
                player_turn.setText(player_two.getText() + "'s turn");
            else
                player_turn.setText("Bot's Turn");
        }
        else
        {
            player_turn.setText(player_one.getText() + "'s turn");
        }
    }

    //Function for when a turn is finished
    private void endTurn()
    {
        if (fxBoard.board.player_one_turn) {
            changePlayerLabel(true);
            SequentialTransition swapracks = new SequentialTransition(playerOneRack.RacKTransition2(), playerTwoRack.RacKTransition());
            addTileFrameRack();
            swapracks.play();
            fxBoard.board.player_one_turn = false;

        } else
        {
            changePlayerLabel(false);
            SequentialTransition swapracks = new SequentialTransition(playerTwoRack.RacKTransition(),playerOneRack.RacKTransition2());
            addTileFrameRack();
            swapracks.play();
            fxBoard.board.player_one_turn = true;

        }
    }

    //Function for when you are exchanging a tile
    private void ExchangeTile(Tile.letter tile)
    {
        Tile.letter tilefrompool = Pool.game_pool.draw();
        if(fxBoard.board.player_one_turn)
        {
            Pool.game_pool.pool.add(playerOneRack.SwapTile(tile,tilefrompool));
            fxBoard.board.player_one.frame.SwapTile(tile,tilefrompool);
            playerOneRack.displayRack();
        }
        else{
            Pool.game_pool.pool.add(playerTwoRack.SwapTile(tile,tilefrompool));
            fxBoard.board.player_two.frame.SwapTile(tile,tilefrompool);
            playerTwoRack.displayRack();
        }
    }

    //Showing score
    private void setScoreLabels()
    {
        score1.setText(Integer.toString(fxBoard.board.player_one.getScore()));
        score2.setText(Integer.toString(fxBoard.board.player_two.getScore()));
    }


    //Function to add tiles to a rack
    private void addTileFrameRack()
    {
        if(fxBoard.board.player_one_turn)
        {
            if(fxBoard.board.player_one.frame.player_frame.size() < 7)
            {
                fxBoard.board.player_one.frame.refill_frame();
                playerOneRack.displayRack(fxBoard.board.player_one.frame);
            }
        }
        else
        {
            if(fxBoard.board.player_two.frame.player_frame.size() < 7)
            {
                fxBoard.board.player_two.frame.refill_frame();
                playerTwoRack.displayRack(fxBoard.board.player_two.frame);
            }
        }
    }

    private void setPlayerName() {

        //Ask player to enter name
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter Player name ");
        String input = myObj.nextLine();


        //System.out.println("Your new name is: " + input);
        //Make sure name doesn't contain numbers
        //name length less than 12
        //no spaces
        if ((Pattern.compile("[0-9]").matcher(input).find())  ||  (input.length() > 11)  ||  (input.contains(" "))){

            System.out.println("Invalid Name! Please have no spaces or numbers and have your name fewer than 12 letters!");
            setPlayerName();
        }
        else {

            //if player one's turn
            if (fxBoard.board.player_one_turn) {
                //set player one's name to input

                player_one.setText(input);
                //fxBoard.board.player_one.setName(input);
                System.out.println(fxBoard.board.player_one.getName());
            }
            else {
                //otherwise, set player two's name
                player_two.setText(input);
                //fxBoard.board.player_two.setName(player2);
                System.out.println(fxBoard.board.player_two.getName());

            }
            setNameLabels(true);
        }
    }

    private void setNameLabels(boolean player_name){
        if(player_name){
            if(!singleplayer)
                player_two.setText(player_two.getText());
            else
                player_turn.setText("RoboCops's Turn");
        }
        else{
            player_one.setText(player_one.getText());
        }
    }

    private void challenge()
    {
        if(fxBoard.board.player_one_turn) {
            if (fxBoard.board.player_two.frame.prevRack.isEmpty()) throw new IllegalArgumentException();
        }
        else {
            if (fxBoard.board.player_one.frame.prevRack.isEmpty()) throw new IllegalArgumentException();
        }

        String word ="";
        Tile getString = new Tile();
        for (Tile.letter x: fxBoard.board.prevWord ) {
            word += getString.getLetterFromTile(x);
        }

        if(dictionary.checkDictionary(word))
        {
            System.out.println("This word is a valid word, your turn has now been passed");
            endTurn();
        }
        else
        {
            if(fxBoard.board.player_one_turn)
            {
                fxBoard.board.player_two.setPrevScore();
                fxBoard.board.player_one.frame.revertRack();
                fxBoard.board.revertPlacedWord();
            }
            else
            {

                fxBoard.board.player_one.setPrevScore();
                fxBoard.board.player_one.frame.revertRack();
                fxBoard.board.revertPlacedWord();
            }
            setScoreLabels();
            fxBoard.displayTiles(fxBoard.board);
            playerOneRack.displayRack(fxBoard.board.player_one.frame);
            playerTwoRack.displayRack(fxBoard.board.player_two.frame);

            fxBoard.board.isFirstMove = fxBoard.board.isFirstMove();


        }
    }
}