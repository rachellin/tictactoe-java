public class Player {
    private TicTacToe t;
    private char symbol;
    private boolean human;

    /**
     * constructor for Player 
     * @param t TicTacToe object 
     * @param symbol char symbol for the player 
     * @param human boolean true if the player is human, false if not 
     */
    public Player (TicTacToe t, char symbol, boolean human) {
        this.t = t;
        this.symbol = symbol;
        this.human = human;
    }

    /**
     * @return TicTacToe object 
     */
    public TicTacToe getGame () {
        return this.t;
    }

    /**
     * @return symbol char 
     */
    public char getSymbol () {
        return this.symbol;
    }

    /**
     * check if the player is human
     * @return boolean human property 
     */
    public boolean isHuman () {
        return this.human;
    }

    /**
     * @return string representation of Player 
     */
    public String toString () {
        return this.symbol + "";
    }

    /**
     * change spot accordingly after checking the move is valid
     * if move is not valid, return false
     * @param r
     * @param c
     * @return true if move is made
     */
    public boolean makeMove (int r, int c) {
        Board board = t.getBoard();
        if (checkMove(r, c)) {
            board.set(r, c, symbol);
            return true;
        } 
        return false;
    }

    /**
     * check if the move is valid 
     * @param r
     * @param c
     * @return boolean 
     */
    public boolean checkMove (int r, int c) {
        Board board = t.getBoard();
        if (board.get(r, c) == '-') {
            return true;
        }
        return false;
    }
}
