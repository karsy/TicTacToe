package tictactoe.player;

import tictactoe.board.Board;
import tictactoe.board.Move;

public abstract class Player {

    private String character;

    protected Player(String character) {
        this.character = character;
    }

    public abstract Move getMove(Board board);

    public String getCharacter() {
        return character;
    }
}
