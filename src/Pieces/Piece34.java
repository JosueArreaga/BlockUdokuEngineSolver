package Pieces;

public class Piece34 extends Piece{
    /**
     *          0   0   x
     *          0   x   0
     *          x   0   0
     */

    @Override
    protected void makePiece() {
        node = new Node(2, 0);
        node.next = new Node(1, 1);
        node.next.next = new Node(0,2);
    }

    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public String toString() {
        return "        🟦" + "\n    🟦" + "\n🟦";
    }
}
