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
    private char player = 'X'; // swap

   /**
   * This Constructor is more for testing.
   * 
   * @param b The Board object keeps track of the 'X' and 'O' placement and the
   *          dimensions of the board
   */
    public TicTacToe (Board b) {
        this.board = b;
    }

    /**
    * Default Constructor sets all spots to '-';
    */
    public TicTacToe() {
        board.fill('-');
    }

    /**
     * Resets the board to start over when it's time start a new game
     */
    public void clearBoard() {
        board.fill('-');
    }

    /**
     * Check if each item in the rows, columns and diagonals to to see if they equal
     * the current player
     * run after every round 
     */
    public char winner() {
        char winner = 'X';
        if (findRow() || findCol() || (board.getHeight() == board.getWidth() && findDiag())) {
            winner = '?';
            //TODO: figure out who the winner is 
        }
        return winner;
    }

    /**
     * check rows
     * @return true if there is a winning row 
     */
    public boolean findRow () {
        for (int r = 0; r < board.getHeight(); r++) {
            for (int c = 0; c < board.getWidth(); c++) {
                if (c == board.getWidth()-1) {
                    return true;
                }
                if (board.get(r, c) != board.get(r, c+1)) {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * check colummns
     * @return true if there is a winning column
     */
    public boolean findCol () {
        for (int c = 0; c < board.getWidth(); c++) {
            for (int r = 0; r < board.getHeight(); r++) {
                if (r == board.getHeight()-1) {
                    return true;
                }
                if (board.get(r, c) != board.get(r+1, c)) {
                    break;
                }
            }
        }
        return false;
    }
    
    /**
     * check diagonals
     * @return true if there is a winning diagonal
     * disabled if not a square
     */
    public boolean findDiag () {
        int r = 0;
        int c = 0;
        while (r < board.getHeight() && c < board.getWidth()) {
            if (r == board.getHeight()-1) { // c should also be second to last col
                return true;
            }
            if (board.get(r, c) != board.get(r+1, c+1)) {
                break;
            }
            r++;
            c++;
        }

        r = 0;
        c = board.getWidth()-1;
        while (r < board.getHeight() && c >= 0) {
            if (c == 0) { 
                return true;
            }
            if (board.get(r, c) != board.get(r+1, c-1)) {
                System.out.println("break: " + r +", " + c);
                break;
            }
            r++;
            c--;
        }

        return false;
    }

    /**
     * gets the current board and all it's data
     */
    public Board getBoard() {
        return board;
    }

    /**
     * get the current player - can be either 'X' or 'Y'
     */
    public char getPlayer() {
        return player;
    }

    /**
     * Swaps between 'X' and 'Y'
     */
    public void switchPlayer() {
        if (player == 'x') player = 'Y';
        else player = 'X';
    }

    public String toString() {
        return board.toString();
    }

}