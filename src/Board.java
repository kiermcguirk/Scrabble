import javax.swing.*;
import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.*;

public class Board {
    //Store square for the board
    public static Square[][] game_board = new Square[15][15];

    protected Player player_one = new Player("");
    protected Player player_two = new Player("");
    protected boolean player_one_turn = true;
    boolean valid_move; //Variable which stores whether not a given move is valid or not
    boolean first_word = false; //Variable which stores whether or not the first move had a tile placed on the middle square.
    boolean letter_in_rack;

    public Board()
    {
        board_init(); //Call function to initialize state of board
    }

    // board display
    public void display_board(){
        for(int i =0; i < 15; i++){
            //prints an horizontal line
            printLine();
            //prints the row number
            System.out.print(i);
            for (int j = 0; j <15; j++){
                if(game_board[i][j].tile == Tile.letter.empty){System.out.print("| " + game_board[i][j].toString() + " ");}
                else System.out.print("| " + game_board[i][j].tile + "  ");
            }
            System.out.println("|");
        }
        printLine();
        //prints the number of the columns at the end of the board
        System.out.println("    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14          \n");
    }


    public void printLine(){
        System.out.println(" -----------------------------------------------------------------------------");
    }



    //Board reset
    public void board_reset() {
        for (int i = 0; i < 15; i++) {//Row
            for (int j = 0; j < 15; j++) {//Column
                if (game_board[i][j].tile == Tile.letter.empty) {
                    continue;
                } else {
                    game_board[i][j].tile = Tile.letter.empty;
                }
            }
        }
    }


    //A3 Stores the square values (e.g. triple word score)
    public void board_init() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                game_board[i][j] = new Square(Square.square_type.normal);
                if ((i == 0 && j == 0) || (i == 0 && j == 7) || (i == 0 && j == 14) || (i == 7 && j == 0) || (i == 14 && j == 0) || (i == 14 && j == 7) || (i == 14 && j == 14) || (i == 7 && j == 14))
                    game_board[i][j].type = Square.square_type.trip_w; //create triple word score at positions
                else if ((i == 0 && j == 3) || (i == 0 && j == 11) || (i == 2 && j == 6) || (i == 2 && j == 8) || (i == 3 && j == 0) || (i == 3 && j == 7) || (i == 3 && j == 14) || (i == 6 && j == 2) || (i == 6 && j == 6) || (i == 6 && j == 8) || (i == 6 && j == 12) || (i == 7 && j == 3) || (i == 7 && j == 11) || (i == 8 && j == 2) || (i == 8 && j == 6) || (i == 8 && j == 8) || (i == 8 && j == 12) || (i == 11 && j == 0) || (i == 11 && j == 7) || (i == 11 && j == 14) || (i == 12 && j == 6) || (i == 12 && j == 8) || (i == 14 && j == 3) || (i == 14 && j == 11)){
                    game_board[i][j].type = Square.square_type.dub_l; //create double letter score at positions
                }
                else if ((i == 1 && j == 5) || (i == 1 && j == 9) || (i == 5 && j == 1) || (i == 5 && j == 5) || (i == 5 && j == 9) || (i == 5 && j == 13) || (i == 9 && j == 1) || (i == 9 && j == 5) || (i == 9 && j == 9) || (i == 9 && j == 13) || (i == 13 && j == 5) || (i == 13 && j == 9)){
                    game_board[i][j].type = Square.square_type.trip_l; //create triple letter score at positions
                }
                else if ((i == 1 && j == 1) || (i == 1 && j == 13) || (i == 2 && j == 2) || (i == 2 && j == 12) || (i == 3 && j == 3) || (i == 3 && j == 11) || (i == 4 && j == 4) || (i == 4 && j == 10) ||  (i == 10 && j == 4) || (i == 10 && j == 10) || (i == 11 && j == 3) || (i == 11 && j == 11) || (i == 12 && j == 2) || (i == 12 && j == 12) || (i == 13 && j == 1) || (i == 13 && j == 13)){
                    game_board[i][j].type = Square.square_type.dub_w; //create double word score at positions
                }
                else if((i== 7 && j== 7))
                {
                    game_board[i][j].type = Square.square_type.middle; //set the middle square to middle type
                }
                else{
                    game_board[i][j].type = Square.square_type.normal; //creates a normal square otherwise
                }
            }
        }
    }

    //Function that checks if the first move has a tile placed on the middle square or not
    public boolean first_word(Square fw)
    {
        if(fw.type == Square.square_type.middle && first_word == false) //If the square is the middle square, and the first move hasn't occured yet
        {
            first_word = true; //Set first word to true
            return true; //Return true
        }
        else if(first_word == true) {return true;}
        else {
            System.out.println("Invalid Move: For the first word, you must begin on the middle square");
            return false;
        }
    }

    //Function that checks to see whether index is in range (return true)
    public boolean out_of_bounds(int i, int j)
    {
        if(i > 14 || i<0 || j>14 || j<0)
        {
            throw new IndexOutOfBoundsException("Invalid Move: That placement is out with the bounds of the board. \nPlease choose a position between 1 and 15");
        }
        else return true;
    }

    //Function that checks if a word connects with any other letters on the board (if the first move is passed)
    public boolean connected_word(int i, int j)
    {
        if(first_word == false)
        {
            //Check if there are any tiles adjacent to the position indicated by the indexes i,j (either vertically or horizontally)
            if (game_board[i - 1][j] != null || game_board[i][j - 1] != null || game_board[i + 1][j] != null || game_board[i][j + 1] != null)
            {
                return true;
            }
            else
            {
                System.out.println("Invalid move: You must place your word adjacent to at least one of the existing squares on the board");
                return false;
            }
        }
        else
        {
            return true; //If the first word hasn't been made, automatically pass this test
        }
    }

    //Function that checks if the player's word is can be made up from the tiles in their rack
    public boolean in_rack(Frame pf, Tile.letter q)
    {
        //Check if player contains certain letter in frame
        if(pf.letter_in_frame(q))
        {
            letter_in_rack = true;
            return true;
        }
        else{
            System.out.println("Invalid Move: you do not possess the tile to place it here");
            return false;}
    }

    //Check if new tile is not placed on an existing tile
    public boolean conflicting_word(Tile.letter a, int i, int j)
    {
        if(game_board[i][j].tile != Tile.letter.empty && game_board[i][j].tile != a)
        {
            System.out.println("Invalid move: You cannot place a tile on top of an existing tile");
            return false;
        }
        else return true;
    }

    public void place_word(ArrayList<Tile.letter> word, int i, int j, int direction) {
        //1 is vertical 0 is horizontal
        boolean invalid_move = false;
        int counter = 0;
        boolean skip_letter = false;
        boolean wait = false;
        for(counter = 0; counter < word.size(); counter++)
        {
            if(direction == 1)
            {
                //Loop through the type of square is not an empty tile
                while(game_board[i][j].tile != Tile.letter.empty) {
                    if(first_word){break;}
                    else if(in_word(word.get(counter), game_board[i][j].tile)){
                        i++;
                    }
                }
                if(valid_move(word.get(counter),i + counter, j)){continue;}
                else{invalid_move = true;
                    break;}
            }
            else if(direction == 0)
            {

                while(game_board[i][j].tile != Tile.letter.empty)
                {
                    if(first_word){break;}
                    else if(in_word(word.get(counter), game_board[i][j].tile)){

                        j++;}
                }
                if(valid_move(word.get(counter), i,j+counter)){continue;}
                else{invalid_move = true;
                    break;}
            }
        }
        if(invalid_move) System.out.println("Please try another move");
        else
        {
            for(counter = 0; counter < word.size(); counter++)
            {
                int temp =0;
                if(direction == 1)
                {

                    if (game_board[i][j].tile == Tile.letter.empty){

                        if (player_one_turn) {
                            game_board[i][j].tile = word.get(counter);
                            this.player_one.frame.remove_letter(word.get(counter));
                            //player_one_turn = false; for testing purposes will be returned next assignment
                            i++;
                        }
                        else{ this.player_two.frame.remove_letter(word.get(counter));
                            game_board[i][j].tile = word.get(counter);
                            player_one_turn = true;}
                    }
                    else{i++;}
                }
                else
                {
                    if(game_board[i][j].tile == Tile.letter.empty) {

                        if (player_one_turn) {
                            game_board[i][j].tile = word.get(counter);
                            this.player_one.frame.remove_letter(word.get(counter));
                            //player_one_turn = false; for testing purposes will be returned next assignment
                            j++;
                        }
                        else{ this.player_two.frame.remove_letter(word.get(counter));
                            game_board[i][j].tile = word.get(counter);
                            player_one_turn = true;}
                    }
                    else{j++; }

                }


            }
        }
    }

    //Check if 2 words have common letter
    public boolean in_word(Tile.letter from_word, Tile.letter from_board)
    {
        return from_board == from_word;
    }


    public boolean valid_move(Tile.letter x, int i, int j) {
        //If it's player one's turn and their move is valid (check each move function)
        if (player_one_turn) {
            if (in_rack(player_one.frame, x) && connected_word(i,j) && first_word(game_board[i][j]) && out_of_bounds(i, j) && conflicting_word(x,i, j)) {
                return true; //Return true
            }
        } else if (in_rack(player_two.frame, x) && connected_word(i, j) && first_word(game_board[i][j]) && out_of_bounds(i, j) && conflicting_word(x, i, j)) {
            return true;
        }
        return false;
    }
}