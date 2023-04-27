package Pieces;

import java.util.Random;

public class PieceGenerator {

    public PieceGenerator(){}

    public Piece getRandomPiece(){
        Random rnd = new Random();

        int result = rnd.nextInt(1, 44); // 1 to 8 for simple game. 1 to 44 for real game
        if(result == 1)
            return new Piece1();
        if(result == 2)
            return new Piece2();
        if(result == 3)
            return new Piece3();
        if(result == 4)
            return new Piece4();
        if(result == 5)
            return new Piece5();
        if(result == 6)
            return new Piece6();
        if(result == 7)
            return new Piece7();
        if(result == 8)
            return new Piece8();
        if(result == 9)
            return new Piece9();
        if(result == 10)
            return new Piece10();
        if(result == 11)
            return new Piece11();
        if(result == 12)
            return new Piece12();
        if(result == 13)
            return new Piece13();
        if(result == 14)
            return new Piece14();
        if(result == 15)
            return new Piece15();
        if(result == 16)
            return new Piece16();
        if(result == 17)
            return new Piece17();
        if(result == 18)
            return new Piece18();
        if(result == 19)
            return new Piece19();
        if(result == 20)
            return new Piece20();
        if(result == 21)
            return new Piece21();
        if(result == 22)
            return new Piece22();
        if(result == 23)
            return new Piece23();
        if(result == 24)
            return new Piece24();
        if(result == 25)
            return new Piece25();
        if(result == 26)
            return new Piece26();
        if(result == 27)
            return new Piece27();
        if(result == 28)
            return new Piece28();
        if(result == 29)
            return new Piece29();
        if(result == 30)
            return new Piece30();
        if(result == 31)
            return new Piece31();
        if(result == 32)
            return new Piece32();
        if(result == 33)
            return new Piece33();
        if(result == 34)
            return new Piece34();
        if(result == 35)
            return new Piece35();
        if(result == 36)
            return new Piece36();
        if(result == 37)
            return new Piece37();
        if(result == 38)
            return new Piece38();
        if(result == 39)
            return new Piece39();
        if(result == 40)
            return new Piece40();
        if(result == 41)
            return new Piece41();
        if(result == 42)
            return new Piece42();
        if(result == 43)
            return new Piece43();


        throw new IllegalArgumentException("Something went wrong: Piece in random class error");
    }
}
