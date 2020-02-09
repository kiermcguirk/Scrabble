import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Random;

public class Pool
{
    //A1 - Stores the values of each tile
    public static int[] score = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10,0};
    public static Tile.letter[] tile_array = new Tile.letter[] {Tile.letter.a, Tile.letter.b,
            Tile.letter.c, Tile.letter.d, Tile.letter.e, Tile.letter.f, Tile.letter.g, Tile.letter.h,
            Tile.letter.i, Tile.letter.j, Tile.letter.k, Tile.letter.l, Tile.letter.m, Tile.letter.m,
            Tile.letter.o, Tile.letter.p, Tile.letter.q, Tile.letter.r, Tile.letter.s, Tile.letter.t,
            Tile.letter.u, Tile.letter.v, Tile.letter.w, Tile.letter.x, Tile.letter.y, Tile.letter.z,
            Tile.letter.blank};

    //A2 - Stores the tile currently in the pool
    public ArrayList<Tile.letter> pool = new ArrayList<Tile.letter>();

    public static Pool game_pool = new Pool();

    //A3 - Allows the pool to be reset
    public void pool_reset() {


        //Clear the pool
        pool.clear();

        //Add letters that are found only once in the pool
        pool.add(Tile.letter.j);
        pool.add(Tile.letter.k);
        pool.add(Tile.letter.q);
        pool.add(Tile.letter.x);
        pool.add(Tile.letter.z);


        //Add letters that appear 9 times in the pool
        for(int i=1; i<=9; i++)
        {
            pool.add(Tile.letter.a);
            pool.add(Tile.letter.i);
        }

        //Add letters that appear 12 times in the pool
        for(int i=1; i<=12; i++)
        {
            pool.add(Tile.letter.e);
        }

        //Add letters that are found twice in the pool
        for(int i=1; i<=2; i++)
        {
            pool.add(Tile.letter.b);
            pool.add(Tile.letter.c);
            pool.add(Tile.letter.f);
            pool.add(Tile.letter.h);
            pool.add(Tile.letter.m);
            pool.add(Tile.letter.p);
            pool.add(Tile.letter.v);
            pool.add(Tile.letter.w);
            pool.add(Tile.letter.y);
            pool.add(Tile.letter.blank);
        }

        //Add letters that are found four times in the pool
        for(int i=1; i<=4; i++)
        {
            pool.add(Tile.letter.d);
            pool.add(Tile.letter.l);
            pool.add(Tile.letter.s);
            pool.add(Tile.letter.u);
        }

        //Add letters that are found three times in the pool
        for(int i=1; i<=3; i++)
        {
            pool.add(Tile.letter.g);
        }

        //Add letters that appear six times in the pool
        for(int i=1; i<=6; i++)
        {
            pool.add(Tile.letter.n);
            pool.add(Tile.letter.r);
            pool.add(Tile.letter.t);
        }

        //Add letters that appear 8 times in the pool
        for(int i=1; i<=8; i++)
        {
            pool.add(Tile.letter.o);

        }



    }

    //Constructor
    public Pool()
    {
        pool_reset();
    }



    //A4 - Allows display of the number of tiles in the pool
    public int display_num(){return pool.size();}


    //A5 - Allows the pool to be checked to see if it is empty
    public boolean isEmpty(){return pool.isEmpty();}


    //A6 - Allows tiles to be drawn at random from the pool
    public Tile.letter draw(){
        if (pool.size() < 1) {
            throw new IllegalArgumentException("No tiles to be drawn");
        }
        else {
            Random random = new Random();
            int randomIndex = random.nextInt(pool.size());

            Tile.letter x = pool.get(randomIndex);
            pool.remove(randomIndex);
            return x;
        }
    }

    public void remove_from_pool(Tile.letter x)
    {
        //Create a variable to store whether or not the letter is found in the array
        Boolean flag = false;

        //Iterate through player_frame
        for (Tile.letter y : pool )
        {
            //If the current letter is the letter being removed
            if(y == x)
            {
                //Remove current letter
                pool.remove(y);
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
            System.out.println(x + " is not in the pool, therefore it cannot be removed");
        }
    }

    //A7 - Allows the value of a tile to be queried
    public int queried_tile(Tile.letter x)
    {
        //Integer variable to store index
        int index = 0;

        //Iterate through letter array until the tile is found
        for (Tile.letter y : tile_array )
        {
            //If the tile is found, exit for loop
            if(y ==  x) {
                break;
            }
            //Else, increment index
            else {
                index++;
            }
        }
        //return the score at found at the given tile_array index
        return score[index];
    }


    //A8 - Random letter function
    public Tile.letter random_letter() {
        int randomIndex = (int) (Math.random() * pool.size());
        return pool.get(randomIndex);
    }
}







