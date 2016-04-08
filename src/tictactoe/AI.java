package tictactoe;

/**
 * Created by vegard on 21.03.2016.
 */
public class AI {

    private String character;
    private GameTree gameTree;
    private Node currentNode;
    private int turn = 0;

    public AI(String character, boolean generateTree) {
        this.character = character;

        if (generateTree) {
            gameTree = new GameTree();
            currentNode = gameTree.getRoot();
        }
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

        // Horizontal
        Move horizontalBlockingMove = getHorizontalBlockingMove(board, x, y);
        if (horizontalBlockingMove != null) {
            return horizontalBlockingMove;
        }

        // Vertical
        Move verticalBlockingMove = getVerticalBlockingMove(board, x, y);
        if (verticalBlockingMove != null) {
            return verticalBlockingMove;
        }

        // Diagonal

        // Last move was on the edge
        if ((x + y * board.getWidth()) % 2 == 1) {
            return null;
        }

        // Diagonal starting from the top left
        Move topLeftDiagonalBlockingMove = getTopLeftDiagonalBlockingMove(board);
        if (topLeftDiagonalBlockingMove != null) {
            return topLeftDiagonalBlockingMove;
        }

        // Diagonal starting from the bottom left
        Move bottomLeftDiagonalBlockingMove = getBottomLeftDiagonalBlockingMove(board);
        if (bottomLeftDiagonalBlockingMove != null) {
            return bottomLeftDiagonalBlockingMove;
        }

        // No blocking moves available
        return null;
    }

    private Move getHorizontalBlockingMove(Board board, int x, int y) {
        int opponentSquares = 0;
        int yourSquares = 0;

        for (int i = 0; i < board.getWidth(); i++) {
            String cellValue = board.getCell((x + i) % board.getWidth(), y);
            if (cellValue.equals(character)) {
                yourSquares++;
            } else if (!cellValue.equals(" ")) {
                opponentSquares++;
            }
        }

        if (yourSquares == 0 && opponentSquares > 1) {
            int moveX = 0;

            for (int i = 0; i < board.getWidth(); i++) {
                if (board.getCell(i, y).equals(" ")) {
                    moveX = i;
                    break;
                }
            }

            return new Move(moveX, y, character);
        }

        return null;
    }

    private Move getVerticalBlockingMove(Board board, int x, int y) {
        int opponentSquares = 0;
        int yourSquares = 0;

        for (int i = 0; i < board.getHeight(); i++) {
            String cellValue = board.getCell(x, (y + i) % 3);
            if (cellValue.equals(character)) {
                yourSquares++;
            } else if (!cellValue.equals(" ")) {
                opponentSquares++;
            }
        }

        if (yourSquares == 0 && opponentSquares > 1) {
            int moveY = 0;

            for (int i = 0; i < board.getHeight(); i++) {
                if (board.getCell(x, i).equals(" ")) {
                    moveY = i;
                    break;
                }
            }

            return new Move(x, moveY, character);
        }

        return null;
    }

    private Move getTopLeftDiagonalBlockingMove(Board board) {
        int opponentSquares = 0;
        int yourSquares = 0;

        for (int i = 0; i < board.getWidth(); i++) {
            String cellValue = board.getCell(i, i);
            if (cellValue.equals(character)) {
                yourSquares++;
            } else if (!cellValue.equals(" ")) {
                opponentSquares++;
            }
        }

        if (yourSquares == 0 && opponentSquares > 1) {
            int moveCoord = 0;

            for (int i = 0; i < board.getWidth(); i++) {
                if (board.getCell(i, i).equals(" ")) {
                    moveCoord = i;
                    break;
                }
            }

            return new Move(moveCoord, moveCoord, character);
        }

        return null;
    }

    private Move getBottomLeftDiagonalBlockingMove(Board board) {
        int opponentSquares = 0;
        int yourSquares = 0;

        for (int i = 0; i < board.getWidth(); i++) {
            String cellValue = board.getCell(i, 2 - i);
            if (cellValue.equals(character)) {
                yourSquares++;
            } else if (!cellValue.equals(" ")) {
                opponentSquares++;
            }
        }

        if (yourSquares == 0 && opponentSquares > 1) {
            int moveCoord = 0;

            for (int i = 0; i < board.getWidth(); i++) {
                if (board.getCell(i, 2 - i).equals(" ")) {
                    moveCoord = i;
                    break;
                }
            }

            return new Move(moveCoord, moveCoord, character);
        }

        return null;
    }
}
