package tictactoe.board;

import tictactoe.player.Player;

import java.util.Arrays;

public class Board {

    public static final int NUMBER_OF_CELLS = 9;
    private String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    private Player[] players = new Player[2];

    public Board(Player firstPlayer, Player secondPlayer) {
        this.players[0] = firstPlayer;
        this.players[1] = secondPlayer;
    }

    public static Board fromBoard(Board oldBoard) {
        Board newBoard = new Board(oldBoard.players[0], oldBoard.players[1]);
        newBoard.board = new String[oldBoard.board.length][oldBoard.board.length];

        // Deep copy
        for (int x = 0; x < oldBoard.board.length; x++) {
            System.arraycopy(oldBoard.board[x], 0, newBoard.board[x], 0, oldBoard.board[x].length);
        }

        return newBoard;
    }

    public boolean setValue(Player player, int x, int y) {
        if (!board[x][y].equals(" ")) {
           return false;
        }

        if (illegalPlayer(player)) {
            return false;
        }

        board[x][y] = player.getCharacter();
        return true;
    }

    public boolean applyMove(Move move) {
        return setValue(move.player, move.x, move.y);
    }

    public String getCell(int x, int y) {
        return board[x][y];
    }

    public int getSize() {
        return board.length;
    }

    public boolean getVictory(Move lastMove) {

        int equalCells = 0;

        // Horizontal
        for (int i = 0; i < getSize(); i++) {
            if (board[i][lastMove.y].equals(lastMove.player.getCharacter())) {
                equalCells++;
            }
        }

        if (equalCells == getSize()) {
            return true;
        }

        // Vertical
        equalCells = 0;
        for (int i = 0; i < getSize(); i++) {
            if (board[lastMove.x][i].equals(lastMove.player.getCharacter())) {
                equalCells++;
            }
        }

        if (equalCells == getSize()) {
            return true;
        }

        // Diagonally

        // Last move was on the edge
        if ((lastMove.x + lastMove.y * getSize()) % 2 == 1) {
            return false;
        }

        equalCells = 0;
        if (lastMove.x == lastMove.y) {
            for (int i = 0; i < getSize(); i++) {
                if (board[i][i].equals(lastMove.player.getCharacter())) {
                    equalCells++;
                }
            }
        } else {
            for (int i = 0; i < getSize(); i++) {
                if (board[i][2 - i].equals(lastMove.player.getCharacter())) {
                    equalCells++;
                }
            }
        }

        return equalCells == getSize();
    }

    // Return the other player of the game
    public Player getOtherPlayer(Player player) {
        if (illegalPlayer(player)) {
            return null;
        }

        if (player.equals(players[0])) {
            return players[1];
        } else {
            return players[0];
        }

    }

    public boolean illegalPlayer(Player player) {
        return Arrays.stream(players).noneMatch(s -> s.equals(player));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Board)) {
            return false;
        }

        Board other = (Board) obj;
        boolean equal = true;
        for (int x = 0; x < getSize(); x++) {
            for (int y = 0; y < getSize(); y++) {
                if (!board[x][y].equals(other.getCell(x, y))) {
                    equal = false;
                }
            }
        }

        return equal;
    }

    @Override
    public String toString() {

        final String s = "+---+---+---+\n" +
                "| " + board[0][0] + " | " + board[1][0] + " | " + board[2][0] + " |\n" +
                "+---+---+---+\n" +
                "| " + board[0][1] + " | " + board[1][1] + " | " + board[2][1] + " |\n" +
                "+---+---+---+\n" +
                "| " + board[0][2] + " | " + board[1][2] + " | " + board[2][2] + " |\n" +
                "+---+---+---+\n ";
        return s;
    }
}
