import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.awt.*;
import java.net.SecureCacheResponse;
import java.util.ArrayList;

public class layoutManager {

    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private final static int GAME_BUTTON_X = 800;
    private final static int GAME_BUTTON_Y = 100;
    private static final String BACKGROUND = "Images/Scrabble-logo.png";


    ArrayList<ScrabbleButton> gameButtons = new ArrayList<>();


    public layoutManager() {

        gameButtons = new ArrayList<ScrabbleButton>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,1024,650);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        setScrabbleBackground();
        setButtons();
        addScrabbleLogo();

        ScrabbleBoard fxBoard = new ScrabbleBoard();
        fxBoard.setLayoutX(200);
        fxBoard.setLayoutY(75);
        mainPane.getChildren().add(fxBoard);
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

    private void setButtons()
    {
        addPlayButton();
        addQuitButton();
        addPassButton();
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
        ImageView ScrabbleLogo = new ImageView(BACKGROUND);
        ScrabbleLogo.setLayoutX(0);
        ScrabbleLogo.setLayoutY(100);
        mainPane.getChildren().add(ScrabbleLogo);
    }

}
