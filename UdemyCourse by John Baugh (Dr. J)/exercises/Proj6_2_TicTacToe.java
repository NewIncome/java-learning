/**
 * Project to implement the game Tic-tac-toe
 * or Noughts-and-crosses
 * 
 * Players take turns placing their "x" or "o" symbols in
 * a 3x3 game board like the following
 *  x|○|○
 *  -----
 *  x|○|x
 *  -----
 *  ○|x|x
 * • You win if you get three in a row, in a column, a row,
 * or diagonal
 * • If no one wins it is a tie
 */

/*
 * Possible/recommended steps/functions to use:
 * 1. runGame: start the game loop, could just be 'main'
 * 2. initializeGameBoard: set the board
 * 3. printCurrentBoard: prints whats in the currentBoard
 * 4. getSetUserInput: getsUser input, if valid, sets the board
 * 5. cellAlreadyOccupied: returns true if a cell is occupied
 * 6. getWinner: returns 'X' or 'O' if there is a clear winner
 * 7. isBoardFull: returns if the board is full or not
 * additionals:
 * + isMoveValid?
 */
import java.util.Arrays;
import java.util.Scanner;

public class Proj6_2_TicTacToe {
  /*String[][] gameBoardValues = { // Declared and initialized with spaces at the same time
    {" ", " ", " "},
    {" ", " ", " "},
    {" ", " ", " "}
}; // But won't be used for cleaner more oganized purposes*/
  public static void main(String[] args) {
    String[][] gameBoardValues = new String[3][3]; // only Declaration
    char turn = 'X';

    initializeGameBoard(gameBoardValues);
    runGame();
    //printCurrentBoard(gameBoardValues);
    getSetUserInput(turn, gameBoardValues);
  }//end main

  public static void runGame() {
    System.out.println("Welcome to the Tic-Tac-Toe game!");
    System.out.println("Please choose your move by typing 2 digts,");
    System.out.println("first one for the row, second for the column,");
    System.out.println("like: 00, 01, 02, 10, 11, 12, 20, 21, 22");
    System.out.println("Have fun!!\n");
  }//end runGame

  public static void initializeGameBoard(String[][] gameBoard) {
    for(String[] row : gameBoard) {
      Arrays.fill(row, " ");
    }
  }//end initializeGameBoard
  
  public static void printCurrentBoard(String[][] gameBoard) {
    System.out.println("\n   Game Board, current");
    System.out.println("\t  0 1 2");

    for(int i = 0; i < gameBoard.length; i++) {
      System.out.println("\t" + i + " " + gameBoard[i][0] + "|" + gameBoard[i][1] + "|" + gameBoard[i][2]);
      if(i == 2) { continue; }
      System.out.println("\t  - - -");
    }//end for i
    System.out.println();
  }//end printCurrentBoard

  public static void getSetUserInput(char xTurn, String[][] gameBoard) {
    Scanner userIn = new Scanner(System.in);
    String move;
    boolean valid;
    int[] rowCol = new int[2];

    //get the user's move
    System.out.println("It's your turn player " + xTurn);
    System.out.println("Please choose your move:");
    move = userIn.nextLine();

    //check the user move for validity and cellOccupation
    valid = isMoveValid(move);
    rowCol[0] = Integer.parseInt(move.substring(0, 1));
    rowCol[1] = Integer.parseInt(move.substring(1));

    System.out.println("\nWas the move valid? : " + valid + "\n");

    while(!valid || cellAlreadyOccupied(rowCol[0], rowCol[1], gameBoard)) {
      System.out.println("That was not a valid move or the cell was occupied");
      System.out.println("Please choose a valid move:");
      move = userIn.nextLine();
      valid = isMoveValid(move);
    }

    //set the userMove
    System.out.println("All valid, ready to set your move");
  }//end getSetUserInput

  public static boolean isMoveValid(String move) {
    String[] possibleMoves = { //Decalration and Initialization in same scentence
       "00", "01", "02", "10", "11", "12", "20", "21", "22"
    };

    for(String m : possibleMoves) {
      if(move.equals(m)) {
        return true;
      }
    }
    return false;
  }//end isMoveValid

  public static boolean cellAlreadyOccupied(int row, int col, String[][] gameBoard) {
    if(gameBoard[row][col] != " ") {
      return true;
    }
    return false;
  }//end cellAlreadyOccupied

  public static char getWinner(String[][] gameBoard) {
    return ' ';
  }//end getWinner

  public static boolean isBoardFull(String[][] gameBoard) {
    return false;
  }//end isBoardFull
  
}
