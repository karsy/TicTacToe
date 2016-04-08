package tictactoe;

public class Board {

    private String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};

    public boolean setValue(String c, int x, int y) {
        if (!board[x][y].equals(" ")) {
           return false;
        }

        board[x][y] = c;
        return true;
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
