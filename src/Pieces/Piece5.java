package Pieces;

public class Piece5 extends Piece{
    /**
     *          x
     *              x
     */

    @Override
    protected void makePiece() {
        node = new Node(0, 0);
        node.next = new Node(1, 1);
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public String toString() {
        return "🟦" + "\n  🟦";
    }
}
