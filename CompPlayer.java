import java.util.List;
import java.util.ArrayList;

public class CompPlayer extends Player {
    public CompPlayer (TicTacToe t, char symbol) {
        super(t, symbol, false);
    }

    /**
     * choose random spot to make move 
     * @return array of length 2 representing the coordinates of the spot
     */
    public int[] randomSpot () {
        int[] coord = {0, 0};
        List<int[]> possible = new ArrayList<int[]>();
        Board board = this.getGame().getBoard();
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
        System.out.println("Player " + this.getSymbol() + " plays on " + "(" + coord[0] + ", " + coord[1] + ")");
    }

    private void blockWin () {
        // loop through board arr and find row/col/diag 
    }

    /**
     * check rows
     * @return int array of coord if there is an almost-winning row  
     */
    public int[] findRow (Board board) {
        int counter = 0;
        boolean empty = false;
        int[] coord = new int[2];
        for (int r = 0; r < board.getHeight(); r++) {
            counter = 0;
            empty = false;
            for (int c = 0; c < board.getWidth(); c++) {
                if (board.get(r, c) == 'X') { // temp hardcode to be X
                    counter++;
                } else if (board.get(r, c) == '-') {
                    empty = true;
                    coord[0] = r;
                    coord[1] = c;
                }
            }
            if (counter == board.getWidth()-1 && empty) {
                return coord;
            } 
        }
        coord[0] = -1;
        coord[1] = -1;
        return coord;
    }
    // have to account for there being 3 X's but one O

    /**
     * check columns
     * @return winner if there is a winning column
     */
    public char findCol (Board board) {
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
    public char findDiag (Board board) {
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
        
        return 'Z';
    }
}
