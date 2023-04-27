package Pieces;

public class Piece41 extends Piece{
    /**
     *          x
     *      x   x
     *      x
     */

    @Override
    protected void makePiece() {
        node = new Node(1, 0);
        node.next = new Node(0, 1);
        node.next.next = new Node(1,1);
        node.next.next.next = new Node(0,2);

    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public String toString() {
        return "  🟦" + "\n🟦🟦" + "\n🟦";
    }
}
