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
    private Boolean winner = null;

    public Node() {
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
}
