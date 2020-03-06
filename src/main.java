
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;





public class main extends Application {
    private static int X_SQUARE_NUM = 15;
    private static int Y_SQUARE_NUM = 15;
    private Board board;

    private Parent createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(800,800);


         board.display_board();

        for(int i=0; i<15; i++)
        {
            for(int j=0; j<15; j++)
            {
                 System.out.println(Board.game_board[i][j].type);
                 root.getChildren().add(Board.game_board[i][j]);
            }
        }
        return root;
    }

    public static void main(String[] args)
    {

        launch(args);
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