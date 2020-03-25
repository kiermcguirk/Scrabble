import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class ScrabbleRack extends SubScene {

    //final Rotate rotateRack = new Rotate();
    final int RACK_X = 925;
    final int RACK_Y = 100;

    private final String STYLE_BUTTON_NORMAL = "-fx-background-color: linear-gradient(#CDC6B0, #CDC6B0); " +
            "-fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color:  linear-gradient(#988454, #988454);";

    private static final String RACK_BACKGROUND = "Images/Rack_Background.jpg";
    ArrayList<RackTile> gameRack = new ArrayList<>();
    private boolean onboard = true;
    private final String STYLE_RACK_BACKGROUND = "-";


        //Setting the characteristics for the rack
    public ScrabbleRack(Frame playerframe, Boolean onboard) {
        super(new Pane(), 472, 80);

        this.onboard = onboard;
        BackgroundImage background = new BackgroundImage(new Image(RACK_BACKGROUND, 472, 80, false, true), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        Pane rackroot = (Pane) this.getRoot();
        rackroot.setBackground(new Background(background));
        for (int i = 0; i < playerframe.player_frame.size(); i++) {
            createRackSquare(playerframe.player_frame.get(i));
            rackroot.getChildren().add(gameRack.get(i));
        }
        setLayoutX(100);
        setLayoutY(580);
        setEffect(new DropShadow());
    }

    //Layout of the rack
    private void addRackSquares(RackTile rack) {
        if (gameRack.size() == 0) {
            rack.setLayoutX(20);
        } else {
            rack.setLayoutX(getLayoutX() + gameRack.size() * 51 + 20);
        }
        rack.setLayoutY(10);
        //rack.setLayoutY(10);
        gameRack.add(rack);
    }


    //Function to make rack square
    public void createRackSquare(Tile.letter text) {
        RackTile Rack = new RackTile(text);
        Rack.tileval = text;
        Rack.EventListenersInit();
        addRackSquares(Rack);
    }

    //Setting the scrabble tile characteristics
    class RackTile extends StackPane {
        private static final int RACK_TILE_SIZE = 42;
        Rectangle border = new Rectangle(RACK_TILE_SIZE, RACK_TILE_SIZE);
        private Tile.letter tileval;
        ImageView background;

        //The different cases for each letter tile
        public RackTile(Tile.letter tile) {
            setEffect(new DropShadow());
            EventListenersInit();
            switch (tile) {
                case a:
                    background = new ImageView(new Image("Images/Alphabet/A.png", 42, 42, false, true));
                    break;
                case b:
                    background = new ImageView(new Image("Images/Alphabet/B.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case c:
                    background = new ImageView(new Image("Images/Alphabet/C.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case d:
                    background = new ImageView(new Image("Images/Alphabet/D.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case e:
                    background = new ImageView(new Image("Images/Alphabet/E.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case f:
                    background = new ImageView(new Image("Images/Alphabet/F.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case g:
                    background = new ImageView(new Image("Images/Alphabet/G.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case h:
                    background = new ImageView(new Image("Images/Alphabet/H.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case i:
                    background = new ImageView(new Image("Images/Alphabet/I.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case j:
                    background = new ImageView(new Image("Images/Alphabet/J.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case k:
                    background = new ImageView(new Image("Images/Alphabet/K.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case l:
                    background = new ImageView(new Image("Images/Alphabet/L.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case m:
                    background = new ImageView(new Image("Images/Alphabet/M.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case n:
                    background = new ImageView(new Image("Images/Alphabet/N.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case o:
                    background = new ImageView(new Image("Images/Alphabet/O.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case p:
                    background = new ImageView(new Image("Images/Alphabet/P.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case q:
                    background = new ImageView(new Image("Images/Alphabet/Q.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case r:
                    background = new ImageView(new Image("Images/Alphabet/R.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case s:
                    background = new ImageView(new Image("Images/Alphabet/S.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case t:
                    background = new ImageView(new Image("Images/Alphabet/T.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case u:
                    background = new ImageView(new Image("Images/Alphabet/U.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case v:
                    background = new ImageView(new Image("Images/Alphabet/V.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case w:
                    background = new ImageView(new Image("Images/Alphabet/W.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case x:
                    background = new ImageView(new Image("Images/Alphabet/X.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case y:
                    background = new ImageView(new Image("Images/Alphabet/Y.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case z:
                    background = new ImageView(new Image("Images/Alphabet/Z.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
                case blank:
                    background = new ImageView(new Image("Images/Alphabet/blank.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true));
                    break;
            }
            getChildren().add(background);
        }

        //Setting the image to each tile
        private Image setImageTo(Tile.letter tile)
        {

            Image background = null;
            switch (tile) {
                case a:
                    background = new Image("Images/Alphabet/A.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case b:
                    background = new Image("Images/Alphabet/B.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case c:
                    background = new Image("Images/Alphabet/C.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case d:
                    background = new Image("Images/Alphabet/D.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case e:
                    background = new Image("Images/Alphabet/E.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case f:
                    background = new Image("Images/Alphabet/F.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case g:
                    background = new Image("Images/Alphabet/G.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case h:
                    background = new Image("Images/Alphabet/H.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case i:
                    background = new Image("Images/Alphabet/I.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case j:
                    background = new Image("Images/Alphabet/J.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case k:
                    background = new Image("Images/Alphabet/K.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case l:
                    background = new Image("Images/Alphabet/L.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case m:
                    background = new Image("Images/Alphabet/M.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case n:
                    background = new Image("Images/Alphabet/N.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case o:
                    background = new Image("Images/Alphabet/O.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case p:
                    background = new Image("Images/Alphabet/P.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case q:
                    background = new Image("Images/Alphabet/Q.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case r:
                    background = new Image("Images/Alphabet/R.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case s:
                    background = new Image("Images/Alphabet/S.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case t:
                    background = new Image("Images/Alphabet/T.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case u:
                    background = new Image("Images/Alphabet/U.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case v:
                    background = new Image("Images/Alphabet/V.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case w:
                    background = new Image("Images/Alphabet/W.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case x:
                    background = new Image("Images/Alphabet/X.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case y:
                    background = new Image("Images/Alphabet/Y.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case z:
                    background = new Image("Images/Alphabet/Z.jpg", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
                case blank:
                    background = new Image("Images/Alphabet/blank.png", RACK_TILE_SIZE, RACK_TILE_SIZE, false, true);
                    break;
            }
            return background;
        }

        //Setting prefixes of elements
        private void EventListenersInit() {
            setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ScaleTransition enlarge = new ScaleTransition(Duration.seconds(.15));
                    enlarge.setNode(background);
                    enlarge.setToX(1.2);
                    enlarge.setToY(1.2);
                    enlarge.play();
                }
            });

            setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ScaleTransition enlarge = new ScaleTransition(Duration.seconds(.15));
                    enlarge.setNode(background);
                    enlarge.setToX(1);
                    enlarge.setToY(1);
                    enlarge.play();
                }
            });
        }

        //Function for removing a tile from a rack
        private void RemoveTileFromRack(){
            setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    event.consume();
                    hideTiles(tileval);
                }
            });
        }
    }

    //Function for fade in transition of rack
    public FadeTransition fadeIn() {
        FadeTransition ft = new FadeTransition(Duration.seconds(5), this);

        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        return ft;
    }

    //Setting another transition for the rack
    public TranslateTransition RacKTransition2() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1));
        transition.setNode(this);

        if (onboard) {
            transition.setToX(-600);
            onboard = false;
        } else {
            transition.setToX(0);
            onboard = true;
        }
        return transition;
    }

    //Transition for the rack
    public TranslateTransition RacKTransition() {
        final RotateTransition rotateRack = new RotateTransition(Duration.seconds(3));

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(2));
        transition.setNode(this);

        //transition.setToX(-600);
        if (!onboard) {
            transition.setToX(600);
            onboard = true;
        } else {
            transition.setToX(-600);
            onboard = false;
        }
        return transition;
    }

    public void hideTiles2(Frame frame)
    {
        frame.display_frame();
        boolean flag = false;
        for(int i=0; i<gameRack.size(); i++)
        {
            for(int j = 0; j<frame.player_frame.size(); j++)
            {
                if(gameRack.get(i).tileval == frame.player_frame.get(j))
                {
                    flag = true;
                }
                if(!flag){gameRack.get(i).setVisible(false);}
            }

        }
    }

    public void hideTiles(Tile.letter x)
    {
        //Create a variable to store whether or not the letter is found in the array
        Boolean flag = false;
        //Iterate through player_frame

        for(int i = 0; i<gameRack.size(); i++)
        {
            if(gameRack.get(i).tileval ==x)
            {
                if(!gameRack.get(i).isVisible())
                {
                    continue;
                }
                gameRack.get(i).setVisible(false);

            }
            else continue;
            break;
        }
    }

    //Function for swapping tiles
    public Tile.letter SwapTile(Tile.letter tile, Tile.letter tilefrompool)
    {
        Tile.letter temp = null;
        for(int i =0; i<gameRack.size(); i++) {
            if (tile == gameRack.get(i).tileval) {
                temp = gameRack.get(i).tileval;
                gameRack.get(i).tileval = tilefrompool;
                break;
            }
        }
        displayRack();
        return temp;
    }

    //Displaying the rack
    public void displayRack()
    {
        for(int i = 0; i< gameRack.size(); i++)
        {

        }
    }

    public void displayRack2(Frame playerframe)
    {
        for(int i = 0; i< gameRack.size(); i++)
        {   gameRack.get(i).tileval = playerframe.player_frame.get(i);
            gameRack.get(i).background.setImage(gameRack.get(i).setImageTo(gameRack.get(i).tileval));
            gameRack.get(i).setVisible(true);
        }
    }
}

