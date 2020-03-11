import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
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

    ArrayList<ScrabbleButton> gameButtons = new ArrayList<>();


    public layoutManager() {

        gameButtons = new ArrayList<ScrabbleButton>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,1024,650);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        setScrabbleBackground();

        setButtons();
        addPlayerTurnLabel();

        fxBoard.setLayoutX(200);
        fxBoard.setLayoutY(75);
        mainPane.getChildren().add(fxBoard);
        addScrabbleLogo();
        addHelpScene();
        //createButton("Kier is the big sad  :(");
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
                transitionboard.setDuration(Duration.seconds(2));
                transitionboard.setNode(fxBoard);
                transitionboard.setToY(-30);
                transitionboard.setToX(-150);
                transition.setDuration(Duration.seconds(2));
                transition.setNode(ScrabbleLogo);
                RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2));
                rotateTransition.setNode(ScrabbleLogo);
                rotateTransition.setByAngle(90);
                transition.setToY(350);
                transition.setToX(230);
                transition.play();
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

        Label player1_turn = new Label("Player 1 turn");

        player1_turn.setFont(new Font("Verdana", 24));
        StackPane shadowPane = new StackPane(player1_turn);
        shadowPane.setStyle("-fx-background-color: #D8BFD8; " + "-fx-background-insets: 10; " + "-fx-background-radius: 10; " + "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);");
        shadowPane.setPrefSize(200,50);
        shadowPane.setLayoutX(420);
        shadowPane.setLayoutY(0);

        mainPane.getChildren().add(shadowPane);

    }
}
