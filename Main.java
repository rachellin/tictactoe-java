import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'},
    };

      Board board = new Board(testBoard);
      //board.fill('X');
      TicTacToe game = new TicTacToe(board);

      // String boardStr = board.toString();
      // System.out.println(boardStr);

      // char winner = game.winner();
      // System.out.print(winner);

      PlayerX x = new PlayerX(game);
      PlayerO o = new PlayerO(game);

      // System.out.println("\n"+board.toString());
      // x.play();

      // System.out.println("\n"+board.toString());
      // o.play();

      do {
        System.out.println("\n"+board.toString());
        x.play();

        pause(1);

        System.out.println("\n"+board.toString());
        o.play();
        pause(1);

        System.out.println(game.winner());
      }
      while (game.winner() == 'Z');

      //System.out.println("\n"+board.toString());

  }

  public static void pause (int seconds) {
    try { 
      TimeUnit.SECONDS.sleep(seconds); 
    } 
    catch (InterruptedException e) { 
      e.printStackTrace(); 
    }
  }
}