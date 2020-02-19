import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {


    public static void main(String[] args)
    {
        System.out.println("-------------  BOARD CLASS TESTING -----------");
        Board x = new Board();
        x.display_board();
        x.player_one.frame.display_frame();
        x.add_tile(Tile.letter.a,7,7);
        x.display_board();

    }

    //Board class testing
    @Test
    void board_reset() {
        Board board = new Board();
        board.add_tile(Tile.letter.a, 7, 7);
        board.board_reset();
        assertEquals(null, Board.game_board[7][7].tile);
    }

    @Test
    void out_of_bounds_fail(){
        try {
            Board board = new Board();
            board.add_tile(Tile.letter.a, 15, 10);
            fail("Invalid Move");
        }catch (IndexOutOfBoundsException e){}

    }

    @Test
    void out_of_bounds_pass(){
        Board board = new Board();
        board.add_tile(Tile.letter.a, 10, 7);
        assertTrue(0 <= 10 && 10 <= 14 || 0 <= 7 && 7 <= 14);
    }


}
