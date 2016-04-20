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

        gameTree = new GameTree(turn);
        gameTree.generateFromBoard(board, character);
        turn += 2;
        return gameTree.getBestMove();

        /*// Take the middle if not already taken
        if (board.getCell(1, 1).equals(" ")) {
            turn++;
            return new Move(1, 1, character);
        }

        Move forced = BoardMoves.getForcedMove(board, opponentMove, lastMove, character);
        if (forced != null) {
            turn++;
            return forced;
        }

        if (gameTree == null) {
            gameTree = new GameTree(turn);
            gameTree.generateFromBoard(board, character);
        }

        turn++;
        return gameTree.getBestMove();*/
    }

    public String getCharacter() {
        return character;
    }
}
