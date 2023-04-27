package Pieces;

import java.util.Random;

public abstract class Piece {

    protected Node node;

    public Piece(){
        makePiece();
    }
    protected abstract void makePiece();
    public abstract int getSize();

    public Node getNode() {
        return node;
    }


    public abstract String toString();
}
