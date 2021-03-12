import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.*;
import java.util.InputMismatchException;

public class PlayerX extends Player {
    public PlayerX (TicTacToe t) {
        super(t, 'X');
    }

    // @Override
    // public void makeMove (int r, int c) {
    //     System.out.println("hehe override");
    // }

    // new method that calls makeMove after taking user input
    public void play () {

        Scanner input = new Scanner(System.in);
        Integer r = null, c = null;

        do {
            if (r != null && c != null) {
                System.out.println("This move is not valid. Please try again.");
            } else {
                System.out.println("Enter the coordinates of the spot you wish to place an X on. \nExample: enter 0 1 for coordinate (0, 1)");
            }

            // loop until valid input 
            do {
                try {
                    r = input.nextInt();
                    c = input.nextInt();
                    break;
                }
                catch (InputMismatchException e) {
                    System.out.println("Your input is not valid. Please try again.\nEnter the coordinates of the spot you wish to place an X on. \nExample: enter 0 1 for coordinate (0, 1)");
                    input.nextLine();
                }
            }
            while (true);

        }
        while (!makeMove(r, c));

        // close Scanner 
        //input.close();
    }


}
