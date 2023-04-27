package Pieces;

public class Piece25 extends Piece{
    /**
     *      x   x
     *          x
     */

    @Override
    protected void makePiece() {
        node = new Node(0, 0);
        node.next = new Node(1, 0);
        node.next.next = new Node(1,1);
    }

    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public String toString() {
        return "🟦🟦" + "\n  🟦";
    }
}
