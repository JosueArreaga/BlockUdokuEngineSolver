package Board;

import Pieces.*;
import Square.Square;

import java.util.ArrayList;
import java.util.LinkedList;


public class Board implements Cloneable{
    final int boardLength = 9, boardWidth = 9;
    Square[][] board;

    boolean isMoveNotPlayable;

    public Board(){
        Square[][] board = new Square[boardLength][boardWidth];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = new Square();
            }
        }

        this.board = board;
    }


    public void setMove(Piece piece, Piece piece2, Piece piece3) {
        ArrayList<Board> bestBoards = new ArrayList<Board>();
        boolean isOneLegal = false, isTwoLegal = false, isThreeLegal = false;

        bestBoards = obtainingBestBoards(piece, piece2, piece3, bestBoards); // I have the list of all best boards guaranteed for each piece.
        isGameOver(bestBoards);

        isOneLegal = bestBoards.get(0) != null;
        isTwoLegal = bestBoards.get(1) != null;
        isThreeLegal = bestBoards.get(2) != null;

        if(isOneLegal && isTwoLegal && isThreeLegal){
            permutationsAllBoards(piece, piece2, piece3, bestBoards);
        }
        else {
            System.out.println("______________________________________________________________________________________________________________________");
            isMoveNotPlayable = true;
        }


//        testingPiece(piece,gameInstances);
//        findingBestBoard(gameInstances);
//        isGameOver(gameInstances);

    }

    private void permutationsAllBoards(Piece piece, Piece piece2, Piece piece3, ArrayList<Board> bestBoards) {
        ArrayList<Board> newBoards = new ArrayList<Board>();
        Board currentBoard = null;
        int score1 = bestBoards.get(0).evaluatePosition(), score2 = bestBoards.get(1).evaluatePosition(), score3 = bestBoards.get(2).evaluatePosition();
        boolean newBoardOneExists = false, newBoardTwoExists = false, newBoardThreeExists = false;

        if(score1 >= score2 && score1 >= score3) {
            board = bestBoards.get(0).board;
            System.out.println("inside piece 1");
            printBoard();
            currentBoard = clone();

            newBoardTwoExists = cleaningBoards(bestBoards, piece2);
            if(newBoardTwoExists)
                newBoards.add(clone());
            board = currentBoard.board;


            newBoardThreeExists = cleaningBoards(bestBoards,piece3);
            if(newBoardThreeExists)
                newBoards.add(clone());

            if(newBoards.size() == 2){
                score2 = newBoards.get(0).evaluatePosition();
                score3 = newBoards.get(1).evaluatePosition();
            }
            else if(newBoardTwoExists){
                score2 = newBoards.get(0).evaluatePosition();
                score3 = -1;
            }
            else if(newBoardThreeExists){
                score3 = newBoards.get(0).evaluatePosition();
                score2 = -1;
            }
            else {
                System.out.println("1***********************************************GAME OVER ************************************************************************0");
                isMoveNotPlayable = true;
                return;
            }
            if(score2 >= score3){
                board = newBoards.get(0).board;
                System.out.println("piece 2 of 1");
                printBoard();

                newBoardThreeExists = cleaningBoards(bestBoards, piece3);
                if(!newBoardThreeExists){
                    System.out.println("1***********************************************GAME OVER ************************************************************************3");
                    isMoveNotPlayable = true;
                    return;
                }

                System.out.println("piece 3 of 1");

            }else{
                if(newBoardTwoExists && newBoardThreeExists){
                    board = newBoards.get(1).board;
                }
                else
                    board = newBoards.get(0).board;
                System.out.println("piece 3 of 1");
                printBoard();

                newBoardTwoExists = cleaningBoards(bestBoards, piece2);
                if(!newBoardTwoExists){
                    System.out.println("1***********************************************GAME OVER ************************************************************************2");
                    isMoveNotPlayable = true;
                    return;
                }
                System.out.println("piece 2 of 1");
            }
        }

        else if(score2 >= score1 && score2 >= score3){
            board = bestBoards.get(1).board;
            System.out.println("inside piece 2");
            printBoard();
            currentBoard = clone();

            newBoardOneExists = cleaningBoards(bestBoards, piece);
            if(newBoardOneExists)
                newBoards.add(clone());
            board = currentBoard.board;

            newBoardThreeExists = cleaningBoards(bestBoards,piece3);
            if(newBoardThreeExists)
                newBoards.add(clone());

            if(newBoards.size() == 2) {
                score1 = newBoards.get(0).evaluatePosition();
                score3 = newBoards.get(1).evaluatePosition();
            }
            else if(newBoardOneExists){
                score1 = newBoards.get(0).evaluatePosition();
                score3 = -1;
            } else if (newBoardThreeExists) {
                score3 = newBoards.get(0).evaluatePosition();
                score1 = -1;
            }
            else {
                System.out.println("2***********************************************GAME OVER ************************************************************************0");
                isMoveNotPlayable = true;
                return;
            }


            if(score1 >= score3){
                board = newBoards.get(0).board;
                System.out.println("piece 1 of 2");
                printBoard();

                newBoardThreeExists = cleaningBoards(bestBoards, piece3);
                if (!newBoardThreeExists) {
                    System.out.println("2***********************************************GAME OVER ************************************************************************3");
                    isMoveNotPlayable = true;
                    return;
                }
                System.out.println("piece 3 of 2");

            }
            else{
                if(newBoardOneExists && newBoardThreeExists)
                    board = newBoards.get(1).board;
                else
                    board = newBoards.get(0).board;
                System.out.println("piece 3 of 2");
                printBoard();

                newBoardOneExists = cleaningBoards(bestBoards, piece);
                if(!newBoardOneExists){
                    System.out.println("2***********************************************GAME OVER ************************************************************************1");
                    isMoveNotPlayable = true;
                    return;
                }

                System.out.println("piece 1 of 2");
            }
        }

        else {
            board = bestBoards.get(2).board;
            System.out.println("inside piece 3");
            printBoard();
            currentBoard = clone();

            newBoardOneExists = cleaningBoards(bestBoards, piece);
            if(newBoardOneExists)
                newBoards.add(clone());
            board = currentBoard.board;

            newBoardTwoExists = cleaningBoards(bestBoards,piece2);
            if(newBoardTwoExists)
                newBoards.add(clone());

            if(newBoards.size() == 2) {
                score1 = newBoards.get(0).evaluatePosition();
                score2 = newBoards.get(1).evaluatePosition();
            }
            else if(newBoardOneExists){
                score1 = newBoards.get(0).evaluatePosition();
                score2 = -1;
            }
            else if (newBoardTwoExists){
                score2 = newBoards.get(0).evaluatePosition();
                score1 = -1;
            }
            else {
                System.out.println("3***********************************************GAME OVER ************************************************************************0");
                isMoveNotPlayable = true;
                return;
            }

            if(score1 >= score2){
                board = newBoards.get(0).board;
                System.out.println("piece 1 of 3");
                printBoard();

                newBoardTwoExists = cleaningBoards(bestBoards,piece2);
                if(!newBoardTwoExists){
                    System.out.println("3***********************************************GAME OVER ************************************************************************2");
                    isMoveNotPlayable = true;
                    return;
                }
                System.out.println("piece 2 of 3");


            }else{
                if(newBoardOneExists && newBoardTwoExists)
                    board = newBoards.get(1).board;
                else
                    board = newBoards.get(0).board;
                System.out.println("piece 2 of 3");
                printBoard();


                newBoardOneExists = cleaningBoards(bestBoards, piece);
                if(!newBoardOneExists){
                    System.out.println("3***********************************************GAME OVER ************************************************************************1");
                    isMoveNotPlayable = true;
                    return;
                }
                System.out.println("piece 1 of 3");
            }
        }

    }

    private boolean cleaningBoards(ArrayList<Board> bestBoards, Piece piece) {
        bestBoards = new ArrayList<Board>();
        testingPiece(piece, bestBoards);
        return findingBoard(bestBoards);
    }


    private ArrayList<Board> obtainingBestBoards(Piece piece, Piece piece2, Piece piece3, ArrayList<Board> gameInstances) {

        ArrayList<Board> bestBoards = new ArrayList<Board>(); // gets the best board of each possible piece variation
        Board originalBoard = clone();  // Keeps track of original board

        testingPiece(piece, gameInstances);
        findingBestBoard(gameInstances);

        if(gameInstances.isEmpty())
            bestBoards.add(null);
        else
            bestBoards.add(clone());

        board = originalBoard.board;

        gameInstances = new ArrayList<>();
        testingPiece(piece2, gameInstances);
        findingBestBoard(gameInstances);

        if(gameInstances.isEmpty())
            bestBoards.add(null);
        else
            bestBoards.add(clone());

        board = originalBoard.board;

        gameInstances = new ArrayList<Board>();
        testingPiece(piece3, gameInstances);
        findingBestBoard(gameInstances);

        if(gameInstances.isEmpty())
            bestBoards.add(null);
        else
            bestBoards.add(clone());

        return bestBoards;
    }

    private void isGameOver(ArrayList<Board> gameInstances) {
        if (gameInstances.get(0) == null && gameInstances.get(1) == null && gameInstances.get(2) == null)
            isMoveNotPlayable = true;

        //System.out.println("Piece Does Not Fit! GAME OVER");
    }

    private void findingBestBoard(ArrayList<Board> gameInstances) {
        if(gameInstances.size() > 0){
            board = gameInstances.get(0).board;
            int score = gameInstances.get(0).evaluatePosition();


            for(Board b: gameInstances){
                if(b.evaluatePosition() > score){
                    board = b.board;
                    score = b.evaluatePosition();
                }
            }
        }
    }


    private boolean findingBoard(ArrayList<Board> gameInstances) {
        if(gameInstances.size() > 0){
            board = gameInstances.get(0).board;
            int score = gameInstances.get(0).evaluatePosition();


            for(Board b: gameInstances){
                if(b.evaluatePosition() > score){
                    board = b.board;
                    score = b.evaluatePosition();
                }
            }

        }
        return gameInstances.size() > 0;
    }

    private void testingPiece(Piece piece, ArrayList<Board> gameInstances) {

        Node testing;
        Node setting;
        isMoveNotPlayable = false;
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

                        gameInstances.add(currentBoard);
                    }

                }

            }
        } catch (Exception e){ // indexOutOfBounds e
            return; // e
        }

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

        if(isMoveNotPlayable)
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

    public int evaluatePosition(){
        return BlocksExploded() * 10000 + PiecesThatFit();
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
        int piecesCount = 0;

        boolean aPieceExists = false; // this flag helps us know that at least one piece exists.

        Piece [] piecesArray = {new Piece1(), new Piece2(), new Piece3(), new Piece4(), new Piece5(), new Piece6(), new Piece7(), new Piece8(), new Piece9(), new Piece10(),
        new Piece11(), new Piece12(), new Piece13(), new Piece14(), new Piece15(), new Piece16(), new Piece17(), new Piece18(), new Piece19(), new Piece20(), new Piece21(),
        new Piece22(), new Piece23(), new Piece24(), new Piece25(), new Piece26(), new Piece27(), new Piece28(), new Piece29(), new Piece30(), new Piece31(), new Piece32(),
        new Piece33(), new Piece34(), new Piece35(), new Piece36(), new Piece37(), new Piece38(), new Piece39(), new Piece40(), new Piece41(), new Piece42(), new Piece43()};

        for(Piece p : piecesArray){

            Node testing;
            isMoveNotPlayable = false;
            int size = p.getSize();
            int emptyCount = 0;
            int eachPieceCount = 0;

            try{
                for(int i = 0; i < board.length; ++i) {
                    for(int j = 0; j < board[0].length; ++j) {
                        testing = p.getNode();
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
                            eachPieceCount++;
                            aPieceExists = true;
                        }
                    }
                    //System.out.println();
                }
            } catch (Exception e){ // indexOutOfBounds e
                System.out.println("something weird in pieces that fit class.");
            }

            /* System.out.println(p); System.out.println(eachPieceCount); System.out.println(); */

            if(aPieceExists)
                piecesCount += (eachPieceCount + 1000);
        }

        return piecesCount;
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
