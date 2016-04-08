package tictactoe;

/**
 * Created by vegard on 21.03.2016.
 */
public class AI {

    private String character;
    private GameTree gameTree = new GameTree();
    private Node currentNode;
    private int turn = 0;
    private Move lastMove;

    public AI(String character) {
        this.character = character;
        currentNode = gameTree.getRoot();
        lastMove = null;
    }

    public Move getMove(Move opponentMove) {

        return new Move(0, 0, character);
    }
}
