import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class ScrabbleRack extends SubScene {


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



        for(int i = 0; i<playerframe.player_frame.size(); i++)
        {
            createRackSquare(playerframe.player_frame.get(i));
            rackroot.getChildren().add(gameRack.get(i));
        }

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
        addRackSquares(Rack);

    }
    // Jennifer is an !!elephant (doudble negation) = elephant  :( you mad bro ?NO 8=D~~     o:





    private class RackTile extends StackPane{

        private static final int RACK_TILE_SIZE = 50;


        private Tile.letter tileval;
        private ImageView background;

        public RackTile(Tile.letter tile){

            setEffect(new DropShadow());
            switch (tile){
                case a: background = new ImageView(new Image("Images/Alphabet/A.png",50,50,false,true));
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
                case g: background = new ImageView(new Image("Images/Alphabet/G.png",50,50,false,true));
                    break;
                case h: background = new ImageView(new Image("Images/Alphabet/H.png",50,50,false,true));
                    break;
                case i: background =new ImageView(new Image("Images/Alphabet/I.png",50,50,false,true));
                    break;
                case j: background = new ImageView(new Image("Images/Alphabet/J.png",50,50,false,true));
                    break;
                case k: background = new ImageView(new Image("Images/Alphabet/K.png",50,50,false,true));
                    break;
                case l: background = new ImageView(new Image("Images/Alphabet/L.png",50,50,false,true));
                    break;
                case m: background = new ImageView(new Image("Images/Alphabet/M.png",50,50,false,true));
                    break;
                case n: background = new ImageView(new Image("Images/Alphabet/N.png",50,50,false,true));
                    break;
                case o: background = new ImageView(new Image("Images/Alphabet/O.png",50,50,false,true));
                    break;
                case p: background = new ImageView(new Image("Images/Alphabet/P.png",50,50,false,true));
                    break;
                case q: background = new ImageView(new Image("Images/Alphabet/Q.png",50,50,false,true));
                    break;
                case r: background = new ImageView(new Image("Images/Alphabet/R.png",50,50,false,true));
                    break;
                case s: background = new ImageView(new Image("Images/Alphabet/S.png",50,50,false,true));
                    break;
                case t: background = new ImageView(new Image("Images/Alphabet/T.png",50,50,false,true));
                    break;
                case u: background = new ImageView(new Image("Images/Alphabet/U.png",50,50,false,true));
                    break;
                case v: background = new ImageView(new Image("Images/Alphabet/V.png",50,50,false,true));
                    break;
                case w: background = new ImageView(new Image("Images/Alphabet/W.png",50,50,false,true));
                    break;
                case x: background = new ImageView(new Image("Images/Alphabet/X.png",50,50,false,true));
                    break;
                case y: background = new ImageView(new Image("Images/Alphabet/Y.png",50,50,false,true));
                    break;
                case z: background = new ImageView(new Image("Images/Alphabet/Z.png",50,50,false,true));
                    break;
                case blank: background = new ImageView(new Image("Images/Alphabet/blank.png",50,50,false,true));
                    break;
                  }
        getChildren().addAll(background);
        }
    }
}
