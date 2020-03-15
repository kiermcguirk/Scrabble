import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class main extends Application {
    private static int X_SQUARE_NUM = 15;
    private static int Y_SQUARE_NUM = 15;
    //public Board board = new Board();
    //public layoutManager lm = new layoutManager();
    private UI ui = new UI();
    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));; //create icon
        stage = ui.lm.getStage();
        stage.setTitle(" Scrabble Board");
        ui.lm.promptUserBeginGame();
        stage.show();


    }
}