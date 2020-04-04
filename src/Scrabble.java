import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Scrabble extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        try {
            //Inheriting characteristics from homePage
            Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            stage.setScene(scene);
            stage.getIcons().add(new Image("Images/eggs.jpg"));
            stage.setTitle(" Scrabble Board");
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Launching the game
    public static void main(String[] args)
    {
        launch(args);
    }
}