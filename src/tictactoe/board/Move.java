package tictactoe.board;

import tictactoe.player.Player;

public class Move {

    public final int x;
    public final int y;
    public final Player player;

    public Move(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        if (x != move.x) return false;
        if (y != move.y) return false;
        return player.equals(move.player);

    }
}
