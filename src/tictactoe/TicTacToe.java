package tictactoe;

import java.util.Scanner;

/**
 * Created by vegard on 21.03.2016.
 */
public class TicTacToe {

    private AI ai;
    private String human;
    private Board board;
    private Scanner scanner = new Scanner(System.in);

    public TicTacToe() {
        ai = new AI("x");
        human = "o";
        board = new Board(ai.getCharacter(), human);
    }

    public void run() {
        Move playerMove = null;
        int turn = 1;
        while (true) {
            Move aiMove = ai.getMove(board, playerMove);
            board.applyMove(aiMove);
            if (board.getVictory(aiMove)) {
                System.out.println(board);
                System.out.println("You lost!");
                break;
            }
            turn++;
            System.out.println(board);

            if (turn == 10) {
                System.out.println("Draw!");
                break;
            }

            System.out.println("Move (x,y):");
            String in = scanner.nextLine();
            int x = Integer.parseInt(in.substring(0,1), 10);
            int y = Integer.parseInt(in.substring(2,3), 10);
            playerMove = new Move(x, y, human);
            board.applyMove(playerMove);
            System.out.println(board);
            if (board.getVictory(playerMove)) {
                System.out.println("You won!");
                break;
            }
            turn++;
        }
    }

    /*public void run() {
        Move playerMove = null;
        int turn = 1;
        while (true) {
            System.out.println(board);
            System.out.println("Move (x,y):");
            String in = scanner.nextLine();
            int x = Integer.parseInt(in.substring(0,1), 10);
            int y = Integer.parseInt(in.substring(2,3), 10);
            playerMove = new Move(x, y, human);
            board.applyMove(playerMove);
            if (board.getVictory(playerMove)) {
                System.out.println(board);
                System.out.println("You won!");
                break;
            }
            turn++;

            if (turn == 10) {
                System.out.println("Draw!");
                break;
            }

            Move aiMove = ai.getMove(board, playerMove);
            board.applyMove(aiMove);
            if (board.getVictory(aiMove)) {
                System.out.println(board);
                System.out.println("You lost!");
                break;
            }
            turn++;


        }
    }*/

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.run();
    }
}
