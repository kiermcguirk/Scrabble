import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.scene.layout.StackPane;

import java.awt.*;


public class ScrabbleHelp extends SubScene {
    private final static String BACKGROUND = "Images/borderbackground.png";

    private boolean hidden = true;

    //Characteristics of text in "Help"
    private final String HELP_TEXT = "-fx-text-fill: purple;" + "-fx-font-family: \"Arial\"; -fx-text-fill: linear-gradient(black, #303108); -fx-font-size: 30px; -fx-padding: 6px 9px ";

    //Setting prefixes for the pane
    public ScrabbleHelp() {
        super(new StackPane(), 400, 550);
        prefHeight(400);
        prefWidth(550);
        Text text  = new Text(HELP_TEXT);

        BackgroundImage background = new BackgroundImage(new Image(BACKGROUND,400,550,false,true), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        setFill(Color.WHITE);
        //Rectangle rec = new Rectangle(50,50);
        StackPane helproot = (StackPane) this.getRoot();

        helproot.setBackground(new Background(background));
        helproot.setEffect(new DropShadow());

        text.setFill(Color.PURPLE);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

        text.setX(10);
        text.setY(50);

        text.setTextAlignment(TextAlignment.CENTER);

        //The text inside the "Help" pane once button is pressed
        text.setText("SCRABBLE RULES: \n\nScrabble is a two-player game and the objective\n when playing is to score more points than your\n" +
                " opponent does. When you have placed a word\n on the board, points are collected and added to \nyour overall score. The different" +
                " letters placed \non the board all contain different values and\n the aim is to play the words that will generate you \nthe highest" +
                " possible score based on letter \ncombinations. \n \n You also have an opportunity to place letters \non special squares such as “double letter, " +
                "double word,\n triple letter and triple word.” These allow you\n to collect more points as you play different words.\n\nThe first player must begin the game by" +
                " placing their\n  word over the star square in the centre of the board.\n\n0 Points - Blank tile.\n\n 1 Point - " +
                "A, E, I, L, N, O, R, S, T and U \n\n2 Points - D and G.\n\n 3 Points - B, C, M and P.\n\n 4 Points - F, H, V, W and Y.\n\n5 Points - K." +
                "\n\n8 Points - J and X.\n\n10 Points - Q and Z ");

        helproot.getChildren().add(text);

        setLayoutX(300);
        setLayoutY(-600);
    }


    //Transition set to when help button is pressed
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
