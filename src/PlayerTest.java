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

        //Test
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
}