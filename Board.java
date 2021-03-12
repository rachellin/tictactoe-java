import java.util.Arrays;

public class Board {
    private char[][] boardArr; //  keep track of values on current board 
    private int width; 
    private int height; // # of rows 

   /**
   * Alocate all the spaces and dimensions for the game.
   * @param width the width of the game board
   * @param height the height of the game board
   */
    public Board (int width, int height) {
        boardArr = new char[height][width];
        this.height = boardArr.length;
        this.width = boardArr[0].length;
    }

   /**
   * Construct using 2d character array - While 2d arrys are column major,
   * this will accept the array to look as it looks -
   * char[3][3] = {{1,2,3},
   *               {4,5,6},
   *               {7,8,9}}
   * For example get(2,0) is '2', get(2,1) is '6' and get(0,2) is '7'
   * @param b a 2d array of char values.  Can be 'X','Y' or '-'
   */
  public Board (char[][] b) {
    boardArr = b.clone();
    height = b.length;
    width = b[0].length;
  }

   /**
   * Standard mutator or setter
   * @param x the x value to be set
   * @param y the y value to be set
   * @param val the char that is setting 'X','Y' or '-'
   */
    public void set (int x, int y, char val) {
        boardArr[x][y] = val;
    }

    public char get (int x, int y) {
        return boardArr[x][y];
    }

    public int getWidth () {
        return width;
    }

    public int getHeight () {
        return height;
    }

    /**
     * set all values in board to value 
     */
    public void fill (char val) {
        for (char[] row : boardArr) {
            Arrays.fill(row, val);
        }
    }

    public char[][] getBoard () {
        return boardArr;
    }

    /**
     * check if the board is full
     * @return true if the board if completely filled with X and O's
     */
    public boolean isFull () {
        for (char[] row : boardArr) {
            for (char x : row) {
                if (x == '-') return false;
            }
        }
        return true;
    }

    public String toString () {
        String str = "";
        for (int r = 0; r < boardArr.length; r++) {
            for (int c = 0; c < boardArr[0].length; c++) {
                str += boardArr[r][c] + " ";
            }
            str += "\n";
        }
        return str;
        //return Arrays.deepToString(boardArr);
    }
}
