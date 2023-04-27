package Pieces;

public class Piece35 extends Piece{
    /**
     *          x   0   0
     *          0   x   0
     *          0   0   x
     */

    @Override
    protected void makePiece() {
        node = new Node(0, 0);
        node.next = new Node(1, 1);
        node.next.next = new Node(2,2);
    }

    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public String toString() {
        return """
                🟦
                    🟦
                        🟦""";
    }
}
