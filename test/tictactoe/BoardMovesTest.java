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

		board = setupBoard(new String[]{"o", " ", " ", "x", "x", " ", " ", " ", " "});
		Move move3 = BoardMoves.getBlockingMove(board, new Move(1, 1, "x"), "o");
		assertNotNull(move3);
		assertEquals(move3.x, 2);
		assertEquals(move3.y, 1);

		board = setupBoard(new String[]{" ", " ", " ", " ", " ", "o", "x", "x", " "});
		Move move4 = BoardMoves.getBlockingMove(board, new Move(1, 2, "x"), "o");
		assertNotNull(move4);
		assertEquals(move4.x, 2);
		assertEquals(move4.y, 2);

		board = setupBoard(new String[]{" ", " ", " ", " ", " ", "o", "x", " ", "x"});
		Move move5 = BoardMoves.getBlockingMove(board, new Move(2, 2, "x"), "o");
		assertNotNull(move5);
		assertEquals(move5.x, 1);
		assertEquals(move5.y, 2);

		board = setupBoard(new String[]{" ", "x", " ", " ", " ", " ", " ", " ", " "});
		Move move6 = BoardMoves.getBlockingMove(board, new Move(1, 0, "x"), "o");
		assertNull(move6);

		board = setupBoard(new String[]{" ", " ", " ", " ", "x", " ", " ", " ", " "});
		Move move7 = BoardMoves.getBlockingMove(board, null, "o");
		assertNull(move7);
	}

	@Test
	public void testGetBlockingVertical() throws Exception {
		Board board = setupBoard(new String[]{"x", "o", " ", "x", " ", " ", " ", " ", " "});
		Move move = BoardMoves.getBlockingMove(board, new Move(0, 1, "x"), "o");
		assertNotNull(move);
		assertEquals(move.x, 0);
		assertEquals(move.y, 2);

		board = setupBoard(new String[]{"x", " ", " ", "x", " ", " ", "o", " ", " "});
		Move move2 = BoardMoves.getBlockingMove(board, new Move(0, 1, "x"), "o");
		assertNull(move2);

		board = setupBoard(new String[]{"o", "x", " ", " ", "x", " ", " ", " ", " "});
		Move move3 = BoardMoves.getBlockingMove(board, new Move(1, 1, "x"), "o");
		assertNotNull(move3);
		assertEquals(move3.x, 1);
		assertEquals(move3.y, 2);

		board = setupBoard(new String[]{" ", "o", "x", " ", " ", "x", " ", " ", " "});
		Move move4 = BoardMoves.getBlockingMove(board, new Move(2, 1, "x"), "o");
		assertNotNull(move4);
		assertEquals(move4.x, 2);
		assertEquals(move4.y, 2);

		board = setupBoard(new String[]{" ", "o", "x", " ", " ", " ", " ", " ", "x"});
		Move move5 = BoardMoves.getBlockingMove(board, new Move(2, 2, "x"), "o");
		assertNotNull(move5);
		assertEquals(move5.x, 2);
		assertEquals(move5.y, 1);
	}

	@Test
	public void testGetBlockingTopLeftDiagonal() throws Exception {
		Board board = setupBoard(new String[]{"x", "o", " ", " ", "x", " ", " ", " ", " "});
		Move move = BoardMoves.getBlockingMove(board, new Move(1, 1, "x"), "o");
		assertNotNull(move);
		assertEquals(move.x, 2);
		assertEquals(move.y, 2);

		board = setupBoard(new String[]{"x", " ", " ", " ", "o", " ", " ", " ", "x"});
		Move move2 = BoardMoves.getBlockingMove(board, new Move(2, 2, "x"), "o");
		assertNull(move2);

		board = setupBoard(new String[]{" ", "o", " ", " ", "x", " ", " ", " ", "x"});
		Move move3 = BoardMoves.getBlockingMove(board, new Move(1, 1, "x"), "o");
		assertNotNull(move3);
		assertEquals(move3.x, 0);
		assertEquals(move3.y, 0);

		board = setupBoard(new String[]{"x", "o", " ", " ", " ", " ", " ", " ", "x"});
		Move move4 = BoardMoves.getBlockingMove(board, new Move(2, 2, "x"), "o");
		assertNotNull(move4);
		assertEquals(move4.x, 1);
		assertEquals(move4.y, 1);
	}

	@Test
	public void testGetBlockingBottomLeftDiagonal() throws Exception {
		Board board = setupBoard(new String[]{" ", "o", "x", " ", "x", " ", " ", " ", " "});
		Move move = BoardMoves.getBlockingMove(board, new Move(1, 1, "x"), "o");
		assertNotNull(move);
		assertEquals(move.x, 0);
		assertEquals(move.y, 2);

		board = setupBoard(new String[]{" ", " ", "x", " ", "o", " ", "x", " ", " "});
		Move move2 = BoardMoves.getBlockingMove(board, new Move(2, 0, "x"), "o");
		assertNull(move2);

		board = setupBoard(new String[]{" ", "o", " ", " ", "x", " ", "x", " ", " "});
		Move move3 = BoardMoves.getBlockingMove(board, new Move(1, 1, "x"), "o");
		assertNotNull(move3);
		assertEquals(move3.x, 2);
		assertEquals(move3.y, 0);

		board = setupBoard(new String[]{" ", "o", "x", " ", " ", " ", "x", " ", " "});
		Move move4 = BoardMoves.getBlockingMove(board, new Move(2, 0, "x"), "o");
		assertNotNull(move4);
		assertEquals(move4.x, 1);
		assertEquals(move4.y, 1);
	}

	@Test
	public void testGetWinningMove() throws Exception {
		Board board = setupBoard(new String[]{" ", "o", "x", " ", "x", "o", " ", " ", " "});
		Move move = BoardMoves.getWinningMove(board, new Move(1, 1, "x"), "x");
		assertNotNull(move);
		assertEquals(move.x, 0);
		assertEquals(move.y, 2);
		assertEquals(move.character, "x");

		board = setupBoard(new String[]{"x", "o", " ", " ", "x", "o", " ", " ", " "});
		move = BoardMoves.getWinningMove(board, new Move(1, 1, "x"), "x");
		assertNotNull(move);
		assertEquals(move.x, 2);
		assertEquals(move.y, 2);
		assertEquals(move.character, "x");

		board = setupBoard(new String[]{"x", " ", "x", " ", "o", "o", " ", " ", " "});
		move = BoardMoves.getWinningMove(board, new Move(1, 0, "x"), "x");
		assertNotNull(move);
		assertEquals(move.x, 1);
		assertEquals(move.y, 0);
		assertEquals(move.character, "x");

		board = setupBoard(new String[]{"x", "o", " ", "x", " ", "o", " ", " ", " "});
		move = BoardMoves.getWinningMove(board, new Move(0, 1, "x"), "x");
		assertNotNull(move);
		assertEquals(move.x, 0);
		assertEquals(move.y, 2);
		assertEquals(move.character, "x");

		board = setupBoard(new String[]{" ", "o", " ", " ", "x", "o", " ", " ", " "});
		move = BoardMoves.getWinningMove(board, new Move(1, 1, "x"), "x");
		assertNull(move);
	}

	private Board setupBoard(String[] values) {
		Board board = new Board();
		for (int i = 0; i < values.length; i++) {
			board.setValue(values[i], i % 3, (int) Math.floor(i / 3.0));
		}
		return board;
	}
}