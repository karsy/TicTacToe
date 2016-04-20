package tictactoe;

import java.util.Arrays;

public class Board {

    public static final int NUMBER_OF_CELLS = 9;
    private String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    private String[] players = new String[2];

    public Board(String firstPlayer, String secondPlayer) {
        this.players[0] = firstPlayer;
        this.players[1] = secondPlayer;
    }

    public static Board fromBoard(Board oldBoard) {
        Board newBoard = new Board(oldBoard.players[0], oldBoard.players[1]);
        newBoard.board = new String[oldBoard.board.length][oldBoard.board.length];

        // Deep copy
        for (int x = 0; x < oldBoard.board.length; x++) {
            for (int y = 0; y < oldBoard.board[x].length; y++) {
                newBoard.board[x][y] = oldBoard.board[x][y];
            }
        }

        return newBoard;
    }

    public boolean setValue(String c, int x, int y) {
        if (!board[x][y].equals(" ")) {
           return false;
        }

        if (illegalPlayer(c)) {
            return false;
        }

        board[x][y] = c;
        return true;
    }

    public boolean applyMove(Move move) {
        return setValue(move.character, move.x, move.y);
    }

    public void clearCell(int x, int y) {
        board[x][y] = " ";
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
            if (board[i][lastMove.y].equals(lastMove.character)) {
                equalCells++;
            }
        }

        if (equalCells == getSize()) {
            return true;
        }

        // Vertical
        equalCells = 0;
        for (int i = 0; i < getSize(); i++) {
            if (board[lastMove.x][i].equals(lastMove.character)) {
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
                if (board[i][i].equals(lastMove.character)) {
                    equalCells++;
                }
            }
        } else {
            for (int i = 0; i < getSize(); i++) {
                if (board[i][2 - i].equals(lastMove.character)) {
                    equalCells++;
                }
            }
        }

        return equalCells == getSize();
    }

    // Return the string of the player that is not the player given in the parameter
    public String getOtherPlayer(String player) {
        if (illegalPlayer(player)) {
            return "";
        }

        if (player.equals(players[0])) {
            return players[1];
        } else {
            return players[0];
        }

    }

    public String getStartPlayer() {
        return players[0];
    }

    public boolean illegalPlayer(String player) {
        return Arrays.stream(players).filter(s -> s.equals(player)).count() == 0;
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
        StringBuilder sb = new StringBuilder();

        sb.append("+---+---+---+\n");
        sb.append("| ").append(board[0][0]).append(" | ").append(board[1][0]).append(" | ").append(board[2][0]).append(" |\n");
        sb.append("+---+---+---+\n");
        sb.append("| ").append(board[0][1]).append(" | ").append(board[1][1]).append(" | ").append(board[2][1]).append(" |\n");
        sb.append("+---+---+---+\n");
        sb.append("| ").append(board[0][2]).append(" | ").append(board[1][2]).append(" | ").append(board[2][2]).append(" |\n");
        sb.append("+---+---+---+\n ");

        return sb.toString();
    }
}
