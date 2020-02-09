import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    public static void main(String[] args) {

        System.out.println("-------------  PLAYER CLASS TESTING -----------");

        System.out.println("**Testing the creation of a Player object. The player object should have a name, and an initial score of 0**");

        Player Jennifer = new Player("Jennifer");
        System.out.println("EXPECTED: Jennifer's initial score is: 0");
        System.out.println("ACTUAL: " + Jennifer.getName() + "'s initial score is: " + Jennifer.getScore());
        boolean player_object_test = false;
        if (Jennifer.getName() == "Jennifer" && Jennifer.getScore() == 0) {
            player_object_test = true;
        }
        if (player_object_test) {
            System.out.println("PASS \n");
        } else {
            System.out.println("FAIL \n");
        }

        //Test player incrementing score
        System.out.println("**Testing that a player's score is incremented correctly**");
        System.out.println("EXPECTED: Player score is increased by 7 (word is 'abc')");

        ArrayList<Tile.letter> test = new ArrayList<Tile.letter>();
        test.add(Tile.letter.a);
        test.add(Tile.letter.b);
        test.add(Tile.letter.c);

        int actual2 = Jennifer.increase_score(test);
        int expected2 = 7;

        System.out.println("ACTUAL: Player score is increased by " + actual2 + " (word is 'abc')");

        if (expected2 == actual2) {
            System.out.println("PASS \n");
        } else {
            System.out.println("FAIL \n");
        }

        //Test player reset DATA
        System.out.println("**Testing that player's data can be reset **");

        Jennifer.data_reset();
        System.out.println("EXPECTED: score = 0, name = null");
        System.out.println("ACTUAL: score = "+ Jennifer.getScore() + ", name = "+Jennifer.getName());

        if (Jennifer.player_score == 0 && Jennifer.player_name == null) {
            System.out.println("PASS \n");
        } else {
            System.out.println("FAIL \n");
        }

        System.out.println("-------------  FRAME CLASS TESTING -----------");

        //Test that player object has a frame of 7 random letters from the pool
        System.out.println("**Testing that player object has a frame, and the frame has 7 random letters from the pool**");
        System.out.print("EXPECTED: ");
        String expected4 = "7 letters in pool 93 remaining in pool";
        System.out.println(expected4);
        System.out.print("ACTUAL: ");
        String actual4 = Jennifer.frame.player_frame.size() + " letters in pool " + Pool.game_pool.pool.size() + " remaining in pool";
        System.out.println(actual4);

        if (Jennifer.frame.player_frame.size() == 7 && Pool.game_pool.pool.size() == 93) {
            System.out.println("PASS \n");
        } else
        {
            System.out.println("FAIL \n");
        }

        //Tests that a frame can be displayed
        System.out.println("**Testing that a frame can be displayed**");
        System.out.println("EXPECTED: x x x x x x x (where x is a random letter");
        int expected5 = 7;
        System.out.println("ACTUAL: ");
        Jennifer.frame.display_frame();
        int actual5 = 7;

        if(actual5 == expected5){
            System.out.println("\nPASS \n");
        } else
        {
            System.out.println("\nFAIL \n");
        }

        //Test that a letter can be checked to see if it is in the frame
        System.out.println("**Testing that a letter can be checked to see if it is in the frame**");
        System.out.println("--Current letters in frame: ");
        Jennifer.frame.display_frame();

        System.out.println("\n--Testing to see if 'a' is in the frame");
        System.out.println("EXPECTED: true/false depending if 'a' is in the frame");
        boolean actual6 = Jennifer.frame.letter_in_frame(Tile.letter.a);
        System.out.println("ACTUAL: " + actual6 + "\n");


        //Test that a letter can be removed from the frame
        System.out.println("**Testing that a letter can be removed from the frame**");
        System.out.println("--Current letters in frame: ");
        Jennifer.frame.display_frame();
        System.out.println("\nEXPECTED: if letter is in frame, the frame should be one letter less and not include that letter, otherwise, do nothing");
        int expected7;
        int actual7;
        if(Jennifer.frame.letter_in_frame(Tile.letter.a))
        {
            expected7 = 6;
            Jennifer.frame.remove_letter(Tile.letter.a);
            actual7 = Jennifer.frame.player_frame.size();
        }
        else
        {
            expected7 = 7;
            Jennifer.frame.remove_letter(Tile.letter.a);
            actual7 = Jennifer.frame.player_frame.size();
        }

        System.out.println("--New letters in frame: ");
        Jennifer.frame.display_frame();

        if(actual7 == expected7){
            System.out.println("\nPASS \n");
        } else
        {
            System.out.println("\nFAIL \n");
        }


        //Test to see if the frame is empty or not
        System.out.println("**Testing to see if the frame is empty or not**");
        System.out.println("EXPECTED: false (initially the frame will never be empty)");
        boolean expected8 = false;
        boolean actual8 = Jennifer.frame.is_frame_empty();
        System.out.println("ACTUAL: " + actual8);

        if(actual8 == expected8){
            System.out.println("PASS \n");
        } else
        {
            System.out.println("FAIL \n");
        }

        //Test to see if the frame can be refilled
        System.out.println("**Testing to see if the frame can be refilled**");
        System.out.println("--Current letters in frame: ");
        Jennifer.frame.display_frame();
        System.out.println("\nEXPECTED: a frame full of seven letters, if frame was already full, a notification should appear");
        int expected9 = 7;
        Jennifer.frame.refill_frame();
        int actual9 = Jennifer.frame.player_frame.size();
        System.out.println("--New letters in frame: ");
        Jennifer.frame.display_frame();

        if(actual9 == expected9){
            System.out.println("\nPASS \n");
        } else
        {
            System.out.println("\nFAIL \n");
        }

    }


    //Player Class Testing
    @Test
    void data_reset() {
        //Cerate player object
        Player x = new Player("Kier");
        ArrayList<Tile.letter> test = new ArrayList<Tile.letter>();
        test.add(Tile.letter.a);
        x.increase_score(test);
        x.data_reset();
        assertEquals(null, x.getName());
        assertEquals(0, x.getScore());
    }

    @Test
        //See if constructor creates objects correctly
    void player() {
        //Create new player object x and name it abcd
        Player x = new Player("Abcd");
        assertEquals("Abcd", x.getName()); //Check to see if the name is correct
        assertEquals(0, x.getScore()); //Check if score is initialized to 0
    }

    @Test
    void increase_score() {
        //Create new player object
        Player Kier = new Player("Kier");

        ArrayList<Tile.letter> test = new ArrayList<Tile.letter>();
        test.add(Tile.letter.a);
        test.add(Tile.letter.b);
        test.add(Tile.letter.c);

        int result = Kier.increase_score(test);
        assertEquals(7, result);
    }


    @Test
    void display_score_and_name() {
        //Create new player obkect
        Player kier = new Player("kier");
        assertEquals("kier 0", kier.getName() + " " + kier.getScore());
    }

    //Frame class testing
    //A1 - Stores the letters that each player has in their frame
    @Test
    void player_frame_test() {
        //Create player object
        Player Aman = new Player("Aman");

        //Check to see if Player Aman has seven letters in his frame
        assertEquals(Aman.frame.player_frame.size(), 7);
    }

    //A2 - Allows letters to be removed from the frame
    @Test
    void remove_letter() {
        //Create frame object
        Frame Aman = new Frame();

        //Remove letter 'a' from frame
        Aman.remove_letter(Tile.letter.a);

        //Check to see if there is one less letter in frame
        assertEquals(Aman.player_frame.size(), 6);
    }
}