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
        currentNode = currentNode.getChild(opponentMove);

        // Take the middle if not already taken
        if (currentNode.getBoard().getCell(1, 1).equals(" ")) {
            return new Move(1, 1, character);
        }
    }
}
