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
    public Board board = new Board();

    private boolean hidden = true;

    private final String HELP_TEXT = "-fx-text-fill: purple;" + "-fx-font-family: \"Arial\"; -fx-text-fill: linear-gradient(black, #303108); -fx-font-size: 30px; -fx-padding: 6px 9px ";


    public ScrabbleHelp() {
        super(new StackPane(), 400, 550);
        prefHeight(400);
        prefWidth(550);
        Text text1  = new Text(HELP_TEXT);
        Text text2  = new Text(HELP_TEXT);
        Text text3 = new Text(HELP_TEXT);
        BackgroundImage background = new BackgroundImage(new Image(BACKGROUND,400,550,false,true), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        setFill(Color.WHITE);
        //Rectangle rec = new Rectangle(50,50);
        StackPane helproot = (StackPane) this.getRoot();
       

        helproot.setBackground(new Background(background));
        helproot.setEffect(new DropShadow());




        text1.setFill(Color.PURPLE);
        text2.setFill(Color.PURPLE);
        text3.setFill(Color.PURPLE);
        text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        text1.setStrokeWidth(2);
        text1.setStroke(Color.BLACK);
        text2.setFont(Font.font("Verdana", 12));
        text3.setFont(Font.font("Verdana", 12));
        text1.setX(10);
        text1.setY(50);
        text2.setX(30);
        text2.setY(0);
        text3.setX(400);
        text3.setY(0);
        text2.setTextAlignment(TextAlignment.CENTER);
        //text1.setTextAlignment(TextAlignment.CENTER);
        text1.setText("Scrabble Rules:");
        text2.setText("Scrabble is a two-player game and the objective\n when playing is to score more points than your\n" +
                " opponent does. When you have placed a word\n on the board, points are collected and added to \nyour overall score. The different" +
                " letters placed \non the board all contain different values and\n the aim is to play the words that will generate you \nthe highest" +
                " possible score based on letter \ncombinations. \n \n You also have an opportunity to place letters \non special squares such as “double letter, " +
                "double word,\n triple letter and triple word.” These allow you\n to collect more points as you play different words\n\nYou must begin the game " +
                "with the first player placing their\n first word over the star square in the centre of the board.\n\n ");
        text3.setText(" 0 Points - Blank tile.\n\n 1 Point - A, E, I, L, N, O, R, S, T and U \n\n2 Points - D and G.\n\n 3 Points - B, C, M and P.\n\n 4 Points - F, H, V, W and Y.\n\n5 Points - K.\n\n8 Points - J and X.\n\n10 Points - Q and Z.");
        text1.setUnderline(true);
        helproot.getChildren().add(text1);
        helproot.getChildren().add(text2);
        helproot.getChildren().add(text3);

        setLayoutX(300);
        setLayoutY(-600);



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
