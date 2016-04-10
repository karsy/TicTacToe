package tictactoe;

/**
 * Created by vegard on 21.03.2016.
 */
public class AI {

    private String character;
    private GameTree gameTree = new GameTree(3);
    private Node currentNode;
    private int turn = 0;
    private Move lastMove;

    public AI(String character) {
        this.character = character;
    }

    public Move getMove(Board board, Move opponentMove) {

        // Take the middle if not already taken
        if (currentNode.getBoard().getCell(1, 1).equals(" ")) {
            return new Move(1, 1, character);
        }

        Move forced = BoardMoves.getForcedMove(board, opponentMove, lastMove, character);
        if (forced != null) {
            return forced;
        }

        gameTree.generateFromBoard(board, character);
        return gameTree.getBestMove();
    }
}
