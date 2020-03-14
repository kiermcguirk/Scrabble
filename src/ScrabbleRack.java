import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.transform.Rotate;
import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class ScrabbleRack extends SubScene {

    final Rotate rotateRack = new Rotate();
    final int RACK_X = 925;
    final int RACK_Y = 100;
    private final String STYLE_BUTTON_NORMAL = "-fx-background-color: linear-gradient(#CDC6B0, #CDC6B0); " +
            "-fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color:  linear-gradient(#988454, #988454);";

    private static final String RACK_BACKGROUND = "Images/Rack_Background.jpg";
    ArrayList<RackTile> gameRack = new ArrayList<>();

    private final String STYLE_RACK_BACKGROUND = "-";



    public ScrabbleRack(Frame playerframe) {
        super(new Pane(), 472, 80);


        BackgroundImage background = new BackgroundImage(new Image(RACK_BACKGROUND,472,80,false,true), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        Pane rackroot = (Pane) this.getRoot();

      rackroot.setBackground(new Background(background));


        for(int i = 0; i< playerframe.player_frame.size(); i++)
        {
            createRackSquare(playerframe.player_frame.get(i));
            rackroot.getChildren().add(gameRack.get(i));
        }
        rackroot.getTransforms().add(rotateRack);
        setLayoutX(100);
        setLayoutY(580);
        setEffect(new DropShadow());

    }

    private void addRackSquares(RackTile rack){
        rack.setLayoutX(getLayoutX() + gameRack.size() * 51);
        rack.setLayoutY(10);
        //rack.setLayoutY(10);
        gameRack.add(rack);
    }


    public void createRackSquare(Tile.letter text){
        RackTile Rack = new RackTile(text);
        Rack.EventListenersInit();
        addRackSquares(Rack);

    }


    private class RackTile extends StackPane{
        private static final int RACK_TILE_SIZE = 50;
        Rectangle border = new Rectangle(RACK_TILE_SIZE,RACK_TILE_SIZE);
        private Tile.letter tileval;
        private ImageView background;

        public RackTile(Tile.letter tile){
           //System.out.println(getScaleX() + " " +getHeight());
            setEffect(new DropShadow());
            EventListenersInit();
            switch (tile){
                case a: background = new ImageView(new Image("Images/Alphabet/A.jpg",50,50,false,true));
                    break;
                case b: background = new ImageView(new Image("Images/Alphabet/B.png",50,50,false,true));
                    break;
                case c: background = new ImageView(new Image("Images/Alphabet/C.png",50,50,false,true));
                    break;
                case d: background = new ImageView(new Image("Images/Alphabet/D.png",50,50,false,true));
                    break;
                case e: background = new ImageView(new Image("Images/Alphabet/E.png",50,50,false,true));
                    break;
                case f: background = new ImageView(new Image("Images/Alphabet/F.png",50,50,false,true));
                    break;
                case g: background = new ImageView(new Image("Images/Alphabet/G.jpg",50,50,false,true));
                    break;
                case h: background = new ImageView(new Image("Images/Alphabet/H.png",50,50,false,true));
                    break;
                case i: background =new ImageView(new Image("Images/Alphabet/I.jpg",50,50,false,true));
                    break;
                case j: background = new ImageView(new Image("Images/Alphabet/J.png",50,50,false,true));
                    break;
                case k: background = new ImageView(new Image("Images/Alphabet/K.jpg",50,50,false,true));
                    break;
                case l: background = new ImageView(new Image("Images/Alphabet/L.jpg",50,50,false,true));
                    break;
                case m: background = new ImageView(new Image("Images/Alphabet/M.jpg",50,50,false,true));
                    break;
                case n: background = new ImageView(new Image("Images/Alphabet/N.png",50,50,false,true));
                    break;
                case o: background = new ImageView(new Image("Images/Alphabet/O.jpg",50,50,false,true));
                    break;
                case p: background = new ImageView(new Image("Images/Alphabet/P.png",50,50,false,true));
                    break;
                case q: background = new ImageView(new Image("Images/Alphabet/Q.jpg",50,50,false,true));
                    break;
                case r: background = new ImageView(new Image("Images/Alphabet/R.png",50,50,false,true));
                    break;
                case s: background = new ImageView(new Image("Images/Alphabet/S.jpg",50,50,false,true));
                    break;
                case t: background = new ImageView(new Image("Images/Alphabet/T.png",50,50,false,true));
                    break;
                case u: background = new ImageView(new Image("Images/Alphabet/U.png",50,50,false,true));
                    break;
                case v: background = new ImageView(new Image("Images/Alphabet/V.png",50,50,false,true));
                    break;
                case w: background = new ImageView(new Image("Images/Alphabet/W.jpg",50,50,false,true));
                    break;
                case x: background = new ImageView(new Image("Images/Alphabet/X.png",50,50,false,true));
                    break;
                case y: background = new ImageView(new Image("Images/Alphabet/Y.jpg",50,50,false,true));
                    break;
                case z: background = new ImageView(new Image("Images/Alphabet/Z.jpg",50,50,false,true));
                    break;
                case blank: background = new ImageView(new Image("Images/Alphabet/blank.png",50,50,false,true));
                    break;
                  }
        getChildren().add(background);
        }

        private void EventListenersInit() {
            setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ScaleTransition enlarge = new ScaleTransition(Duration.seconds(.15));
                    enlarge.setNode(background);
                    enlarge.setToX(1.5);
                    enlarge.setToY(1.5);
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
    }

    public FadeTransition fadeIn()
    {
        FadeTransition ft = new FadeTransition(Duration.seconds(5), this);

        ft.setFromValue(0.0);
        ft.setToValue(1.0);

        return ft;
    }

    public void offBoardTransition()
    {

        rotateRack.setPivotX(this.getLayoutX());
        rotateRack.setPivotY(this.getLayoutY());
        rotateRack.setAngle(rotateRack.getAngle() - 180);

        /*
        rotateRack.setAxis(Rotate.Y_AXIS);
        rotateRack.setFromAngle(0);
        rotateRack.setToAngle(360);
        rotateRack.setInterpolator(Interpolator.LINEAR);
         */
        TranslateTransition moveRack = new TranslateTransition();
        moveRack.setNode(this);
        moveRack.setDuration(Duration.seconds(5));


        //return new ParallelTransition(moveRack,rotateRack);
    }

    public ParallelTransition onBoardTransition()
    {
        return null;
    }
}
