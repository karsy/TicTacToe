package tictactoe.player.ai;

import tictactoe.board.Board;
import tictactoe.board.Move;
import tictactoe.player.Player;

public class AIPlayer extends Player {

    public AIPlayer(String character) {
        super(character);
    }

    @Override
    public Move getMove(Board board) {
        GameTree gameTree = new GameTree(board, this);
        return gameTree.getBestMove();
    }
}
