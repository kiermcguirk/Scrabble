import java.awt.*;

public class Square extends Rectangle {

    protected Tile.letter tile;
    protected enum square_type{normal, dub_w, dub_l, trip_w, trip_l, middle} //Square values
    protected square_type type; //Square value type

    public Square()
    {
        this.type = square_type.normal;
        this.tile = Tile.letter.empty;

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
