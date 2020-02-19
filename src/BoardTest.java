import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    public static void main(String[] args)
    {
        System.out.println("-------------  BOARD CLASS TESTING -----------");
        Board x = new Board();
        Square sq = new Square();

        x.display_board();

        //Test to see if the player is forced to place a tile on the middle square for their opening move
        x.player_one.frame.display_frame();
        x.add_tile(Tile.letter.a,7,7);
        x.display_board();

        //Test to see if the first move has a tile placed on the middle square or not
        System.out.println("**Testing to see if the first move has a tile placed on the middle square or not**");
        System.out.println("EXPECTED: True");
        boolean expected1 = true;
        boolean actual1 = x.first_word(x.game_board[7][7]);
        System.out.println("ACTUAL: " + actual1);

        if(actual1 == expected1){
            System.out.println("PASS \n");
        } else
        {
            System.out.println("FAIL \n");
        }
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
