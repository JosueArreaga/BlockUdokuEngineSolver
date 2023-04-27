package Pieces;

public class Piece13 extends Piece{

    /**
     *         x   x   x
     *         0   x   0
     *         0   x   0
     */

    @Override
    protected void makePiece() {
        node = new Node(0, 0);
        node.next = new Node(1, 0);
        node.next.next = new Node(2,0);
        node.next.next.next = new Node(1,1);
        node.next.next.next.next = new Node(1,2);
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public String toString() {
        return "🟦🟦🟦" + "\n  🟦" + "\n  🟦";
    }
}
