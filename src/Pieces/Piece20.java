package Pieces;

public class Piece20 extends Piece{

    /**
     *      x   x   x   x
     */

    @Override
    protected void makePiece() {
        node = new Node(0, 0);
        node.next = new Node(1, 0);
        node.next.next = new Node(2,0);
        node.next.next.next = new Node(3,0);
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public String toString() {
        return "🟦🟦🟦🟦";
    }
}
