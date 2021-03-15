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
    char[][] testBoard = {
        {'X', 'X', 'X', 'O'},
        {'X', 'O', 'X', 'X'},
        {'X', '-', 'X', 'X'},
        {'O', 'O', 'X', 'X'}
    };
    //   char[][] testBoard = {
    //     {'-', '-', '-'},
    //     {'-', '-', '-'},
    //     {'-', '-', '-'},
    // };

    Board board = new Board(testBoard);
    TicTacToe game = new TicTacToe(board);

    CompPlayer x = new CompPlayer(game, 'X');

    int[] y = x.findRow(board);
    System.out.println(y[0] + ", " + y[1]);

    //runGame();
      
  }

  public static void runGame () {
    Board board = new Board(3, 3);
    TicTacToe game = new TicTacToe(board);

    // human vs human
    // HumanPlayer x = new HumanPlayer(game, 'X');
    // HumanPlayer o = new HumanPlayer(game, 'O');

    // human vs comp
    // HumanPlayer x = new HumanPlayer(game, 'X');
    //CompPlayer o = new CompPlayer(game, 'O');

    // comp vs comp
    CompPlayer x = new CompPlayer(game, 'X');
    CompPlayer o = new CompPlayer(game, 'O');

    do {
      // welcome message if empty 
      if (board.isEmpty()) System.out.println("Welcome to Tic Tac Toe!");

      // x plays 
      if (!board.isFull()) {
        System.out.println("\n"+board.toString());
        x.play();
        pause(500);
      }

      // o plays 
      if (!board.isFull()) {
        System.out.println("\n"+board.toString());
        o.play();
        pause(500);
      }

      // if tie, print board again 
      if (board.isFull()) {
        System.out.println("\n"+board.toString());
      }

      // announce winner
      if (game.winner() == 'T') {
        System.out.println("That was a tie!");
        if ((!x.isHuman() && !o.isHuman()) || !game.playAgain()) break; // only ask to play again if human player exists 
      } else if (game.winner() == 'O' || game.winner() == 'X'){
        if (game.winner() == 'O') {
          System.out.println("\n"+board.toString());
        }
        System.out.println("The winner is " + game.winner() + "!");
        if ((!x.isHuman() && !o.isHuman()) || !game.playAgain()) break;
      }

    }
    while (true);
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