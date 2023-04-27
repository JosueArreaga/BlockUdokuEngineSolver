package Logic;
import Board.Board;
import Pieces.Piece;
public class Logic {
    Board board;

    public Logic(Board board){
        this.board = board;
    }

    public void newTurn(Piece piece){
        printBoard();
        System.out.println(piece.toString() + "\n");
        setMove(piece);

        if(!isGameOver()){
            printBoard();
        }else{
            return;
        }
        board.clear();
        //printBoard();
    }

    public void setMove(Piece piece){
        board.setMove(piece);
    }

    public boolean isGameOver(){
        return board.gameOver();
    }

    public void printBoard(){
        board.printBoard();
    }
}
