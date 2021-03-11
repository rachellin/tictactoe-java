public class PlayerO extends Player {
    public PlayerO (TicTacToe t) {
        super(t, 'O');
    }

    @Override
    public void makeMove (int r, int c) {
        System.out.println("hehe override");
    }

    // new method that calls makeMove after taking user input 

}
