import Board.Board;
import Logic.Logic;
import Pieces.* ;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        Logic logic = new Logic(board);
        PieceGenerator pGenerator = new PieceGenerator();
        Piece piece1;
        Piece piece2;
        Piece piece3;
        int counter = 1;

        while (!logic.isGameOver()) {
            System.out.println("Round: " + counter);
            piece1 = pGenerator.getRandomPiece();
            piece2 = pGenerator.getRandomPiece();
            piece3 = pGenerator.getRandomPiece();
            logic.newTurn(piece1, piece2, piece3);
            counter++;
        }


//        int testNumber = 0;
//        int [] results = new int[1000];
//
//        while(true) {
//            Board board = new Board();
//            Logic logic = new Logic(board);
//            PieceGenerator pGenerator = new PieceGenerator();
//            Piece piece1;
//            Piece piece2;
//            Piece piece3;
//            int counter = 1;
//
//            while (!logic.isGameOver()) {
//                System.out.println("Round: " + counter);
//                piece1 = pGenerator.getRandomPiece();
//                piece2 = pGenerator.getRandomPiece();
//                piece3 = pGenerator.getRandomPiece();
//                logic.newTurn(piece1, piece2, piece3);
//                counter++;
//            }
//
//            results[testNumber] = counter;
//            testNumber++;
//            if(testNumber == 1000)
//                break;
//        }
//
//        for (int result : results) {
//            System.out.printf(result + ",");
//        }

    }
}

