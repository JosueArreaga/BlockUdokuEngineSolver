package Pieces;

public class Piece2 extends Piece{
    /**
     *          x   x
     */


    @Override
    protected void makePiece(){
        node = new Node(0,0);
        node.next = new Node(1,0);
    }

    @Override
    public int getSize(){
        return 2;
    }

    @Override
    public String toString() {
        return "🟦" + "🟦";
    }
}
