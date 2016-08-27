package tictactoe;

/**
 * Created by vegard on 07.04.2016.
 */
public class GameTree {

    public static final double WIN_WEIGHT = 10.0;
    public static final double LOSS_WEIGHT = -10.0;
    public static final double DRAW_WEIGHT = 0.0;

    private Node root;
    private int turn;

    public GameTree(int turn) {
        this.turn = turn;
    }

    public void generateFromBoard(Board board, String aiCharacter) {
        root = new Node(board);
        root.generateChildren(aiCharacter, turn);

    }

    public Node getRoot() {
        return root;
    }
}
