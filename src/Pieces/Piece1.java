package Pieces;

public class Piece1 extends Piece{

    /**
     *          x
     */

    @Override
    protected void makePiece(){
        node = new Node(0,0);
    }

    @Override
    public int getSize(){
        return 1;
    }

    @Override
    public String toString() {
        return "🟦";
    }


}
