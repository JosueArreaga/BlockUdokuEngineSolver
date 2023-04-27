package Pieces;

public class Piece4 extends Piece{
    /**
     *          0   x
     *          x   0
     */

    @Override
    protected void makePiece() {
        node = new Node(1, 0);
        node.next = new Node(0, 1);
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public String toString() {
        return "  🟦" + "\n🟦";
    }
}
