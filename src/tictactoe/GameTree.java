package tictactoe;

/**
 * Created by vegard on 07.04.2016.
 */
public class GameTree {

    public static final double WIN_WEIGHT = 1.0;
    public static final double LOSS_WEIGHT = -1.0;
    public static final double DRAW_WEIGHT = 0.0;

    private Node root;
    private int turn;

    public GameTree(int turn) {
        this.turn = turn;
    }

    public void generateFromBoard(Board board, String aiCharacter) {
        root = new Node(board);
        root.generateChildren(aiCharacter, turn);
        /*Node currentNode = root;
        String currentPlayer = aiCharacter;

        for (int i = 0; i < turn; i++) {
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
        }*/

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
