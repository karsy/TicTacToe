package tictactoe.player;

import tictactoe.board.Board;
import tictactoe.board.Move;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String character) {
        super(character);
    }

    @Override
    public Move getMove(Board board) {
        boolean correctInput = false;
        int x = -1;
        int y = -10;

        while (!correctInput) {
            System.out.println("Move (x,y):");
            String in = scanner.nextLine();

            try {
                x = Integer.parseInt(in.substring(0,1), 10);
                y = Integer.parseInt(in.substring(2,3), 10);
                if (x < 10 && x > 0 && y < 10 && y > 0) {
                    correctInput = true;
                }
            } catch (NumberFormatException ignored) {
            }
        }

        return new Move(x - 1, y - 1, this);
    }
}
