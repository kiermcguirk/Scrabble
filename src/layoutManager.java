import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.util.ArrayList;

public class layoutManager {

    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private final static int GAME_BUTTON_X = 800;
    private final static int GAME_BUTTON_Y = 100;
    private static final String LOGO = "Images/Scrabble-logo.png";
    private ScrabbleHelp helpScene;
    private ImageView ScrabbleLogo = new ImageView(LOGO);
    ScrabbleBoard fxBoard = new ScrabbleBoard();
    Label player_turn = new Label("Welcome!");
    StackPane playerTurnlabel = new StackPane(player_turn);
    Label player_one = new Label("Player One:");
    StackPane playerOneLabel = new StackPane(player_one);
    Label score1 = new Label();
    Label score2 = new Label();
    private static final String RACK_BACKGROUND = "Images/Rack_Background.jpg";

    private final static int RackSquare_X = 925;
    private final static int RackSquare_Y = 100;

    Label player_two = new Label("Player Two:");
    StackPane playerTwoLabel = new StackPane(player_two);

    ArrayList<ScrabbleRack> gameRack = new ArrayList<>();
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

        setButtons();
        addPlayerTurnLabel();
        player1ScoreLabel();
        player2ScoreLabel();

        fxBoard.setLayoutX(200);
        fxBoard.setLayoutY(75);
        mainPane.getChildren().add(fxBoard);
        addScrabbleLogo();
        addHelpScene();
        //createButton("Kier is the big sad  :(");
        setRackBackground1();
        setRackBackground2();
        createRackSquare(" ");
        createRackSquare2(" ");
        createRackSquare3(" ");
        createRackSquare4(" ");
        createRackSquare5(" ");
        createRackSquare6(" ");
        createRackSquare7(" ");
    }

    private void addButtons(ScrabbleButton button)
    {
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
                transition.play();

                transitionTurnLabel.play();
                transitionTurnLabel2.play();
                transitionTurnScore.play();
                transitionTurnLabel3.play();
                transitionTurnScore1.play();
                rotateTransition.play();
                transitionboard.play();
            }
        });
        addButtons(playButton);

    }

    private void addQuitButton()
    {
        ScrabbleButton quitButton = new ScrabbleButton("Quit");
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
            }
        });


        addButtons(helpButton);
    }

    private void setButtons()
    {
        addPlayButton();
        addQuitButton();
        addPassButton();
        addHelpButton();
    }


    public void createButton(String text)
    {
        ScrabbleButton button  = new ScrabbleButton(text);
        mainPane.getChildren().add(button);

    }


    public void setRackBackground1(){
        ImageView RackBackground = new ImageView(RACK_BACKGROUND);
        RackBackground.setLayoutX(915);
        RackBackground.setLayoutY(95);
        mainPane.getChildren().add(RackBackground);
    }

    public void setRackBackground2(){
        ImageView RackBackground = new ImageView(RACK_BACKGROUND);
        RackBackground.setLayoutX(915);
        RackBackground.setLayoutY(277);
        mainPane.getChildren().add(RackBackground);
    }



    private void addRackSquares(ScrabbleRack rack)
    {
        rack.setLayoutX(RackSquare_X);
        rack.setLayoutY(RackSquare_Y + gameRack.size() * 51);
        gameRack.add(rack);
        mainPane.getChildren().add(rack);
    }

    public void createRackSquare(String text){

        ScrabbleRack Rack = new ScrabbleRack(text);
        addRackSquares(Rack);


    }

    public void createRackSquare2(String text){

        ScrabbleRack Rack = new ScrabbleRack(text);
        addRackSquares(Rack);


    }

    public void createRackSquare3(String text){

        ScrabbleRack Rack = new ScrabbleRack(text);
        addRackSquares(Rack);


    }

    public void createRackSquare4(String text){

        ScrabbleRack Rack = new ScrabbleRack(text);
        addRackSquares(Rack);


    }

    public void createRackSquare5(String text){

        ScrabbleRack Rack = new ScrabbleRack(text);
        addRackSquares(Rack);


    }

    public void createRackSquare6(String text){

        ScrabbleRack Rack = new ScrabbleRack(text);
        addRackSquares(Rack);


    }

    public void createRackSquare7(String text){

        ScrabbleRack Rack = new ScrabbleRack(text);
        addRackSquares(Rack);


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
}
