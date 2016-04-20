package tictactoe;

/**
 * Created by vegard on 21.03.2016.
 */
public class AI {

    private String character;
    private GameTree gameTree = null;
    private Node currentNode;
    private int turn = 2;
    private Move lastMove;

    public AI(String character) {
        this.character = character;
    }

    public Move getMove(Board board, Move opponentMove) {

        // First turn
        if (opponentMove == null) {
            turn = 1;
        }

        if (gameTree == null) {
            gameTree = new GameTree(turn);
            gameTree.generateFromBoard(board, character);
            currentNode = gameTree.getRoot();
        } else {
            currentNode = currentNode.getChild(opponentMove);
        }

        Move forced = BoardMoves.getForcedMove(board, opponentMove, lastMove, character);
        if (forced != null) {
            turn += 2;
            currentNode = currentNode.getChild(forced);
            lastMove = forced;
            return forced;
        }

        currentNode = currentNode.getBestChild();
        turn += 2;
        lastMove = currentNode.getMove();
        return lastMove;
    }

    public String getCharacter() {
        return character;
    }
}
