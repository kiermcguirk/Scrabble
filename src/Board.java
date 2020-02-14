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


    public void display_board() {
        for (int i = 0; i <= 15; i++) {
            for (int j = 0; j <= 15; j++) {


            }
        }

    }
}