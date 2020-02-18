import java.util.ArrayList;

public class Player {

    //Instance variables
    protected String player_name;
    protected int player_score;

    //A5 - Allows access to a players frame (tiles)
    protected Frame frame = new Frame();

    //A1 - Allows the player data to be reset
    public void data_reset()
    {
        player_name = null;
        player_score = 0;
    }

    public Player(String name)
    {
        this.player_name = name;
        player_score = 0;
    }

    //A2 - Allows the name of the player to be set
    public void setName(String newName) {
        this.player_name = newName;
    }
    public String getName() {
        return player_name;
    }


    //A3 - Allows a player�s score to be increased
    public int increase_score(ArrayList<Tile.letter> score_list)
    {
        Pool find_tile_value = new Pool();
        int score = 0;

        for (Tile.letter x : score_list )
        {
            score += find_tile_value.queried_tile(x);
        }
        return score;
    }


    //A4 - Allows access to their score
    public void display_score()
    {
        System.out.println(this.player_name + "'s score is: " + this.player_score);
    }

    //Get score
    public int getScore() {return player_score;}

    //A6 - Allows display of a players name
    public void display_name()
    {
        System.out.println(player_name);
    }
}
