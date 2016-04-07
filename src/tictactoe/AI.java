package tictactoe;

/**
 * Created by vegard on 21.03.2016.
 */
public class AI {

    private String character;
    private GameTree gameTree = new GameTree();
    private Node currentNode;

    public AI(String character) {
        this.character = character;
        this.currentNode = gameTree.getRoot();
    }

    public Move getMove(Move opponentMove) {

        return new Move(0, 0, character);
    }

    // Used during tree generation
    public Move getMove(Board board, Move opponentMove) {
        return new Move(0, 0, character);
    }

    private Move getBlockingMove(Board board, Move opponentMove) {
        int x = opponentMove.x;
        int y = opponentMove.y;
        int opponentSquares = 0;
        int yourSquares = 0;

        // Horizontal
        for (int i = 0; i < board.getWidth(); i++) {
            String cellValue = board.getCell((x + i) % board.getWidth(), y);
            if (cellValue.equals(character)) {
                yourSquares++;
            } else if (!cellValue.equals(" ")) {
                opponentSquares++;
            }
        }

        if (yourSquares == 0 && opponentSquares > 1) {
            return getHorizontalBlockingMove();
        }

        // Vertical
        opponentSquares = 0;
        yourSquares = 0;
        for (int i = 0; i < board.getHeight(); i++) {
            String cellValue = board.getCell(x, (y + i) % 3);
            if (cellValue.equals(character)) {
                yourSquares++;
            } else if (!cellValue.equals(" ")) {
                opponentSquares++;
            }
        }
        if (yourSquares == 0 && opponentSquares > 1) {
            return getVerticalBlockingMove();
        }

        // Diagonal

        // Last move was on the edge
        if ((x + y * board.getWidth()) % 2 == 1) {
            return null;
        }



    }

    private Move getHorizontalBlockingMove(Board board, int x, int y) {
        int opponentSquares = 0;
        int yourSquares = 0;
        Move move;

        for (int i = 0; i < board.getWidth(); i++) {
            String cellValue = board.getCell((x + i) % board.getWidth(), y);
            if (cellValue.equals(character)) {
                yourSquares++;
            } else if (!cellValue.equals(" ")) {
                opponentSquares++;
            }
        }

        if (yourSquares == 0 && opponentSquares > 1) {
            int moveX;
            int moveY;

            for (int i = 0; i < board.getWidth(); i++) {
                    
            }
        }

        return null;
    }

    private Move getVerticalBlockingMove() {
        int opponentSquares = 0;
        int yourSquares = 0;
    }
}
