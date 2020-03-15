import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private Label label;

    @FXML
    public Button startGame;
    public Button backButton;
    public Button quitButton;
    public Button singlePlayerButton;
    public TextField userButton;
    public Button playGame;

    @FXML
    public void getAction(ActionEvent event) throws IOException {
        Parent gameMode = FXMLLoader.load(getClass().getResource("getContents.fxml"));
        Scene gameScene = new Scene(gameMode);

        //Get stage info
        Stage window = (Stage) startGame.getScene().getWindow();
        window.setScene(gameScene);
        window.show();
    }

    @FXML
    public void backEvent(ActionEvent event) throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        Scene backScene = new Scene(back);

        Stage backWindow = (Stage) backButton.getScene().getWindow();
        backWindow.setScene(backScene);
        backWindow.show();
    }

    @FXML
    public void quitEvent(ActionEvent event) throws IOException{
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void singlePlayerEvent(ActionEvent event) throws IOException {
        Parent single = FXMLLoader.load(getClass().getResource("getUsername.fxml"));
        Scene singleScene = new Scene(single);

        Stage singleWindow = (Stage) singlePlayerButton.getScene().getWindow();
        singleWindow.setScene(singleScene);
        singleWindow.show();
    }

    @FXML
    private void multiPlayerEvent(ActionEvent event) {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void setPlayerName(String name){
        userButton.setText(name);
    }

    @FXML
    private void userEvent(ActionEvent event) {
        UI ui = new UI();
        ui.lm.player_one.setText(userButton.getText());
        ui.lm.playerOneLabel.getChildren().addAll(userButton);
        Stage stage = ui.lm.getStage();
        Stage closeStage = (Stage) playGame.getScene().getWindow();
        closeStage.close();
        stage.show();
    }
}
