import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class ScrabbleHelp extends SubScene {
    private final static String BACKGROUND = "Images/borderbackground.png";
    public Board board = new Board();

    private boolean hidden = true;

    public ScrabbleHelp() {
        super(new AnchorPane(), 400, 550);
        prefHeight(400);
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

    private void setFontStyle() {
        setFont(Font.font("Verdana", 12));
    }

   private void AddText(String Text){
      ScrabbleHelp add_text = new ScrabbleHelp();
      add_text.AddText("Hi");
    }

    public void Transition() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1));

        transition.setNode(this);

        //transition.setToX(-600);

        if (hidden) {
            transition.setToY(600);
            hidden = false;
        } else {
            transition.setToY(-600);
            hidden = true;
        }


        transition.play();

    }
}
