package Pieces;

public class Piece14 extends Piece{
    /**
     *              x   0   0
     *              x   x   x
     *              x   0   0
     */


    @Override
    protected void makePiece() {
        node = new Node(0, 0);
        node.next = new Node(0, 1);
        node.next.next = new Node(1,1);
        node.next.next.next = new Node(2,1);
        node.next.next.next.next = new Node(0,2);
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public String toString() {
        return "🟦" + "\n🟦🟦🟦" + "\n🟦";
    }
}
