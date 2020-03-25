import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.util.ArrayList;


public class ScrabbleBoard extends SubScene {
    protected Player player_one = new Player("");
    protected Player player_two = new Player("");
    private boolean playGame;

    public SquareTile[][] squareTilesBoard = new SquareTile[15][15];//Setting up the 15x15 board
    private final static String BACKGROUND = "Images/borderbackground4.png";
    public Board board = new Board();
    private static final int SQUARE_SIZE = 35;

    //Designating characteristics to the board
    public ScrabbleBoard()
    {
        super(new AnchorPane(), 600, 600);//Setting height and width
        prefHeight(600);
        prefWidth(600);

        BackgroundImage background = new BackgroundImage(new Image(BACKGROUND,590,590,false,true),BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        AnchorPane boardroot = (AnchorPane) this.getRoot();
        boardroot.setBackground(new Background(background));
        boardroot.setEffect(new DropShadow(10, Color.BLACK));
        playGame = false;
        BoardOfTiles board = new BoardOfTiles();

        //Setting the squares on the board at their assigned height/width
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


    //To set squares to their correct properties
    private class SquareTile extends StackPane {

        private Rectangle border = new Rectangle(SQUARE_SIZE - 2, SQUARE_SIZE - 2);
        private Text text = new Text();
        private boolean empty = true;
        private Square square;
        private ImageView TileImage = new ImageView((new Image("Images/transparent.png", SQUARE_SIZE, SQUARE_SIZE, false, true)));

        public SquareTile(int x, int y, Square.square_type type)
        {
            square = new Square(type);


            //Normal tiles
            if(type == Square.square_type.normal)
            {
                border.setFill(Color.rgb(220,216,170));
                text.setText("");
                text.setStyle("-fx-font: 9 arial;");
            }
            //Double letter tiles with different colours
            else if(type == Square.square_type.dub_l)
            {
                border.setFill(Color.LIGHTBLUE);
                text.setText("Double\nLetter\nScore");
                text.setStyle("-fx-font: 9 arial;");
            }
            //Triple Letter tile
            else if(type == Square.square_type.trip_l)
            {
                border.setFill(Color.TURQUOISE);
                text.setText("Triple\nLetter\nScore");
                text.setStyle("-fx-font: 9 arial;");
            }
            //Double Word tile
            else if(type == Square.square_type.dub_w){
                border.setFill(Color.SALMON);
                text.setText("Double\nWord\nScore");
                text.setStyle("-fx-font: 9 arial;");
            }
            //Triple Word tile
            else if(type == Square.square_type.trip_w){
                border.setFill(Color.DARKORANGE);
                text.setText("Triple \nWord\nScore");
                text.setStyle("-fx-font: 9 arial;");
            }
            else //The left over square is centre square
                {
                border.setFill(Color.SALMON);
                text.setText("✭");
                text.setStyle("-fx-font: 30 arial;");
            }

            //Properties
            border.setStroke(Color.LIGHTGREY);
            this.setEffect(new DropShadow());
            getChildren().addAll(border,text,TileImage);
            setTranslateX(x * SQUARE_SIZE);
            setTranslateY(y * SQUARE_SIZE);
        }


    }


    //class for BoardOfTiles
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


    //Displaying tiles
    public void displayTiles(Board b)
    {
        for(int i=0; i< 15; i++)
        {
            for(int j=0; j<15; j++)
            {
                squareTilesBoard[i][j].TileImage.setImage(setImageTo((b.game_board[i][j].tile)));
            }
        }
    }


    //Function to place word on the board
    public void place_word(ArrayList<Tile.letter> word, int i, int j, int direction, ScrabbleRack rack) {
        //1 is vertical 0 is horizontal
        int counter = 0;
        for(counter = 0; counter < word.size(); counter++)
        {
            //Placing the word vertically on the board
            if(direction == 1)
            {
                if (squareTilesBoard[i][j].empty)
                {
                    squareTilesBoard[i][j].TileImage.setImage(setImageTo(board.game_board[i][j].tile));
                    rack.hideTiles(board.game_board[i][j].tile);
                    i++;
                }
                else
                {
                    continue;
                }
            }
            //Placing a word horizontally on the board
            else if(direction == 0)
            {
                if (squareTilesBoard[i][j].empty)
                {
                    squareTilesBoard[i][j].TileImage.setImage(setImageTo(board.game_board[i][j].tile));
                    rack.hideTiles(board.game_board[i][j].tile);
                    j++;
                }
                else
                {
                    continue;
                }
            }
        }
    }

    //Setting transition for the board
    public void Transition() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.4));
        transition.setNode(this);
    }

    //Setting each tile to its designated ;etter
    private Image setImageTo(Tile.letter tile)
    {
        Image background = null;
        switch (tile) {
            case a:
                background = new Image("Images/Alphabet/A.png", 35, 35, false, true);
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
                background = new Image("Images/Alphabet/O.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
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
                background = new Image("Images/Alphabet/W.png", SQUARE_SIZE, SQUARE_SIZE, false, true);
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
        //The natural background for everything else
        return background;
    }









}
