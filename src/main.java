import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
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
    Board game_board;
    Button startButton;
    //Kier sucksssssssss
    //Kier is the silliest goose, as well as te chilliest

    public static final int TILE_SIZE = 50;
    public static final int WIDTH = 4;
    public static final int HEIGHT = 4;

    private Group tileGroup = new Group();
    private Group squareGroup = new Group();

    private Parent CreateContent()
    {
        Pane root = new Pane();
        root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
    }
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

        Scene scene = new Scene(game_layout,600,600);

        board.setScene(scene);
        board.show();
    }
}
