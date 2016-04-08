package tictactoe;

import java.util.ArrayList;
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
}
