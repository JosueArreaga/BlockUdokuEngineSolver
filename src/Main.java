import Board.Board;
import Logic.Logic;
import Pieces.* ;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        Logic logic = new Logic(board);
        PieceGenerator pGenerator = new PieceGenerator();
        Piece piece;
        int counter = 1;

        while (!logic.isGameOver()) {
            System.out.println("Round: " + counter);
            piece = pGenerator.getRandomPiece();
            logic.newTurn(piece);
            counter++;
        }

    }
}

