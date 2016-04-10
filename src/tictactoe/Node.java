package tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vegard on 07.04.2016.
 */
public class Node {

    private List<Node> children = new ArrayList<>();
    private double score;
    private Board currentBoard;
    private Move move;

    public Node() {

    }

    public Node(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public Node(Move move, Board board) {
        this.move = move;
        this.currentBoard = board;
    }

    public Node(boolean generateChildren, String currentPlayer) {
        if (generateChildren) {
            generateChildren(currentPlayer);
        }
    }

    public void addChild(Node child) {
        this.getChildren().add(child);
    }

    public void generateChildren(String currentPlayer) {
        for (int i = 0; i < Board.NUMBER_OF_CELLS; i++ ) {
            if (currentBoard.getCell(getBoardX(i), getBoardY(i)).equals(" ")) {

            }
        }
    }

    public void addChildren(Node... children) {
        Collections.addAll(this.children, children);
    }

    public Board getBoard() {
        return currentBoard;
    }

    public Node getChild(Move move) {
        Node newChild = null;

        currentBoard.setValue(move.character, move.x, move.y);
        for (Node child: children) {
            if (child.currentBoard.equals(currentBoard)) {
                newChild = child;
                break;
            }
        }

        currentBoard.clearCell(move.x, move.y);

        return newChild;
    }

    public List<Node> getChildren() {
        return children;
    }

    public double getScore() {
        return score;
    }

    public Move getMove() {
        return move;
    }
}
