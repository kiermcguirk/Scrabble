import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class main extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        stage.getIcons().add(new Image("/Images/image.jpg")); //create icon
        stage.setTitle(" Scrabble Board");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
