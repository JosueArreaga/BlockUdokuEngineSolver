package Pieces;

public class Piece27 extends Piece{
    /**
     *      0   x
     *      0   x
     *      x   x
     */

    @Override
    protected void makePiece() {
        node = new Node(1, 0);
        node.next = new Node(1, 1);
        node.next.next = new Node(0,2);
        node.next.next.next = new Node(1,2);
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public String toString() {
        return "  🟦" + "\n  🟦" + "\n🟦🟦";
    }
}
