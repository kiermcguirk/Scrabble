import javafx.scene.layout.StackPane;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.*;

public class Square extends StackPane {

    protected Tile.letter tile;
    protected enum square_type{normal, dub_w, dub_l, trip_w, trip_l, middle} //Square values
    protected square_type type; //Square value type


    private static final int SQUARE_SIZE = 40;
    private Rectangle border = new Rectangle(SQUARE_SIZE - 2, SQUARE_SIZE - 2);
    private Text text = new Text();


    public Square(int x, int y, Square.square_type type)
    {
        this.type = square_type.normal;
        this.tile = Tile.letter.empty;

        if(type == square_type.normal)
        {
            border.setFill(Color.BEIGE);
            text.setText("");
        }
        else if(type == square_type.dub_l)
        {
            border.setFill(Color.LIGHTBLUE);
            text.setText("Double Letter Score");
        }
        else if(type == square_type.trip_l)
        {
            border.setFill(Color.TURQUOISE);
            text.setText("Triple Letter Score");
        }
        else if(type == square_type.dub_w){
            border.setFill(Color.SALMON);
            text.setText("Double Word Score");
        }
        else if(type == square_type.trip_w){
            border.setFill(Color.DARKORANGE);
        }
        else
        {
            border.setFill(Color.SALMON);
            text.setText("*");
        }

        border.setStroke(Color.LIGHTGREY);

        getChildren().addAll(border,text);
        setTranslateX(x * SQUARE_SIZE);
        setTranslateY(y * SQUARE_SIZE);
    }

    //toString method to display square values on board
    @Override
    public String toString()
    {
        if(this.type == square_type.normal)
        {
            return "  ";
        }
        else if (this.type == square_type.middle)
        {
            return "**";
        }
        else if(this.type == square_type.dub_l)
        {
            return "DL";
        }
        else if(this.type == square_type.trip_l)
        {
            return "TL";
        }
        else if(this.type == square_type.dub_w)
        {
            return "DW";
        }
        else
        {
            return "TW";
        }
    }
}
