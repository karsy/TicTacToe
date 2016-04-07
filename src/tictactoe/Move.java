package tictactoe;

/**
 * Created by vegard on 21.03.2016.
 */
public class Move {

    public final int x;
    public final int y;
    public final String character;

    public Move(int x, int y, String character) {
        this.x = x;
        this.y = y;
        this.character = character;
    }
}
