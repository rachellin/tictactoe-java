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
    //   char[][] testBoard = {
    //     {'-', '-', '-'},
    //     {'-', '-', '-'},
    //     {'-', '-', '-'},
    // };

      Board board = new Board(3, 3);
      TicTacToe game = new TicTacToe(board);
      board.fill('-');

      // String boardStr = board.toString();
      // System.out.println(boardStr);

      PlayerX x = new PlayerX(game);
      PlayerO o = new PlayerO(game);

      do {
        System.out.println("\n"+board.toString());
        x.play();
        pause(500);

        if (board.isFull()) {
          System.out.println("\n"+board.toString());
        }

        System.out.println("\n"+board.toString());
        o.play();
        pause(500);
      }
      while (game.winner() == 'Z');

      // announce winner
      if (game.winner() == 'T') {
        System.out.println("That was a tie!");
      } else {
        if (game.winner() == 'O') {
          System.out.println("\n"+board.toString());
        }
        System.out.println("The winner is " + game.winner() + "!");
      }

  }

  public static void pause (int ms) {
    try { 
      TimeUnit.MILLISECONDS.sleep(ms); 
    } 
    catch (InterruptedException e) { 
      e.printStackTrace(); 
    }
  }
}