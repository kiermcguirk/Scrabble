import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.awt.*;

public class main extends Application {
    Stage board;
    Button start;

    public static void main(String[]args)
    {
        Launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        board = stage;
        board.setTitle("Scrabble Board");
        start = new Button("Click here to start game");

        BorderPane game_layout = new BorderPane();
        game_layout.getChildren().add(start);

        Scene scene = new Scene(game_layout,200,200);


        board.show();
    }
}
