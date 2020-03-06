
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





public class main extends Application {
    private static int X_SQUARE_NUM = 15;
    private static int Y_SQUARE_NUM = 15;


    private Parent createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(800,800);

        BoardOfTiles board = new BoardOfTiles();

        for(int i=0; i<15; i++)
        {
            for(int j=0; j<15; j++)
            {
                 root.getChildren().add(board.board.game_board[i][j]);
            }
        }
        return root;
    }

    public static void main(String[] args)
    {

        launch(args);
    }


    private class SquareTile extends StackPane {
        private static final int SQUARE_SIZE = 40;
        private Rectangle border = new Rectangle(SQUARE_SIZE - 2, SQUARE_SIZE - 2);
        private Text text = new Text();
        private Square square;
        public SquareTile(int x, int y, Square.square_type type)
        {
            square = new Square(type);

            if(type == Square.square_type.normal)
            {
                border.setFill(Color.BEIGE);
                text.setText("");
            }
            else if(type == Square.square_type.dub_l)
            {
                border.setFill(Color.LIGHTBLUE);
                text.setText("Double Letter Score");
            }
            else if(type == Square.square_type.trip_l)
            {
                border.setFill(Color.TURQUOISE);
                text.setText("Triple Letter Score");
            }
            else if(type == Square.square_type.dub_w){
                border.setFill(Color.SALMON);
                text.setText("Double Word Score");
            }
            else if(type == Square.square_type.trip_w){
                border.setFill(Color.DARKORANGE);
            }
            else
            {
                border.setFill(Color.SALMON);
                text.setText("*");
            }

            border.setStroke(Color.LIGHTGREY);

            getChildren().addAll(border,text);
            setTranslateX(x * SQUARE_SIZE);
            setTranslateY(y * SQUARE_SIZE);
        }
    }

    private class BoardOfTiles extends StackPane
    {
        private Board board = new Board();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));; //create icon
        Scene scene = new Scene(createContent());
        stage.setTitle(" Scrabble Board");
        stage.setScene(scene);
        stage.show();
    }
}