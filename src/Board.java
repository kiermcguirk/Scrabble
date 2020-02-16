import javax.swing.*;

public class Board {

    public static Square[][] game_board = new Square[15][15];

    boolean valid_move; //Variable which stores whether not a given move is valid or not
    boolean first_word = false; //Variable which stores whether or not the first move had a tile placed on the middle square.
    boolean letter_in_rack;

    public Board() {
        board_init(); //Call function to initialize state of board
    }

    public void board_reset() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {

                if (game_board[i][j].tile == null) {
                    continue;
                } else {
                    game_board[i][j].tile = null;
                }
            }
        }
    }


    //A3 Stores the square values (e.g. triple word score)
    public void board_init() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if ((i == 0 && j == 0) || (i == 0 && j == 7) || (i == 0 && j == 14) || (i == 7 && j == 0) || (i == 14 && j == 0) || (i == 14 && j == 7) || (i == 14 && j == 14) || (i == 7 && j == 14)){
                    game_board[i][j].type = Square.square_type.trip_w; //create triple word score at positions
                }
                else if ((i == 0 && j == 3) || (i == 0 && j == 11) || (i == 2 && j == 6) || (i == 2 && j == 8) || (i == 3 && j == 0) || (i == 3 && j == 7) || (i == 3 && j == 14) || (i == 6 && j == 2) || (i == 6 && j == 6) || (i == 6 && j == 8) || (i == 6 && j == 12) || (i == 7 && j == 3) || (i == 7 && j == 11) || (i == 8 && j == 2) || (i == 8 && j == 6) || (i == 8 && j == 8) || (i == 8 && j == 12) || (i == 11 && j == 0) || (i == 11 && j == 7) || (i == 11 && j == 14) || (i == 12 && j == 6) || (i == 12 && j == 8) || (i == 14 && j == 3) || (i == 14 && j == 11)){
                    game_board[i][j].type = Square.square_type.dub_l; //create double letter score at positions
                }
                else if ((i == 1 && j == 5) || (i == 1 && j == 9) || (i == 5 && j == 1) || (i == 5 && j == 5) || (i == 5 && j == 9) || (i == 5 && j == 13) || (i == 9 && j == 1) || (i == 9 && j == 5) || (i == 9 && j == 9) || (i == 9 && j == 13) || (i == 13 && j == 5) || (i == 13 && j == 9)){
                    game_board[i][j].type = Square.square_type.trip_l; //create triple letter score at positions
                }
                else if ((i == 1 && j == 1) || (i == 1 && j == 13) || (i == 2 && j == 2) || (i == 2 && j == 12) || (i == 3 && j == 3) || (i == 3 && j == 11) || (i == 4 && j == 4) || (i == 4 && j == 10) || (i == 7 && j == 7) || (i == 10 && j == 4) || (i == 10 && j == 10) || (i == 11 && j == 3) || (i == 11 && j == 11) || (i == 12 && j == 2) || (i == 12 && j == 12) || (i == 13 && j == 1) || (i == 13 && j == 13)){
                    game_board[i][j].type = Square.square_type.dub_w; //create double word score at positions
                }
                else if((i== 8 && j== 8))
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
        else
        {
            System.out.println("Invalid Move: For the first word, you must begin on the middle square");
            return false;
        }
    }

    //Function that checks if the word is out of bounds
    public boolean out_of_bounds(int i, int j)
    {
        if(i > 14 || i<0 || j>14 || j<0)
        {
            System.out.println("Invalid Move: That placement is outwith the bounds of the board. \nPlease choose a position between 1 and 15");
            return false;
        }
        else
        {
            return true;
        }
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
    public boolean in_rack(Frame pf, Square q)
    {
        if(pf.letter_in_frame(q.tile))
        {
            letter_in_rack = true;
            return true;
        }
        else
        {
            return false;
        }
    }
}