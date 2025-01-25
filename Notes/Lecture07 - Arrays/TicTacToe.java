
public class TicTacToe {

    private String[][] board;
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;

    public TicTacToe() {
        board = new String[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = " ";
            }
        }

        
    }
}
