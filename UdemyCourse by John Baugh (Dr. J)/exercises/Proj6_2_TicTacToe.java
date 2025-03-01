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
 * 4. getUserInput: getsUser input, if valid, sets the board
 * 5. cellAlreadyOccupied: returns true if a cell is occupied
 * 6. getWinner: returns 'X' or 'O' if there is a clear winner
 * 7. isBoardFull: returns if the board is full or not
 */
public class Proj6_2_TicTacToe {
  public static void main(String[] args) {
    String[][] BASE_BOARD = new String[3][3];

  }//end main

  public static void runGame() {}//end runGame
  public static void initializeGameBoard(String[][] gameBoard) {}//end initializeGameBoard
  public static void printCurrentBoard(String[][] gameBoard) {}//end printCurrentBoard
  public static void getUserInput(boolean xTurn, String[][] gameBoard) {}//end getUserInput
  public static boolean cellAlreadyOccupied(int row, int col, String[][] gameBoard) {
    return false;
  }//end cellAlreadyOccupied
  public static char getWinner(String[][] gameBoard) {
    return ' ';
  }//end getWinner
  public static boolean isBoardFull(String[][] gameBoard) {
    return false;
  }//end isBoardFull
  
}
