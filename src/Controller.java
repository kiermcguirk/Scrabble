import javafx.event.EventHandler;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //UI ui = new UI();
    @FXML
    private Label label;

    @FXML
    public AnchorPane rootPane;

    //Initialising
    @FXML
    public Button startGame;
    public Button backButton;
    public Button quitButton;
    public Button singlePlayerButton;
    public Button multiPlayerButton;
    public TextField userText;
    public TextField userText2;
    public Button playGame;
    public Button playGame2;

    //Receiving text from the user
    private TextField getUserText() {
        return userText;
    }

    @FXML
    public void getAction(ActionEvent event) throws IOException {
        //receiving characteristics from this file
        Parent gameMode = FXMLLoader.load(getClass().getResource("getContents.fxml"));
        Scene gameScene = new Scene(gameMode);
        startGame.getStyleClass().add("startGame");

        //Get stage info
        Stage window = (Stage) startGame.getScene().getWindow();
        window.setScene(gameScene);
        window.show();
    }

    //Dealing with the back event
    @FXML
    public void backEvent(ActionEvent event) throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        Scene backScene = new Scene(back);

        Stage backWindow = (Stage) backButton.getScene().getWindow();
        backWindow.setScene(backScene);
        backWindow.show();
    }

    //When the quit button is hit
    @FXML
    public void quitEvent(ActionEvent event) throws IOException{
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }


    //Single user playing scrabble
    @FXML
    private void singlePlayerEvent(ActionEvent event) throws IOException {
        Parent single = FXMLLoader.load(getClass().getResource("getUsername.fxml"));
        Scene singleScene = new Scene(single);

        Stage singleWindow = (Stage) singlePlayerButton.getScene().getWindow();
        singleWindow.setScene(singleScene);
        singleWindow.show();
    }


    //Multiple users playing scrabble
    @FXML
    private void multiPlayerEvent(ActionEvent event) throws IOException {
        Parent multi = FXMLLoader.load(getClass().getResource("getMultiUser.fxml"));
        Scene multiScene = new Scene(multi);

        Stage multiWindow = (Stage) multiPlayerButton.getScene().getWindow();
        multiWindow.setScene(multiScene);
        multiWindow.show();
    }


    //General initialisation
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void setPlayerName(String name)//Setting the players names
    {
        userText.setText(name);
    }


    @FXML
    private void userEvent(ActionEvent event) throws IOException {
        UI ui = new UI();
        ui.lm.player_one.setText(userText.getText());
        //ui.lm.playerOneLabel.getChildren().addAll(userText);
        Stage stage = ui.lm.getStage();
        Stage closeStage = (Stage) playGame.getScene().getWindow();
        closeStage.close();
        stage.show();
    }

    @FXML void userEvent2(ActionEvent event){
        layoutManager lm = new layoutManager();
        lm.player_one.setText(userText.getText());
        lm.player_two.setText(userText2.getText());
        //lm.playerOneLabel.getChildren().add(userText);
        //lm.playerTwoLabel.getChildren().add(userText2);
        Stage stage = lm.getStage();
        Stage closeStage = (Stage) playGame2.getScene().getWindow();
        closeStage.close();
        stage.show();
    }

    @FXML
    private void backEvents(ActionEvent event) throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("getContents.fxml"));
        Scene backScene = new Scene(back);

        Stage backWindow = (Stage) playGame.getScene().getWindow();
        backWindow.setScene(backScene);
        backWindow.show();
    }

    @FXML
    private void backEventm(ActionEvent event) throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("getContents.fxml"));
        Scene backScene = new Scene(back);

        Stage backWindow = (Stage) playGame2.getScene().getWindow();
        backWindow.setScene(backScene);
        backWindow.show();
    }
}
