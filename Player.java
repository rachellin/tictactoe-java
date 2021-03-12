import java.util.ArrayList;
import java.util.List;

public class Player {
    private TicTacToe t;
    private char symbol;

    public Player (TicTacToe t, char symbol) {
        this.t = t;
        this.symbol = symbol;
    }

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

    /**
     * choose random spot to make move 
     * @return array of length 2 representing the coordinates of the spot
     */
    public int[] randomSpot () {
        int[] coord = {0, 0};
        List<int[]> possible = new ArrayList<int[]>();
        Board board = t.getBoard();
        // find empty spots 
        for (int r = 0; r < board.getHeight(); r++) {
            for (int c = 0; c < board.getWidth(); c++) {
                if (checkMove(r, c)) {
                    possible.add(new int[]{r, c});
                }
            }
        }
        // choose random spot
        int index = (int)(Math.random()*possible.size());
        coord = possible.get(index);
        return coord;
    }

    /**
     * make move and announce (print) the move
     */
    public void play () {
        int[] coord = randomSpot();
        makeMove(coord[0], coord[1]);
        System.out.println("Player " + this.symbol + " plays on " + "(" + coord[0] + ", " + coord[1] + ")");
    }
}
