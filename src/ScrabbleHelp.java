import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ScrabbleHelp extends SubScene {
    private final static String BACKGROUND = "Images/borderbackground2.png";
    public Board board = new Board();

    public ScrabbleHelp() {
        super(new AnchorPane(), 400, 550);
        prefHeight(300);
        prefWidth(550);

        BackgroundImage background = new BackgroundImage(new Image(BACKGROUND,400,550,false,true), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        setFill(Color.WHITE);


        AnchorPane helproot = (AnchorPane) this.getRoot();

        helproot.setBackground(new Background(background));
        helproot.setEffect(new DropShadow());

        setLayoutX(300);
        setLayoutY(-600);

    }


    public void Transition()
    {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.4));

        transition.setNode(this);

        //transition.setToX(-600);
        transition.setToY(600);


        transition.play();

    }
}
