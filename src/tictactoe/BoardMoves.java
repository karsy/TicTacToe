package tictactoe;

/**
 * Created by Vegard Seim Karstang on 08.04.16.
 */
public class BoardMoves {

	public Move getForcedMove(Board board, Move opponentMove, Move lastMove, String player) {
		Move move = BoardMoves.getWinningMove(board, lastMove, player);
		if (move != null) {
			return move;
		}

		move = getBlockingMove(board, opponentMove, player);
		if (move != null) {
			return move;
		}

		return null;
	}
	
	public static Move getWinningMove(Board board, Move lastMove, String player) {
		String opposingPlayer = player.equals("o") ? "x" : "o";
		Move blocking = getBlockingMove(board, lastMove, opposingPlayer);
		if (blocking != null) {
			return new Move(blocking.x, blocking.y, player);
		}
		return null;
	}

	public static Move getBlockingMove(Board board, Move opponentMove, String player) {
		int x = opponentMove.x;
		int y = opponentMove.y;

		// Horizontal
		Move horizontalBlockingMove = getHorizontalBlockingMove(board, x, y, player);
		if (horizontalBlockingMove != null) {
			return horizontalBlockingMove;
		}

		// Vertical
		Move verticalBlockingMove = getVerticalBlockingMove(board, x, y, player);
		if (verticalBlockingMove != null) {
			return verticalBlockingMove;
		}

		// Diagonal

		// Last move was on the edge
		if ((x + y * board.getWidth()) % 2 == 1) {
			return null;
		}

		// Diagonal starting from the top left
		Move topLeftDiagonalBlockingMove = getTopLeftDiagonalBlockingMove(board, player);
		if (topLeftDiagonalBlockingMove != null) {
			return topLeftDiagonalBlockingMove;
		}

		// Diagonal starting from the bottom left
		Move bottomLeftDiagonalBlockingMove = getBottomLeftDiagonalBlockingMove(board, player);
		if (bottomLeftDiagonalBlockingMove != null) {
			return bottomLeftDiagonalBlockingMove;
		}

		// No blocking moves available
		return null;
	}

	private static Move getHorizontalBlockingMove(Board board, int x, int y, String player) {
		int opponentSquares = 0;
		int yourSquares = 0;

		for (int i = 0; i < board.getWidth(); i++) {
			String cellValue = board.getCell((x + i) % board.getWidth(), y);
			if (cellValue.equals(player)) {
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

			return new Move(moveX, y, player);
		}

		return null;
	}

	private static Move getVerticalBlockingMove(Board board, int x, int y, String player) {
		int opponentSquares = 0;
		int yourSquares = 0;

		for (int i = 0; i < board.getHeight(); i++) {
			String cellValue = board.getCell(x, (y + i) % 3);
			if (cellValue.equals(player)) {
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

			return new Move(x, moveY, player);
		}

		return null;
	}

	private static Move getTopLeftDiagonalBlockingMove(Board board, String player) {
		int opponentSquares = 0;
		int yourSquares = 0;

		for (int i = 0; i < board.getWidth(); i++) {
			String cellValue = board.getCell(i, i);
			if (cellValue.equals(player)) {
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

			return new Move(moveCoord, moveCoord, player);
		}

		return null;
	}

	private static Move getBottomLeftDiagonalBlockingMove(Board board, String player) {
		int opponentSquares = 0;
		int yourSquares = 0;

		for (int i = 0; i < board.getWidth(); i++) {
			String cellValue = board.getCell(i, 2 - i);
			if (cellValue.equals(player)) {
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

			return new Move(moveCoord, 2 - moveCoord, player);
		}

		return null;
	}
}
