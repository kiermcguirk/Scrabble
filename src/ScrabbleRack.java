import javafx.scene.layout.StackPane;


public class ScrabbleRack extends StackPane {


    private final String STYLE_BUTTON_NORMAL = "-fx-background-color: linear-gradient(#CDC6B0, #CDC6B0); " +
            "-fx-background-radius: 10; -fx-border-radius: 10; -fx-border-color:  linear-gradient(#988454, #988454);";




    private final String STYLE_RACK_BACKGROUND = "-";

    public ScrabbleRack(String text) {

        setPrefHeight(50);
        setPrefWidth(50);
        setStyle(STYLE_BUTTON_NORMAL);
        setLayoutY(getLayoutY() + 100);
        setLayoutX(getLayoutX() + 925);



    }













}
