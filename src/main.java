import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.function.BinaryOperator;

public class main extends Application {
    Stage board;
    Button startButton;

    public static void main(String[] args)
    {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {

        board = stage;
        board.setTitle("Scrabble Board");
        startButton = new Button("Click here to start game");
        startButton.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        StackPane game_layout = new StackPane();
        game_layout.getChildren().add(startButton);

        Scene scene = new Scene(game_layout,200,200);

        board.setScene(scene);
        board.show();
    }
}
