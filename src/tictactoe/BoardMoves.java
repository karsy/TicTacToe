package tictactoe;

/**
 * Created by Vegard Seim Karstang on 08.04.16.
 */
public class BoardMoves {

	public static Move getForcedMove(Board board, Move opponentMove, Move lastMove, String currentPlayer) {
		Move move = BoardMoves.getWinningMove(board, lastMove, currentPlayer);
		if (move != null) {
			return move;
		}

		move = getBlockingMove(board, opponentMove, currentPlayer);
		if (move != null) {
			return move;
		}

		return null;
	}
	
	public static Move getWinningMove(Board board, Move lastMove, String currentPlayer) {
		String opposingcurrentPlayer = currentPlayer.equals("o") ? "x" : "o";
		Move blocking = getBlockingMove(board, lastMove, opposingcurrentPlayer);
		if (blocking != null) {
			return new Move(blocking.x, blocking.y, currentPlayer);
		}
		return null;
	}

	public static Move getBlockingMove(Board board, Move opponentMove, String currentPlayer) {
		// First move, no blocking moves available
		if (opponentMove == null) {
			return null;
		}

		int x = opponentMove.x;
		int y = opponentMove.y;

		// Horizontal
		Move horizontalBlockingMove = getHorizontalBlockingMove(board, x, y, currentPlayer);
		if (horizontalBlockingMove != null) {
			return horizontalBlockingMove;
		}

		// Vertical
		Move verticalBlockingMove = getVerticalBlockingMove(board, x, y, currentPlayer);
		if (verticalBlockingMove != null) {
			return verticalBlockingMove;
		}

		// Diagonal

		// Last move was on the edge
		if ((x + y * board.getWidth()) % 2 == 1) {
			return null;
		}

		// Diagonal starting from the top left
		Move topLeftDiagonalBlockingMove = getTopLeftDiagonalBlockingMove(board, currentPlayer);
		if (topLeftDiagonalBlockingMove != null) {
			return topLeftDiagonalBlockingMove;
		}

		// Diagonal starting from the bottom left
		Move bottomLeftDiagonalBlockingMove = getBottomLeftDiagonalBlockingMove(board, currentPlayer);
		if (bottomLeftDiagonalBlockingMove != null) {
			return bottomLeftDiagonalBlockingMove;
		}

		// No blocking moves available
		return null;
	}

	private static Move getHorizontalBlockingMove(Board board, int x, int y, String currentPlayer) {
		int opponentSquares = 0;
		int yourSquares = 0;

		for (int i = 0; i < board.getWidth(); i++) {
			String cellValue = board.getCell((x + i) % board.getWidth(), y);
			if (cellValue.equals(currentPlayer)) {
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

			return new Move(moveX, y, currentPlayer);
		}

		return null;
	}

	private static Move getVerticalBlockingMove(Board board, int x, int y, String currentPlayer) {
		int opponentSquares = 0;
		int yourSquares = 0;

		for (int i = 0; i < board.getHeight(); i++) {
			String cellValue = board.getCell(x, (y + i) % 3);
			if (cellValue.equals(currentPlayer)) {
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

			return new Move(x, moveY, currentPlayer);
		}

		return null;
	}

	private static Move getTopLeftDiagonalBlockingMove(Board board, String currentPlayer) {
		int opponentSquares = 0;
		int yourSquares = 0;

		for (int i = 0; i < board.getWidth(); i++) {
			String cellValue = board.getCell(i, i);
			if (cellValue.equals(currentPlayer)) {
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

			return new Move(moveCoord, moveCoord, currentPlayer);
		}

		return null;
	}

	private static Move getBottomLeftDiagonalBlockingMove(Board board, String currentPlayer) {
		int opponentSquares = 0;
		int yourSquares = 0;

		for (int i = 0; i < board.getWidth(); i++) {
			String cellValue = board.getCell(i, 2 - i);
			if (cellValue.equals(currentPlayer)) {
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

			return new Move(moveCoord, 2 - moveCoord, currentPlayer);
		}

		return null;
	}
}
