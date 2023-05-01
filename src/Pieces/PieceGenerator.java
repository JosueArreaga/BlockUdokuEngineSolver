package Pieces;

import java.util.Random;

public class PieceGenerator {

    public PieceGenerator(){}

    public Piece getRandomPiece(){
        Random rnd = new Random();

        Piece [] piecesArray = {new Piece1(), new Piece2(), new Piece3(), new Piece4(), new Piece5(), new Piece6(), new Piece7(), new Piece8(), new Piece9(), new Piece10(),
                new Piece11(), new Piece12(), new Piece13(), new Piece14(), new Piece15(), new Piece16(), new Piece17(), new Piece18(), new Piece19(), new Piece20(), new Piece21(),
                new Piece22(), new Piece23(), new Piece24(), new Piece25(), new Piece26(), new Piece27(), new Piece28(), new Piece29(), new Piece30(), new Piece31(), new Piece32(),
                new Piece33(), new Piece34(), new Piece35(), new Piece36(), new Piece37(), new Piece38(), new Piece39(), new Piece40(), new Piece41(), new Piece42(), new Piece43()};



        int result = rnd.nextInt(1, 44); // 1 to 8 for simple game. 1 to 44 for real game

        try {
            return piecesArray[result - 1];
        }catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException(e + "something is weird in pieceGenerator");
        }
    }
}
