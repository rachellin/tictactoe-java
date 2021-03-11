import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.*;

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
        int[] coord = {0};
        Stream<String> coordStream;

        do {
            if (coord.length == 2) {
                System.out.println("This move is not valid. Please try again.");
            } else {
                System.out.println("Enter the coordinates of the spot you wish to place an X on. \n Example: enter 0 1 for coordinate (0, 1)");
            }
            String line = input.nextLine();

            // take user input until it's a valid format 
            while (!(line.length() == 3 && line.substring(1,2).equals(" ") && line.substring(0,1).matches("[0-9]+") && line.substring(2).matches("[0-9]+"))) { 
                System.out.println("Your input is not valid. Please try again.\nEnter the coordinates of the spot you wish to place an X on. \n Example: enter 0 1 for coordinate (0, 1)");
                line = input.nextLine();
            }
        
            // convert string to array of integers for coordinates 
            coordStream = Stream.of(line.split("\\s+"));
            coord = coordStream.mapToInt(Integer::parseInt).toArray();
        }
        while (!makeMove(coord[0], coord[1]));

        // close Scanner 
        input.close();
    }

}
