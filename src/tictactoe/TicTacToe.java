package tictactoe;

import tictactoe.board.Board;
import tictactoe.board.Move;
import tictactoe.player.ai.AIPlayer;
import tictactoe.player.HumanPlayer;
import tictactoe.player.Player;

import java.util.Scanner;

public class TicTacToe {

    private static final String FIRST_PLAYER = "X";
    private static final String SECOND_PLAYER = "O";

    private Player firstPlayer;
    private Player secondPlayer;
    private Board board;

    public TicTacToe(boolean humanStarts) {
        if (humanStarts) {
            firstPlayer = new HumanPlayer(FIRST_PLAYER);
            secondPlayer = new AIPlayer(SECOND_PLAYER);
        } else {
            firstPlayer = new AIPlayer(FIRST_PLAYER);
            secondPlayer = new HumanPlayer(SECOND_PLAYER);
        }

        board = new Board(firstPlayer, secondPlayer);
    }

    private boolean doMove(Player player) {
        boolean legalMove = false;
        Move move = null;

        while (!legalMove) {
            move = player.getMove(board);
            legalMove = board.applyMove(move);
        }
        System.out.println(board);

        if (board.getVictory(move)) {
            System.out.println(board);
            System.out.println("Player " + player.getCharacter() + " won!");
            return true;
        }

        return false;
    }

    private void play() {
        int moveNum = 1;

        while (true) {
            boolean didWin = doMove(firstPlayer);
            if (didWin) {
                break;
            }
            moveNum++;

            if (moveNum > 9) {
                System.out.println("Draw!");
                break;
            }

            didWin = doMove(secondPlayer);
            if (didWin) {
                break;
            }
            moveNum++;

            if (moveNum > 9) {
                System.out.println("Draw!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        System.out.println("Do you want to start the game? [y,n]");
        while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) {
            answer = scanner.nextLine();
        }

        TicTacToe game = new TicTacToe(answer.equalsIgnoreCase("y"));
        game.play();
    }
}
