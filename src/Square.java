public class Square {

    protected Tile.letter tile;
    protected enum square_type{normal, dub_w, dub_l, trip_w, trip_l, middle}
    protected square_type type;

    public Square()
    {
        this.type = square_type.normal;
        this.tile = Tile.letter.blank;
    }
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
            return "dl";
        }
        else if(this.type == square_type.trip_l)
        {
            return "tl";
        }
        else if(this.type == square_type.dub_w)
        {
            return "dw";
        }
        else
        {
            return "tw";
        }
    }
}
