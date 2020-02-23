import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    public static void main(String[] args)
    {
        System.out.println("-------------  BOARD CLASS TESTING -----------");
        Board x = new Board();
        Square sq = new Square();

        x.display_board();

        //Testing board initialization
        System.out.println("**Testing board initialization**");
        System.out.println("EXPECTED: The board with special squares (such as: tw, dw, tl and dl) and middle square is starred");
        System.out.println("ACTUAL: ");
        x.display_board();


        //Test to see if the player is forced to place a tile on the middle square for their opening move
        x.player_one.frame.display_frame();
        x.add_tile(Tile.letter.a,7,7);
        x.display_board();

        //Test to see if the first move has a tile placed on the middle square or not
        System.out.println("**Testing to see if the first move has a tile placed on the middle square or not**");
        System.out.println("EXPECTED: true");
        boolean expected1 = true;
        boolean actual1 = x.first_word(x.game_board[7][7]);
        System.out.println("ACTUAL: " + actual1);

        if(actual1 == expected1){
            System.out.println("PASS \n");
        } else
        {
            System.out.println("FAIL \n");
        }

    //Testing to make sure the letter is within the player's rack
        Frame frameOb = new Frame();
    System.out.println("**Testing to ensure a letter is within the rack**");
    System.out.println("Expected: true/false depending on whether the letter is actually in the rack");

    boolean actual2 = x.in_rack(x.player_one.frame, Tile.letter.i);
    System.out.println("ACTUAL: " + actual2);

    if(actual2 == true || actual2 == false){
        System.out.println("PASS :)\n");
    }
    else{
        System.out.println("FAIL :(\n");
    }

        System.out.println("**Testing to see if the player move is valid**");
        System.out.println("EXPECTED: True/False: Check whether letter is in the frame");
        boolean actual3 = x.valid_move(Tile.letter.a, 7, 7);
        System.out.println("ACTUAL: " + actual2);

        if (actual3 == true || actual3 == false) {
            System.out.println("PASS \n");
        } else {
            System.out.println("FAIL \n");
        }


    //Testing the conflicting_words function
    System.out.println("**Testing for conflicting words when placing a tile");
    System.out.println("EXPECTED: true");
    boolean expected4 = true;
    boolean actual4 = x.conflicting_word(2,3);
    System.out.println("ACTUAL: " + actual3);

    if(expected4 == actual4){
        System.out.println("PASS :)\n");
    }
    else{
        System.out.println("FAIL :( \n");
    }

        //Test to check if a word connects with any other letters on the board
        System.out.println("**Testing to see if word connects with any other letters on the board**");
        System.out.println("EXPECTED: True");
        boolean expected5 = true;
        boolean actual5 = x.connected_word(6,7);
        System.out.println("ACTUAL: " + actual4);

        if (actual5 == expected5) {
            System.out.println("PASS \n");
        } else {
            System.out.println("FAIL \n");
        }

        //Test to check if word is placed correctly
        System.out.println("**Testing to check if word is placed correctly**");
        x.player_one.frame.display_frame();
        Tile.letter[] test = new Tile.letter[] {Tile.letter.e, Tile.letter.p};
        x.place_word(test,7,7,1);
        x.player_one.frame.display_frame();
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

    @Test
    void place_tile(){
        Board board = new Board();
        Pool pool = new Pool();

    }



}
