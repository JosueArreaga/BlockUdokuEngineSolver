package Logic;
import Board.Board;
import Pieces.Piece;
public class Logic {
    Board board;

    public Logic(Board board){
        this.board = board;
    }

    public void newTurn(Piece piece1, Piece piece2, Piece piece3){
        printBoard();
        System.out.println(piece1.toString() + "\n");
        System.out.println(piece2.toString() + "\n");
        System.out.println(piece3.toString() + "\n");

        PlayMove(piece1, piece2, piece3);

        if(!isGameOver()){
            printBoard();
        }else{
            System.out.println("GAME OVER Pieces DO Not Fit");
            return;
        }
        board.clear();
    }

    public void PlayMove(Piece piece1, Piece piece2, Piece piece3){
        board.setMove(piece1, piece2, piece3);
    }

    public boolean isGameOver(){
        return board.gameOver();
    }

    public void printBoard(){
        board.printBoard();
    }
}
