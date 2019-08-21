package tictactoe.player.ai;

import tictactoe.board.Board;
import tictactoe.board.Move;
import tictactoe.player.Player;

public class GameTree {

    public static final int WIN_WEIGHT = 10;
    public static final int LOSS_WEIGHT = -10;
    public static final int DRAW_WEIGHT = 0;

    private Node root;

    public GameTree(Board board, Player startPlayer) {
        generateFromBoard(board, startPlayer);
    }

    private void generateFromBoard(Board board, Player startPlayer) {
        root = new Node(board);
        root.generateChildren(startPlayer);
    }

    public Move getBestMove() {
        Node bestChild = root.getBestChild();
        return bestChild.getMove();
    }
}
