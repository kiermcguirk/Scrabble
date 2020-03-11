import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

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
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;
public class ScrabbleBoard extends SubScene {

    private final static String BACKGROUND = "Images/borderbackground4.png";
    public Board board = new Board();

    public ScrabbleBoard() {
        super(new AnchorPane(), 600, 600);
        prefHeight(600);
        prefWidth(600);

        BackgroundImage background = new BackgroundImage(new Image(BACKGROUND,590,590,false,true),BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        AnchorPane boardroot = (AnchorPane) this.getRoot();
        boardroot.setBackground(new Background(background));
        boardroot.setEffect(new DropShadow());
        BoardOfTiles board = new BoardOfTiles();
        int num = 35;
        for(int i=0; i<15; i++)
        {
            for(int j=0; j<15; j++)
            {
                board.squareTilesBoard[i][j].setLayoutY(num);
                board.squareTilesBoard[i][j].setLayoutX(num);
                num += .7;
                boardroot.getChildren().add(board.squareTilesBoard[i][j]);

            }
        }
    }

    private class SquareTile extends StackPane {
        private static final int SQUARE_SIZE = 35;
        private Rectangle border = new Rectangle(SQUARE_SIZE - 2, SQUARE_SIZE - 2);
        private Text text = new Text();
        private Square square;
        public SquareTile(int x, int y, Square.square_type type)
        {
            square = new Square(type);

            if(type == Square.square_type.normal)
            {
                border.setFill(Color.rgb(220,216,170));
                text.setText("");
            }
            else if(type == Square.square_type.dub_l)
            {
                border.setFill(Color.LIGHTBLUE);
                text.setText("Double\nLetter\nScore");
            }
            else if(type == Square.square_type.trip_l)
            {
                border.setFill(Color.TURQUOISE);
                text.setText("Triple\nLetter\nScore");
            }
            else if(type == Square.square_type.dub_w){
                border.setFill(Color.SALMON);
                text.setText("Double\nWord\nScore");
            }
            else if(type == Square.square_type.trip_w){
                border.setFill(Color.DARKORANGE);
                text.setText("Triple \nWord\nScore");

            }
            else
            {
                border.setFill(Color.SALMON);
                text.setText("*");
            }

            border.setStroke(Color.LIGHTGREY);
            text.setStyle("-fx-font: 9 arial;");
            this.setEffect(new DropShadow());
            getChildren().addAll(border,text);
            setTranslateX(x * SQUARE_SIZE);
            setTranslateY(y * SQUARE_SIZE);
        }

    }

    private class BoardOfTiles extends StackPane
    {
        private SquareTile[][] squareTilesBoard = new SquareTile[15][15];

        public BoardOfTiles()
        {
            for(int i=0; i<15; i++)
            {
                for(int j =0; j<15; j++)
                {
                    if(board.game_board[i][j].type == Square.square_type.dub_w)
                    {
                        squareTilesBoard[i][j] = new SquareTile(i,j, Square.square_type.dub_w);
                    }
                    else if(board.game_board[i][j].type == Square.square_type.dub_l)
                    {
                        squareTilesBoard[i][j] = new SquareTile(i,j, Square.square_type.dub_l);
                    }
                    else if(board.game_board[i][j].type == Square.square_type.trip_l)
                    {
                        squareTilesBoard[i][j] = new SquareTile(i,j, Square.square_type.trip_l);
                    }
                    else if(board.game_board[i][j].type == Square.square_type.trip_w)
                    {
                        squareTilesBoard[i][j] = new SquareTile(i,j, Square.square_type.trip_w);
                    }
                    else if(board.game_board[i][j].type == Square.square_type.normal)
                    {
                        squareTilesBoard[i][j] = new SquareTile(i,j, Square.square_type.normal);
                    }
                    else
                    {
                        squareTilesBoard[i][j] = new SquareTile(i,j, Square.square_type.middle);
                    }
                }
            }
        }
    }



    public void Transition()
    {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.4));

        transition.setNode(this);

    }
}
