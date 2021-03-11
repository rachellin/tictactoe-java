import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
  /** First Goal: create a TicTacToe object (t0?) 
  * create two HumanPlayer objects (player1 and player2?) 
  * and have two players play each-other using Scanner for input
  * You will use getPlayer(), makeMove(), switchPlayer() and winner() 
  * Play until there is a winner or a tie.  
  * Announce the winner or the tie.
  * 
  * If you get that, then have RandomPlayer vs HumanPlayer
  * 
  * Last try RandomPlayer vs RandomPlayer
  * 
  * Extra credit: try to make an AIPlayer
  * 
  * Extra credit: try to make a GUI - swing, JavaFX, html, Android
  */

  public static void main (String[] args) {
      // char[][] testBoard = {
      //     {'X', 'X', 'O', 'X'},
      //     {'O', 'X', 'X', 'O'},
      //     {'X', 'O', 'X', 'X'},
      //     {'O', 'O', 'X', 'X'}
      // };
      char[][] testBoard = {
        {'-', 'X', 'X'},
        {'O', 'X', '-'},
        {'X', 'O', 'X'},
    };

      Board board = new Board(testBoard);
      //board.fill('X');
      TicTacToe game = new TicTacToe(board);

      String boardStr = board.toString();
      System.out.println(boardStr);

      char winner = game.winner();
      System.out.print(winner);

      PlayerX x = new PlayerX(game);
      x.play();
  }
}