package Board;

import Pieces.Node;
import Pieces.Piece;
import Square.Square;

import java.util.ArrayList;
import java.util.LinkedList;


public class Board implements Cloneable{
    final int boardLength = 9, boardWidth = 9;
    Square[][] board;

    boolean isMovePlayable;

    public Board(){
        Square[][] board = new Square[boardLength][boardWidth];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = new Square();
            }
        }

        this.board = board;
    }


    public void setMove(Piece piece) {

        ArrayList<Board> gameInstances = new ArrayList<>();

        Node testing;
        Node setting;
        isMovePlayable = false;
        //int k = 0;

        int size = piece.getSize();
        int emptyCount = 0;

        try{
            for(int i = 0; i < board.length; ++i) {
                for(int j = 0; j < board[0].length; ++j) {
                    testing = piece.getNode();
                    setting = piece.getNode();
                    emptyCount = 0;

                    while (testing!= null){
                        try{
                            if(!board[i + testing.yValue][j + testing.xValue].isEmpty())
                                emptyCount++;
                            testing = testing.next;
                        }
                        catch (IndexOutOfBoundsException e){
                            //                            System.out.println("Index out of bounds");                       Helps Debug
                            testing = testing.next;
                        }
                    }


                    if(size == emptyCount){
                        //                        System.out.println("here");                       Helps Debug

                        Board currentBoard = clone();
                        while (setting != null){
                            //System.out.println(setting.xValue + " " + setting.yValue);        Helps Debug
                            currentBoard.board[i + setting.yValue][j + setting.xValue].Occupy();
                            setting = setting.next;
                        }
//                        throw new Exception();
                        //k++;
                        //System.out.println(k);
                        gameInstances.add(currentBoard);
                    }

                }
                //System.out.println();
            }
        } catch (Exception e){ // indexOutOfBounds e
            return; // e
        }

//        System.out.println("Number of game instances");
//        System.out.println(gameInstances.size());


        if(gameInstances.size() > 0){
            board = gameInstances.get(0).board;
            int score = gameInstances.get(0).EvaluatePosition();


            for(Board b: gameInstances){
                if(b.EvaluatePosition() > score){
                    board = b.board;
                    score = b.EvaluatePosition();
                }
                //b.printBoard();
            }

            return;
        }


        isMovePlayable = true;
        System.out.println("Piece Does Not Fit! GAME OVER");
    }


    public void printBoard(){
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Boolean gameOver() {

        if(isMovePlayable)
            return true;

        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(!board[i][j].isEmpty()){
                    return false;
                }
            }
        }

        return true;
    }

    public void clear() {

        LinkedList<Square> list = new LinkedList<>();

        verticalClear(list);
        horizontalClear(list);
        squareFullClear(list,0,3,0,3);
        squareFullClear(list,0,3,3,6);
        squareFullClear(list,0,3,6,9);
        squareFullClear(list,3,6,0,3);
        squareFullClear(list,3,6,3,6);
        squareFullClear(list,3,6,6,9);
        squareFullClear(list,6,9,0,3);
        squareFullClear(list,6,9,3,6);
        squareFullClear(list,6,9,6,9);

        for (Square square : list) {
            square.Empty();
        }

    }

    private void squareFullClear(LinkedList<Square> list, int iVal, int imVal, int jVal, int jmVal) {

        for(int i = iVal; i < imVal; i++){
            for(int j = jVal; j < jmVal; j++){
                if(!board[i][j].isEmpty())
                    return;
            }
        }

        for(int i = iVal; i < imVal; i++){
            for(int j = jVal; j < jmVal; j++){
                list.add(board[i][j]);
            }
        }
    }


    private void verticalClear(LinkedList<Square> list) {
        try {
            for (int j = 0; j < board.length; j++) {
                if (board[0][j].isEmpty() && board[1][j].isEmpty() && board[2][j].isEmpty() &&
                        board[3][j].isEmpty() && board[4][j].isEmpty() && board[5][j].isEmpty() &&
                        board[6][j].isEmpty() && board[7][j].isEmpty() && board[8][j].isEmpty()) {
                    list.add(board[0][j]);
                    list.add(board[1][j]);
                    list.add(board[2][j]);
                    list.add(board[3][j]);
                    list.add(board[4][j]);
                    list.add(board[5][j]);
                    list.add(board[6][j]);
                    list.add(board[7][j]);
                    list.add(board[8][j]);
                }
            }
        } catch (IndexOutOfBoundsException e) {}
    }

    private void horizontalClear(LinkedList<Square> list) {
        try {
            for (int i = 0; i < board.length; i++) {
                if (board[i][0].isEmpty() && board[i][1].isEmpty() && board[i][2].isEmpty() &&
                        board[i][3].isEmpty() && board[i][4].isEmpty() && board[i][5].isEmpty() &&
                        board[i][6].isEmpty() && board[i][7].isEmpty() && board[i][8].isEmpty()) {
                    list.add(board[i][0]);
                    list.add(board[i][1]);
                    list.add(board[i][2]);
                    list.add(board[i][3]);
                    list.add(board[i][4]);
                    list.add(board[i][5]);
                    list.add(board[i][6]);
                    list.add(board[i][7]);
                    list.add(board[i][8]);
                }
            }
        } catch (IndexOutOfBoundsException e) {}
    }


    public Board clone(){
        try {
            Board newBoard = (Board) super.clone();
            newBoard.board = new Square[board.length][board.length];
            for (int i=0; i<newBoard.board.length; i++) {
                for (int j=0; j<newBoard.board[i].length; j++) {
                    newBoard.board[i][j] = board[i][j].clone();
                }
            }
            return newBoard;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public int EvaluatePosition(){
        return BlocksExploded();
    }

    public int BlocksExploded(){
        int before = currentBlocks();
        clear();
        int after = currentBlocks();
        return before - after;
    }

    public int WhiteSpacesInBetween(){
        return 0;
    }

    public int PiecesThatFit(){
        return 0;
    }

    public int currentBlocks (){
        int count = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j].isEmpty())
                    count++;
            }
        }
        return count;
    }

}
