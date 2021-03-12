import java.util.Arrays;

/**
 * A class for managing all the rules of TicTacToe and keeping track of the
 * current player, who, the number of 'moves,' who is the winner and clearing
 * the board when it's time to switch players.
 */
public class TicTacToe {
    /**
   * a 3x3 board for tic tac toe Note: it's a board of type char Something new for
   * us.
   */
    private Board board;
    //private char player = 'X'; // swap

   /**
   * This Constructor is more for testing.
   * 
   * @param b The Board object keeps track of the 'X' and 'O' placement and the
   *          dimensions of the board
   */
    public TicTacToe (Board b) {
        this.board = b;
        board.fill('-');
    }

    /**
    * Default Constructor sets all spots to '-';
    */
    public TicTacToe() {
        System.out.println("constructor!");
        board.fill('-');
    }

    /**
     * Resets the board to start over when it's time start a new game
     */
    public void clearBoard() {
        board.fill('-');
    }

    /**
     * @return winner if there is a winner, return 'Z' if none
     * Check if each item in the rows, columns and diagonals to to see if they equal
     * the current player
     * run after every round 
     */
    public char winner() {
        char winner = 'Z';
        if (findRow() != 'Z') return findRow();
        if (findCol() != 'Z') return findCol();
        if (board.getHeight() == board.getWidth() && findDiag() != 'Z') return findDiag();
        if (board.isFull()) return 'T';
        return winner;
    }

    /**
     * check rows
     * @return winner if there is a winning row 
     */
    public char findRow () {
        for (int r = 0; r < board.getHeight(); r++) {
            for (int c = 0; c < board.getWidth(); c++) {
                if (c == board.getWidth()-1) {
                    return board.get(r, c);
                }
                if ((board.get(r, c) != board.get(r, c+1)) || board.get(r, c) == '-') {
                    break;
                }
            }
        }
        return 'Z';
    }

    /**
     * check colummns
     * @return winner if there is a winning column
     */
    public char findCol () {
        for (int c = 0; c < board.getWidth(); c++) {
            for (int r = 0; r < board.getHeight(); r++) {
                if (r == board.getHeight()-1) {
                    return board.get(r, c);
                }
                if ((board.get(r, c) != board.get(r+1, c)) || board.get(r, c) == '-') {
                    break;
                }
            }
        }
        return 'Z';
    }
    
    /**
     * check diagonals
     * @return winner if there is a winning diagonal
     * disabled if not a square
     */
    public char findDiag () {
        int r = 0;
        int c = 0;
        while (r < board.getHeight() && c < board.getWidth()) {
            if (r == board.getHeight()-1) { // c should also be second to last col
                return board.get(r, c);
            }
            if ((board.get(r, c) != board.get(r+1, c+1)) || board.get(r, c) == '-') {
                break;
            }
            r++;
            c++;
        }

        r = 0;
        c = board.getWidth()-1;
        while (r < board.getHeight() && c >= 0) {
            if (c == 0) { 
                return board.get(r, c);
            }
            if (board.get(r, c) != board.get(r+1, c-1) || board.get(r, c) == '-') {
                //System.out.println("break: " + r +", " + c);
                break;
            }
            r++;
            c--;
        }

        System.out.println("no diag");
        return 'Z';
    }

    /**
     * gets the current board and all it's data
     */
    public Board getBoard() {
        return board;
    }

    /**
     * user makes move
     */
    public void userMove (int r, int c) {
        if (board.get(r, c) == '-') {
            board.set(r, c, 'X');
        } else {
            System.out.println("This spot is already taken. Please try again.");
        }
    }

    /**
     * computer move 
     */
    public void compMove () {
        // array of all empty spots 
        
    }


    public String toString() {
        return board.toString();
    }

}