public class BoardTest {



    public static void main(String[] args)
    {
        Board x = new Board();
        x.display_board();
        x.player_one.frame.display_frame();
        x.add_tile(Tile.letter.a,7,7);
        x.display_board();
    }
}
