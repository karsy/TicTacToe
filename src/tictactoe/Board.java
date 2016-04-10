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

    public void clearCell(int x, int y) {
        board[x][y] = " ";
    }

    public String getCell(int x, int y) {
        return board[x][y];
    }

    public int getWidth() {
        return 3;
    }

    public int getHeight() {
        return 3;
    }

    public boolean getVictory(Move lastMove) {



        return false;
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
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
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
