package tictactoe.player.ai;

import tictactoe.board.Board;
import tictactoe.board.Move;
import tictactoe.Utils;
import tictactoe.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class Node {

    private List<Node> children = new ArrayList<>();
    private int score;
    private Board currentBoard;
    private Move move;

    public Node(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    private Node(Move move, Board board) {
        this.move = move;
        this.currentBoard = board;
    }

    public void generateChildren(Player startPlayer) {
        int startTurn = 1;

        for (int i = 0; i < currentBoard.getSize(); i++) {
            for (int j = 0; j < currentBoard.getSize(); j++) {
                if (!currentBoard.getCell(i, j).equals(" ")) {
                    startTurn++;
                }
            }
        }

        generateChildren(startPlayer, startPlayer, startTurn);
    }

    private void generateChildren(Player startPlayer, Player currentPlayer, int turn) {
        if (turn == 10) {
            return;
        }

        for (int i = 0; i < Board.NUMBER_OF_CELLS; i++ ) {
            if (currentBoard.getCell(Utils.getBoardX(i), Utils.getBoardY(i)).equals(" ")) {
                Board newBoard = Board.fromBoard(currentBoard);
                Move newMove = new Move(Utils.getBoardX(i), Utils.getBoardY(i), currentPlayer);
                newBoard.applyMove(newMove);
                Node child = new Node(newMove, newBoard);
                children.add(child);

                if (newBoard.getVictory(newMove)) {
                    if (currentPlayer.equals(startPlayer)) {
                        child.score = GameTree.WIN_WEIGHT - turn;
                    } else {
                        child.score = GameTree.LOSS_WEIGHT + turn;
                    }
                } else {
                    child.generateChildren(startPlayer, currentBoard.getOtherPlayer(currentPlayer), turn + 1);
                    if (turn == 9) {
                        child.score = GameTree.DRAW_WEIGHT;
                    }
                }
            }
        }

        if (currentPlayer.equals(startPlayer)) {
            score = getMaxChildScore();
        } else {
            score = getMinChildScore();
        }
    }

    private int getMaxChildScore() {
        OptionalInt optionalInt = children.stream().mapToInt(node -> node.score).max();
        if (optionalInt.isPresent()) {
            return optionalInt.getAsInt();
        }

        return GameTree.LOSS_WEIGHT;
    }

    private int getMinChildScore() {
        OptionalInt optionalInt = children.stream().mapToInt(node -> node.score).min();
        if (optionalInt.isPresent()) {
            return optionalInt.getAsInt();
        }

        return GameTree.WIN_WEIGHT;
    }

    public Node getBestChild() {
        Optional<Node> optionalNode = children.stream().filter(node -> node.score == score).findFirst();
        return optionalNode.orElse(null);

    }

    public Move getMove() {
        return move;
    }
}
