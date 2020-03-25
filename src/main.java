import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        //Inheriting characteristics from homePage
        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(" Scrabble Board");
        stage.show();
    }

    //Launching the game
    public static void main(String[] args)
    {
        launch(args);
    }
}