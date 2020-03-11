import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class ScrabbleHelp extends SubScene {
    private final static String BACKGROUND = "Images/borderbackground2.png";
    public Board board = new Board();

    public ScrabbleHelp() {
        super(new AnchorPane(), 600, 400);
        prefHeight(600);
        prefWidth(400);

        BackgroundImage background = new BackgroundImage(new Image(BACKGROUND,590,400,false,true), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        AnchorPane helproot = (AnchorPane) this.getRoot();
        helproot.setBackground(new Background(background));
        helproot.setEffect(new DropShadow());

        setLayoutX(100);
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
