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
    }

    public Move getMove(Move opponentMove) {

        return new Move(0, 0, character);
    }

    // Used during tree generation
    public Move getMove(Board board, Move opponentMove) {
        Move move = null;

        if (turn > 1) {
            move = BoardMoves.getBlockingMove(board, opponentMove, character);
            if (move != null) {
                return move;
            }
        }




        return new Move(0, 0, character);
    }
}
