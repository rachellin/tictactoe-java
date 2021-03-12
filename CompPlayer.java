import java.util.List;
import java.util.ArrayList;

public class CompPlayer extends Player {
    public CompPlayer (TicTacToe t) {
        super(t, 'O');
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
}
