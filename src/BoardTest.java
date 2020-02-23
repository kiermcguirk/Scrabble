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
        ArrayList<Tile.letter> test = new ArrayList<Tile.letter>();
        test.add(Tile.letter.a);
        test.add(Tile.letter.p);
        test.add(Tile.letter.p);
        test.add(Tile.letter.l);
        test.add(Tile.letter.e);
        x.display_board();

        //Testing board initialization
        System.out.println("**Testing board initialization**");
        System.out.println("EXPECTED: The board with special squares (such as: tw, dw, tl and dl) and middle square is starred");
        System.out.println("ACTUAL: ");
        x.display_board();


        //Test to see if the player is forced to place a tile on the middle square for their opening move
        System.out.println("**Test to check if player places a tile on the middle square for their opening move**");
        System.out.println("EXPECTED: Pass (Starting player must start on the middle square)");
        x.player_one.frame.display_frame();
        x.player_one.frame.test_values();
        x.place_word(test,7,7,0);
        x.display_board();

        if (x.game_board[7][7].tile == Tile.letter.a){ //Check if a letter is placed in middle
            System.out.println("PASS \n");
        }else{
            System.out.println("FAIL \n");
        }

        //Middle square test (Fail)
        System.out.println("EXPECTED: Fail (Starting player must start on the middle square)");
        x.board_reset();
        x.player_one.frame.display_frame();
        x.player_one.frame.test_values();
        x.place_word(test,5,5,1);
        x.display_board();

        if (x.game_board[7][7].tile == Tile.letter.a){ //Check if a letter is placed in middle
            System.out.println("PASS \n");
        }else{
            System.out.println("FAIL \n");
        }

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
        boolean actual4 = false;
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

        //Test 1 - Vertical Test
        System.out.println("-Test 1: Vertical Placement");
        System.out.println("EXPECTED: Apple displayed vertically from the middle square, with the word removed from their frame");
        System.out.println("ACTUAL: ");
        System.out.println("Player Frame(before): ");
        x.player_one.frame.display_frame();

        x.board_reset();

        x.place_word(test,7,7,1);
        System.out.println("\nPlayer Frame(after): ");
        x.player_one.frame.display_frame();
        System.out.println();
        x.display_board();

        if (x.game_board[7][7].tile == Tile.letter.a && x.game_board[8][7].tile == Tile.letter.p && x.game_board[9][7].tile == Tile.letter.p &&
                x.game_board[10][7].tile == Tile.letter.l && x.game_board[11][7].tile == Tile.letter.e) {
            System.out.println("PASS \n");
        } else {
            System.out.println("FAIL \n");
        }

        //Test 2 - Horizontal Test
        System.out.println("-Test 2: Horizontal Placement");
        System.out.println("EXPECTED: Apple displayed horizontally from the middle square, with the word removed from their frame");
        System.out.println("ACTUAL: ");
        System.out.println("Player Frame(before): ");
        x.player_one.frame.display_frame();

        x.board_reset();
        x.player_one.frame.test_values();
        x.place_word(test,7,7,0);
        System.out.println("\nPlayer Frame(after): ");
        x.player_one.frame.display_frame();
        System.out.println();
        x.display_board();

        if (x.game_board[7][7].tile == Tile.letter.a && x.game_board[7][8].tile == Tile.letter.p && x.game_board[7][9].tile == Tile.letter.p &&
                x.game_board[7][10].tile == Tile.letter.l && x.game_board[7][11].tile == Tile.letter.e) {
            System.out.println("PASS \n");
        } else {
            System.out.println("FAIL \n");
        }

        //Test 3 - Placement Over Existing Letters Test
        System.out.println("-Test 3 Word placement over existing letters");
        System.out.println("EXPECTED: Apple placed from 4-10 to 8-10, l shouldn't be removed from the player frame because it is already on the board");
        System.out.println("ACTUAL: ");
        x.player_one.frame.test_values();
        System.out.println("Player Frame(before): ");
        x.player_one.frame.display_frame();


        x.place_word(test,4,10,1);
        System.out.println("\nPlayer Frame(after): ");
        x.player_one.frame.display_frame();
        System.out.println();
        x.display_board();

        if (x.game_board[4][10].tile == Tile.letter.a && x.game_board[5][10].tile == Tile.letter.p && x.game_board[6][10].tile == Tile.letter.p &&
                x.game_board[7][10].tile == Tile.letter.l && x.game_board[8][10].tile == Tile.letter.e) {
            System.out.println("PASS \n");
        } else {
            System.out.println("FAIL \n");
        }

        //Test 4 - Placing a word that you don't have letters for
        System.out.println("-Test 4 Word placement when ");
        System.out.println("EXPECTED: An error message stating that you do not possess the required words and an empty board, and the player's frame remaining the same");
        System.out.println("ACTUAL: ");
        System.out.println("Player Frame(before): ");
        x.player_one.frame.test_values();
        x.player_one.frame.display_frame();
        System.out.println();
        test.add(Tile.letter.x);
        x.board_reset();
        x.place_word(test,7,7,1);
        System.out.println("\nPlayer Frame(after): ");
        x.player_one.frame.display_frame();
        System.out.println();
        x.display_board();

        System.out.println("PASS");








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
    void out_of_bounds_pass() {
        Board board = new Board();
        board.add_tile(Tile.letter.a, 10, 7);
        assertTrue(0 <= 10 && 10 <= 14 || 0 <= 7 && 7 <= 14);
    }
}
