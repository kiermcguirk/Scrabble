import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;
public class ScrabbleBoard extends SubScene {
    public SquareTile[][] squareTilesBoard = new SquareTile[15][15];
    private final static String BACKGROUND = "Images/borderbackground4.png";
    public Board board = new Board();
    private static final int SQUARE_SIZE = 35;
    public ScrabbleBoard() {
        super(new AnchorPane(), 600, 600);
        prefHeight(600);
        prefWidth(600);

        BackgroundImage background = new BackgroundImage(new Image(BACKGROUND,590,590,false,true),BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        AnchorPane boardroot = (AnchorPane) this.getRoot();
        boardroot.setBackground(new Background(background));
        boardroot.setEffect(new DropShadow(10, Color.BLACK));
        BoardOfTiles board = new BoardOfTiles();

        int num = 35;
        for(int i=0; i<15; i++)
        {
            for(int j=0; j<15; j++)
            {
                squareTilesBoard[i][j].setLayoutY(num);
                squareTilesBoard[i][j].setLayoutX(num);
                num += .7;
                boardroot.getChildren().add(squareTilesBoard[i][j]);

            }
        }
    }

    private class SquareTile extends StackPane {
        
        private Rectangle border = new Rectangle(SQUARE_SIZE - 2, SQUARE_SIZE - 2);
        private Text text = new Text();
        private boolean empty = true;
        private Square square;
        private ImageView TileImage = new ImageView((new Image("Images/transparent.png", SQUARE_SIZE, SQUARE_SIZE, false, true)));
        public SquareTile(int x, int y, Square.square_type type)
        {
            square = new Square(type);

            if(type == Square.square_type.normal)
            {
                border.setFill(Color.rgb(220,216,170));
                text.setText("");
                text.setStyle("-fx-font: 9 arial;");
            }
            else if(type == Square.square_type.dub_l)
            {
                border.setFill(Color.LIGHTBLUE);
                text.setText("Double\nLetter\nScore");
                text.setStyle("-fx-font: 9 arial;");
            }
            else if(type == Square.square_type.trip_l)
            {
                border.setFill(Color.TURQUOISE);
                text.setText("Triple\nLetter\nScore");
                text.setStyle("-fx-font: 9 arial;");
            }
            else if(type == Square.square_type.dub_w){
                border.setFill(Color.SALMON);
                text.setText("Double\nWord\nScore");
                text.setStyle("-fx-font: 9 arial;");
            }
            else if(type == Square.square_type.trip_w){
                border.setFill(Color.DARKORANGE);
                text.setText("Triple \nWord\nScore");
                text.setStyle("-fx-font: 9 arial;");
            }
            else {
                border.setFill(Color.SALMON);
                text.setText("✭");
                text.setStyle("-fx-font: 30 arial;");
            }

            border.setStroke(Color.LIGHTGREY);
            this.setEffect(new DropShadow());
            getChildren().addAll(border,text,TileImage);
            setTranslateX(x * SQUARE_SIZE);
            setTranslateY(y * SQUARE_SIZE);
        }

    }

    private class BoardOfTiles extends StackPane
    {
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

    public void place_word(ArrayList<Tile.letter> word, int i, int j, int direction) {
        //1 is vertical 0 is horizontal
        int counter = 0;
        for(counter = 0; counter < word.size(); counter++)
        {
            if(direction == 1)
            {
                if (squareTilesBoard[i][j].empty)
                {
                    squareTilesBoard[i][j].TileImage.setImage(setImageTo(board.game_board[i][j].tile));
                    i++;
                }
                else
                {
                    continue;
                }
            }
            else if(direction == 0)
            {
                if (squareTilesBoard[i][j].empty)
                {
                    squareTilesBoard[i][j].TileImage.setImage(setImageTo(board.game_board[i][j].tile));
                    j++;
                }
                else
                {
                    continue;
                }
            }
        }
    }


    public void Transition() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.4));
        transition.setNode(this);
    }

    private Image setImageTo(Tile.letter tile)
    {
        System.out.println("here");
        Image background = null;
        switch (tile) {
            case a:
                background = new Image("Images/Alphabet/A.jpg", 35, 35, false, true);
                break;
            case b:
                background = new Image("Images/Alphabet/B.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case c:
                background = new Image("Images/Alphabet/C.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case d:
                background = new Image("Images/Alphabet/D.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case e:
                background = new Image("Images/Alphabet/E.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case f:
                background = new Image("Images/Alphabet/F.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case g:
                background = new Image("Images/Alphabet/G.jpg", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case h:
                background = new Image("Images/Alphabet/H.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case i:
                background = new Image("Images/Alphabet/I.jpg", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case j:
                background = new Image("Images/Alphabet/J.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case k:
                background = new Image("Images/Alphabet/K.jpg", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case l:
                background = new Image("Images/Alphabet/L.jpg", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case m:
                background = new Image("Images/Alphabet/M.jpg", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case n:
                background = new Image("Images/Alphabet/N.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case o:
                background = new Image("Images/Alphabet/O.jpg", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case p:
                background = new Image("Images/Alphabet/P.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case q:
                background = new Image("Images/Alphabet/Q.jpg", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case r:
                background = new Image("Images/Alphabet/R.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case s:
                background = new Image("Images/Alphabet/S.jpg", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case t:
                background = new Image("Images/Alphabet/T.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case u:
                background = new Image("Images/Alphabet/U.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case v:
                background = new Image("Images/Alphabet/V.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case w:
                background = new Image("Images/Alphabet/W.jpg", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case x:
                background = new Image("Images/Alphabet/X.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case y:
                background = new Image("Images/Alphabet/Y.jpg", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case z:
                background = new Image("Images/Alphabet/Z.jpg", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
            case blank:
                background = new Image("Images/Alphabet/blank.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
                break;
        }
        return background;
    }
}
