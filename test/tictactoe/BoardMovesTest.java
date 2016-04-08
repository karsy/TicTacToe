package tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vegard Seim Karstang on 08.04.16.
 */
public class BoardMovesTest {

	@Test
	public void testGetBlockingHorizontal() throws Exception {
		Board board = setupBoard(new String[]{"x", "x", " ", "o", " ", " ", " ", " ", " "});
		Move move = BoardMoves.getBlockingMove(board, new Move(1, 0, "x"), "o");
		assertNotNull(move);
		assertEquals(move.x, 2);
		assertEquals(move.y, 0);

		board = setupBoard(new String[]{"x", "x", "o", " ", " ", " ", " ", " ", " "});
		Move move2 = BoardMoves.getBlockingMove(board, new Move(1, 0, "x"), "o");
		assertNull(move2);
	}

	@Test
	public void testGetBlockingVertical() throws Exception {

	}

	@Test
	public void testGetBlockingTopLeftDiagonal() throws Exception {

	}

	@Test
	public void testGetBlockingBottomLeftDiagonal() throws Exception {

	}

	@Test
	public void testGetWinningMove() throws Exception {

	}

	private Board setupBoard(String[] values) {
		Board board = new Board();
		for (int i = 0; i < values.length; i++) {
			board.setValue(values[i], i % 3, (int) Math.floor(i / 3.0));
		}
		return board;
	}
}