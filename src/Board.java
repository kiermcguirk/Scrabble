public class Board {

    public static Square[][] game_board = new Square[15][15];

    public Board() {

    }

    public void board_reset() {
        for (int i = 0; i <= 15; i++) {
            for (int j = 0; j <= 15; j++) {

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
        for (int i = 0; i <= 15; i++) {
            for (int j = 0; j <= 15; j++) {
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
                } else{
                    game_board[i][j].type = Square.square_type.normal; //creates a normal square otherwise
                }

            }
        }
    }

}