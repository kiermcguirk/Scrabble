import javax.swing.*;
import java.util.ArrayList;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.*;

public class Board {
    //Store square for the board
    public  Square[][] game_board = new Square[15][15];
    protected Player player_one = new Player("");
    protected Player player_two = new Player("");
    protected boolean player_one_turn = true;
    boolean valid_move; //Variable which stores whether not a given move is valid or not
    boolean first_word = false; //Variable which stores whether or not the first move had a tile placed on the middle square.
    boolean letter_in_rack;
    boolean isFirstMove = true;
    public ArrayList<Integer> prevI = new ArrayList<>();
    public ArrayList<Integer> prevJ = new ArrayList<>();
    public ArrayList<Tile.letter> prevWord = new ArrayList<>();
    public ArrayList<Square.square_type> prevSquare = new ArrayList<>();
    public boolean connected_word_flag = false;
    public Board()
    {
        board_init(); //Call function to initialize state of board
    }

    //Testing with word "apple" by placing on the board horizontally
    public static void main(String[] args) {
        Board x = new Board();
        ArrayList<Tile.letter> test = new ArrayList<Tile.letter>();
        test.add(Tile.letter.a);
        test.add(Tile.letter.p);
        test.add(Tile.letter.p);
        test.add(Tile.letter.l);
        test.add(Tile.letter.e);

        x.place_word(test,7,7,0);


        x.display_board();
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

    //prints line on the board
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
                else if((i== 7 && j== 7)) {
                    game_board[i][j].type = Square.square_type.middle; //set the middle square to middle type
                }
                else{
                    game_board[i][j].type = Square.square_type.normal; //creates a normal square otherwise
                }
            }
        }
    }

    //Function that checks if the first move has a tile placed on the middle square or not
    public boolean first_word(ArrayList<Tile.letter> word,int i, int j, int direction)
    {

        if(first_word == true)return true;


        for(int counter = 0; counter <word.size(); counter++)
        {
            if(i == 7 && j ==7) //If the square is the middle square, and the first move hasn't occured yet
            {
                first_word = true; //Set first word to true
                return true; //Return true
            }
            else if(direction == 0) {j++;}
            else if(direction == 1){i++;}
        }
        System.out.println("You must place your word on the middle tile for the first word");
        throw new IllegalArgumentException("Must place first word on middle tile");


    }

    //Function that checks to see whether index is in range (return true)
    public boolean out_of_bounds(int i, int j)
    {
        if(i > 14 || i<0 || j>14 || j<0)
        {
            System.out.println("Invalid Move: That placement is out with the bounds of the board. \nPlease choose a position between 0 and 14");
            throw new IndexOutOfBoundsException("Invalid Move: That placement is out with the bounds of the board. \nPlease choose a position between 1 and 15");
        }
        else return true;
    }

    //Function that checks if a word connects with any other letters on the board (if the first move is passed)
    public boolean connected_word(ArrayList<Tile.letter> word, int i, int j, int direction)
    {
        if(connected_word_flag)
        {
            return true;
        }
        if(isFirstMove == false)
        {
            for(int index = 0; index< word.size(); index++) {
                //Check if there are any tiles adjacent to the position indicated by the indexes i,j (either vertically or horizontally)
                if (game_board[i - 1][j].tile != Tile.letter.empty || game_board[i][j - 1].tile != Tile.letter.empty || game_board[i + 1][j].tile != Tile.letter.empty || game_board[i][j + 1].tile != Tile.letter.empty || game_board[i][j].tile != Tile.letter.empty) {
                    connected_word_flag = true;
                    return true;
                }
                if(direction == 1) i++;
                else j++;
            }

            System.out.println("Invalid move: You must place your word adjacent to at least one of the existing squares on the board");
            return false;

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
            System.out.println("Invalid Move: you do not possess the tile "+ q + " to place it here");
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

    //Function when placing a word on the board
    public void place_word(ArrayList<Tile.letter> word, int i, int j, int direction) {

        addPreviousRack();
        //1 is vertical 0 is horizontal
        connected_word_flag = false;
        boolean invalid_move = false;
        int counter = 0;
        boolean skip_letter = false;
        boolean wait = false;
        int tempi = i;
        int tempj = j;
        int counter2= word.size();
        first_word(word,i,j,direction);
        int skipcounter = 0;
        if(!isFirstMove)
        System.out.println("here");
        prevWord = word;
        prevJ.clear();
        prevI.clear();
        if(!connected_word(word,i,j,direction)){throw new IllegalArgumentException();}
        if(word.size() < 2){
            System.out.println("Cannot place a word of size one");
            throw new IllegalArgumentException();
        }



        for(counter = 0; counter < word.size(); counter++)
        {
            if(counter2 <= 1 )break;
            if(direction == 1)
            {
                //Loop through the type of square is not an empty tile
                while(game_board[i][j].tile != Tile.letter.empty && counter2 !=1)
                {
                    if(!first_word){break;}
                    else if(in_word(word.get(counter + skipcounter), game_board[i][j].tile)){
                        if(i < tempi + word.size()-1){i++;
                            //skipcounter++;
                            counter++;}
                        skip_letter = true;
                    }
                    counter2--;
                }
                if(in_word(word.get(counter), game_board[i][j].tile)){
                    i++;
                    continue;}
                else if(valid_move(word.get(counter), i,j)){
                    if(!skip_letter) i++;
                    continue;}
                else{invalid_move = true;
                    break;}
            }
            else if(direction == 0)
            {
                while(game_board[i][j].tile != Tile.letter.empty && counter2 !=1)
                {
                    if(!first_word){break;}
                    else if(in_word(word.get(counter + skipcounter), game_board[i][j].tile)){
                        if(j < tempj + word.size()-1){j++;
                        //skipcounter++;
                        counter++;}
                        skip_letter = true;
                    }
                    counter2--;
                }
                if(in_word(word.get(counter), game_board[i][j].tile)){
                    j++;
                    continue;}
                else if(valid_move(word.get(counter), i,j)){
                    if(!skip_letter) j++;
                    continue;}
                else{invalid_move = true;
                    break;}
            }
        }
        if(invalid_move) throw new IllegalArgumentException();//System.out.println("Please try another move");
        else
        {
            for(counter = 0; counter < word.size(); counter++)
            {
                int temp =0;
                if(direction == 1)
                {
                    if (game_board[tempi][tempj].tile == Tile.letter.empty){
                        if (player_one_turn) {
                            this.player_one.frame.remove_letter(word.get(counter));
                        }
                        else {
                            this.player_two.frame.remove_letter(word.get(counter));
                        }
                        adjacentWord(word.get(counter),tempi,tempj,direction);
                        game_board[tempi][tempj].tile = word.get(counter);
                        prevSquare.add(game_board[tempi][tempj].type);
                        addPreviousWord(tempi,tempj);
                        tempi++;
                    }
                    else{
                        tempi++;}
                }
                else
                {
                    if(game_board[tempi][tempj].tile == Tile.letter.empty) {

                        if (player_one_turn) {
                            this.player_one.frame.remove_letter(word.get(counter));
                        }
                        else{
                            this.player_two.frame.remove_letter(word.get(counter));
                        }
                        adjacentWord(word.get(counter),tempi,tempj,direction);
                        game_board[tempi][tempj].tile = word.get(counter);
                        prevSquare.add(game_board[tempi][tempj].type);
                        addPreviousWord(tempi,tempj);
                        tempj++;
                    }
                    else{

                        tempj++; }
                }
            }
        }
        if(isFirstMove)
        {
            isFirstMove = false;
        }
    }

    //Check if 2 words have common letter
    public boolean in_word(Tile.letter from_word, Tile.letter from_board)
    {
        return from_board == from_word;
    }


    //Ensuring validity of a move
    public boolean valid_move(Tile.letter x, int i, int j) {
        //If it's player one's turn and their move is valid (check each move function)
        if (player_one_turn) {

            if (in_rack(player_one.frame, x)  && out_of_bounds(i, j) && conflicting_word(x,i, j)) {
                return true; //Return true
            }
        } else if (in_rack(player_two.frame, x)  && out_of_bounds(i, j) && conflicting_word(x, i, j)) {
            return true;
        }
        return false;
    }

    //Adding score
    public void addScore(String word, int i, int j, char direction){
        Tile tile = new Tile();

        //Check if word is on triple or double word score
        int scoremult = 1;
        int wordscore = 0;
        ArrayList<Tile.letter> wordlist = new ArrayList<Tile.letter>();
        for (int counter = 0; counter < word.length(); counter++) {

            if(game_board[i][j].type == Square.square_type.dub_w || game_board[i][j].type == Square.square_type.trip_w){
                scoremult = game_board[i][j].getWordMultiple();
            }
            wordscore += getScore(game_board[i][j]);
            game_board[i][j].type = Square.square_type.normal;
            if(direction == 'h') i++;
            else j++;

            wordlist.add(tile.getTileFromLetter(word.charAt(counter))); //Add word to word list (convert string to tile) for scoring
        }
        if (player_one_turn)
            player_one.increase_score(wordscore * scoremult);
        else player_two.increase_score(wordscore * scoremult);
    }

    public void addScore(ArrayList<Tile.letter> word)
    {
        int wordscore = 0;
        for (Tile.letter tile: word) {
            wordscore += getScore(tile);
        }

        if (player_one_turn)
            player_one.increase_score(wordscore);
        else player_two.increase_score(wordscore);
    }

    //Function to get the score
    private int getScore(Square square)
    {
        Pool find_tile_value = new Pool();
        int score = find_tile_value.queried_tile(square.tile);
        return score * square.getScoreMultiple();
    }
    private int getScore(Tile.letter tile)
    {
        Pool find_tile_value = new Pool();
        int score = find_tile_value.queried_tile(tile);
        return score;
    }
    /*
    //score for current player
    private void score(Player player, String word){
        layoutManager layoutManager = new layoutManager();
        int score= 0;
        if (player_one == player){
            score = getWordScore(word);
            player_one.player_score += score;
            layoutManager.player_one.setText(String.valueOf(score));
        }
        if (player_two == player){
            score = getWordScore(word);
            player_two.player_score += score;
            layoutManager.player_two.setText(String.valueOf(score));
        }
    }

     */
    private void addPreviousWord(int i, int j)
    {
        prevI.add(i);
        prevJ.add(j);
    }

    private void addPreviousRack()
    {
        if(player_one_turn)
            for (Tile.letter tile :player_one.frame.player_frame)
            {
                player_one.frame.prevRack.add(tile);
            }

        else
            for (Tile.letter tile :player_two.frame.player_frame)
            {
                player_two.frame.prevRack.add(tile);
            }

    }

    public void revertPlacedWord()
    {
        for(int i=0; i<prevWord.size();i++)
        {
            game_board[prevI.get(i)][prevJ.get(i)].type = prevSquare.get(i);
            game_board[prevI.get(i)][prevJ.get(i)].tile = Tile.letter.empty;
        }
    }

    public void adjacentWord(Tile.letter letter, int i, int j, int direction)
    {
        if(isFirstMove){
            return;
        }
        int tempI = i;
        int tempJ = j;

        ArrayList<Tile.letter> adjWord = new ArrayList<>();
        if(direction == 1)
        {

            //If there is an adjacent word07
            if( /*game_board[i][j].tile != Tile.letter.empty &&*/ ((game_board[i][j + 1].tile != Tile.letter.empty || game_board[i][j - 1].tile != Tile.letter.empty) && (!(game_board[i][j + 1].tile != Tile.letter.empty && game_board[i][j -1].tile != Tile.letter.empty))))
            {


                while(game_board[tempI][tempJ - 1].tile != Tile.letter.empty && tempJ >= 0) //Watch out for if it goes off the board
                {
                    //Find head of word
                    tempJ--;
                }
                //add new word
                addLetter(tempI, tempJ,direction, adjWord);
                //System.out.println(adjWord);
            }
        }
        else
        {
            if( (game_board[i + 1][j].tile != Tile.letter.empty || game_board[i-1][j].tile != Tile.letter.empty) && !(game_board[i + 1][j].tile != Tile.letter.empty && game_board[i - 1][j].tile != Tile.letter.empty))
            {
                while(game_board[tempI - 1][tempJ].tile != Tile.letter.empty && tempI >= 0) //Watch out for if it goes off the board
                {
                    //Find head of word
                    tempI--;
                }
                addLetter(tempI, tempJ,direction, adjWord);

            }
        }
        addScore(adjWord);
    }

    private ArrayList<Tile.letter> addLetter(int i, int j, int direction, ArrayList<Tile.letter> newWord)
    {
        if(game_board[i][j].tile == Tile.letter.empty || i > 14  && j >14)
        {
            return newWord;
        }
        else
        {
            newWord.add(game_board[i][j].tile);

            if(direction == 1)
                addLetter(i, j + 1, direction, newWord);
            else
                addLetter(i + 1, j, direction, newWord);
        }

        return newWord;
    }






}