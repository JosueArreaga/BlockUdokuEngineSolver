package Pieces;

public class Piece29 extends Piece {
    /**
     *      x   x   x
     *              x
     */

    @Override
    protected void makePiece() {
        node = new Node(0, 0);
        node.next = new Node(1, 0);
        node.next.next = new Node(2,0);
        node.next.next.next = new Node(2,1);
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public String toString() {
        return "🟦🟦🟦" + "\n    🟦";
    }
}
