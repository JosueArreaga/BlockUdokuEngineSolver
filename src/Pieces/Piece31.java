package Pieces;

public class Piece31 extends Piece {

    /**
     *      0   0   x
     *      0   0   x
     *      x   x   x
     */

    @Override
    protected void makePiece() {
        node = new Node(2, 0);
        node.next = new Node(2, 1);
        node.next.next = new Node(0,2);
        node.next.next.next = new Node(1,2);
        node.next.next.next.next = new Node(2,2);
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public String toString() {
        return "    🟦" + "\n    🟦" + "\n🟦🟦🟦";
    }
}
