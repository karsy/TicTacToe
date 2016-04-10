package tictactoe;

/**
 * Created by vegard on 07.04.2016.
 */
public class GameTree {

    private Node root;
    private int depth;

    public GameTree(int depth) {
        this.depth = depth;
    }

    public void generateFromBoard(Board board, String aiCharacter) {
        root = new Node(board);
        Node currentNode = root;
        String currentPlayer = aiCharacter;

        for (int i = 0; i < depth; i++) {
            for (int x = 0; x < board.getWidth(); x++) {
                for (int y = 0; y < board.getHeight(); y++) {
                    if (board.getCell(x, y).equals(" ")) {
                        Move move = new Move(x, y, currentPlayer);
                        Node child = new Node(move, board);
                        currentNode.addChild(child);
                    }
                }
            }

            currentPlayer = board.getOtherPlayer(currentPlayer);
        }

    }

    public Move getBestMove() {
        double bestScore = root.getChildren().get(0).getScore();
        Node bestNode = root.getChildren().get(0);
        for (Node child: root.getChildren()) {
            if (child.getScore() > bestScore) {
                bestScore = child.getScore();
                bestNode = child;
            }
        }

        return bestNode.getMove();
    }
}
