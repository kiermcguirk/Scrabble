import java.util.ArrayList;

public class Frame {

    //A1 - Stores the letters that each player has in their frame
    //Protected ArrayList of type letter
    protected ArrayList<Tile.letter> player_frame = new ArrayList<Tile.letter>();
    public ArrayList<Tile.letter> prevRack = new ArrayList<>();

    //A2 - Allows letters to be removed from a frame
    public void remove_letter(Tile.letter x)
    {
        //Create a variable to store whether or not the letter is found in the array
        Boolean flag = false;
        //Iterate through player_frame

        for (Tile.letter y : player_frame )
        {
            //If the current letter is the letter being removed
            if(y == x)
            {
                //Remove current letter
                player_frame.remove(y);
                flag = true;
            }
            else
            {
                continue;
            }
            break;
        }
        if(!flag)
        {
            System.out.println(x + " is not in your frame, therefore it cannot be removed");
        }

    }


    //A6 - Allows a frame to be refilled from the pool
    public void refill_frame()
    {
        //If frame is full already, notify the user that they cannot refill the pool
        if(this.player_frame.size() == 7)
        {
            System.out.println("The frame is already full, therefore it cannot be refilled");
        }
        //Add to array list until the player has 7 letters
        while(player_frame.size() != 7)
        {
            player_frame.add(Pool.game_pool.draw());
        }

    }

    public Frame()
    {
        refill_frame();
        //System.out.println("refilling frame");
        //For testing purposes we are hardcoding the letters in the frame for this assignment
        //test_values();
    }

    //Testing with the word "apple"
    public void test_values()
    {
        player_frame.clear();
        player_frame.add(Tile.letter.a);
        player_frame.add(Tile.letter.a);
        player_frame.add(Tile.letter.a);
        player_frame.add(Tile.letter.a);
        player_frame.add(Tile.letter.a);
        player_frame.add(Tile.letter.a);
        player_frame.add(Tile.letter.a);
    }




    //A3 - Allows a check to be made if letters are in the frame
    public boolean letter_in_frame (Tile.letter x)
    {
        //For each letter in player_frame
        for (Tile.letter y : player_frame )
        {
            //If the current letter is the letter being checked for, return true
            if(y == x) return true;
        }
        //Otherwise return false
        return false;
    }

    //A4 - Allows a check to be made to see if the frame is empty
    public boolean is_frame_empty()
    {
        //IF the player_frame is empty return true, else return false
        if(player_frame.isEmpty()) return true;
        else return false;
    }

    //A7 - Allows a frame to be displayed
    public void display_frame()
    {
        for (Tile.letter x : player_frame)
        {
            System.out.print(x + " ");
        }
    }



    //Function to swap tiles
    public void SwapTile(Tile.letter tile, Tile.letter tilefrompool)
    {
        for(int i =0; i<player_frame.size(); i++) {
            if (tile == player_frame.get(i)) {
                player_frame.set(i,tilefrompool);
                break;
            }
        }
    }

    public void revertRack()
    {
        boolean found = false;
        for(int i =0; i<prevRack.size(); i++)
        {
            for(int j = 0; j<player_frame.size(); j++)
            {
                if(prevRack.get(i) == player_frame.get(j)) found = true;
                break;
            }
            if(!found)
                Pool.game_pool.pool.add(prevRack.get(i));

            found = false;
        }
        player_frame.clear();

        for (Tile.letter tile: prevRack) {
            player_frame.add(tile);
        }
    }



}
