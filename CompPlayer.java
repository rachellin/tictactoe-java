import java.util.List;
import java.util.ArrayList;

public class CompPlayer extends Player {
    private boolean AI;

    public CompPlayer (TicTacToe t, char symbol, boolean AI) {
        super(t, symbol, false);
        this.AI = AI;
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

    public void play (Board board) { // only if AI
        int[] coord = randomSpot();
        char opponent = 'X';
        if (this.getSymbol() == 'X') opponent = 'O';
        if (AI) {
            // block win 
            if (findWin(board, opponent)[0] >= 0) {
                coord = findWin(board, opponent);
                System.out.println("win blocked");
            }
            // take win
            if (findWin(board, this.getSymbol())[0] >= 0) {
                coord = findWin(board, this.getSymbol());
                System.out.println("win taken");
            }
        }
        makeMove(coord[0], coord[1]);
        System.out.println("Player " + this.getSymbol() + " plays on " + "(" + coord[0] + ", " + coord[1] + ")");
    }
    // is overloading functions necessary - only bc board is only needed if AI

    /**
     * check if there is an almost win
     * @param board
     * @param symbol
     * @return int array of coordinates, [-1, -1] if no almost-win
     */
    public int[] findWin (Board board, char symbol) {
        if (findRow(board, symbol)[0] >= 0) return findRow(board, symbol);
        if (findCol(board, symbol)[0] >= 0) return findCol(board, symbol);
        if (findDiag(board, symbol)[0] >= 0) return findDiag(board, symbol);
        return new int[]{-1, -1};
        // how to decide which one to choose if there are multiple
    }

    /**
     * check rows
     * @return int array of coord if there is an almost-winning row  
     */
    public int[] findRow (Board board, char symbol) {
        int counter = 0;
        boolean empty = false;
        int[] coord = new int[2];
        for (int r = 0; r < board.getHeight(); r++) {
            counter = 0;
            empty = false;
            for (int c = 0; c < board.getWidth(); c++) {
                if (board.get(r, c) == symbol) { 
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

    /**
     * check columns
     * @return int array of coord if there is an almost-winning column
     */
    public int[] findCol (Board board, char symbol) {
        int counter = 0;
        boolean empty = false;
        int[] coord = new int[2];
        for (int c = 0; c < board.getWidth(); c++) {
            counter = 0;
            empty = false;
            for (int r = 0; r < board.getHeight(); r++) {
                if (board.get(r, c) == symbol) { // temp hardcode to be X
                    counter++;
                } else if (board.get(r, c) == '-') {
                    empty = true;
                    coord[0] = r;
                    coord[1] = c;
                }
            }
            if (counter == board.getHeight()-1 && empty) {
                return coord;
            } 
        }
        coord[0] = -1;
        coord[1] = -1;
        return coord;
    }
    
    /**
     * check diagonals
     * @return int array of coord if there is an almost-winning diagonal
     * disabled if not a square
     */
    public int[] findDiag (Board board, char symbol) {
        int counter = 0;
        boolean empty = false;
        int[] coord = new int[2];

        int r = 0;
        int c = 0;
        while (r < board.getHeight() && c < board.getWidth()) {
            if (board.get(r, c) == symbol) {
                counter++;
            } else if (board.get(r, c) == '-') {
                empty = true;
                coord[0] = r;
                coord[1] = c;
            } 
            if (counter == board.getHeight()-1 && empty) {
                return coord;
            }
            r++;
            c++;
        }

        r = 0;
        counter = 0;
        empty = false;
        c = board.getWidth()-1;
        while (r < board.getHeight() && c >= 0) {
            if (board.get(r, c) == symbol) {
                counter++;
            } else if (board.get(r, c) == '-') {
                empty = true;
                coord[0] = r;
                coord[1] = c;
            }
            if (counter == board.getHeight()-1 & empty) {
                return coord;
            }
            r++;
            c--;
        }

        coord[0] = -1;
        coord[1] = -1;
        return coord;
    }
}
