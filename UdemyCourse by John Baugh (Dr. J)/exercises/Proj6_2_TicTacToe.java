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
 * + swapPlayer
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
    char[][] gameBoardValues = new char[3][3]; // only Declaration
    char turn = ' ';

    initializeGameBoard(gameBoardValues);
    runGame();
    printCurrentBoard(gameBoardValues);

    // Game will loop until there's a winner or the boardIsFull
    while(getWinner(gameBoardValues) == ' ' && !isBoardFull(gameBoardValues)) {
      turn = swapPlayer(turn);
      getSetUserInput(turn, gameBoardValues);
      printCurrentBoard(gameBoardValues);
    }

    //Winner announcement
    if(getWinner(gameBoardValues) == ' ') {
      System.out.println("It was a cat's game!\nTie in other words\nWe'll be waiting for the rematch");
    } else {
      System.out.println("Player " + turn + " is the Winner!!!");
    }
  }//end main

  public static void runGame() {
    System.out.println("Welcome to the Tic-Tac-Toe game!");
    System.out.println("Please choose your move by typing 2 digts,");
    System.out.println("first one for the row, second for the column,");
    System.out.println("like: 00, 01, 02, 10, 11, 12, 20, 21, 22");
    System.out.println("\n\tHave fun!!\n");
  }//end runGame

  public static void initializeGameBoard(char[][] gameBoard) {
    for(char[] row : gameBoard) {
      Arrays.fill(row, ' ');
    }
  }//end initializeGameBoard
  
  public static void printCurrentBoard(char[][] gameBoard) {
    System.out.println("\n   Game Board, current");
    System.out.println("\t  0 1 2");

    for(int i = 0; i < gameBoard.length; i++) {
      System.out.println("\t" + i + " " + gameBoard[i][0] + "|" + gameBoard[i][1] + "|" + gameBoard[i][2]);
      if(i == 2) { continue; }
      System.out.println("\t  - - -");
    }//end for i
    System.out.println();
  }//end printCurrentBoard

  public static void getSetUserInput(char xTurn, char[][] gameBoard) {
    Scanner userIn = new Scanner(System.in);
    String move;
    boolean valid;
    int row, col;

    //get the user's move
    System.out.println("It's your turn player " + xTurn);
    System.out.print("Please choose your move:");
    move = userIn.nextLine();

    //check the user move for validity and cellOccupation
    valid = isMoveValid(move);
    row = Integer.parseInt(move.substring(0, 1));
    col = Integer.parseInt(move.substring(1));

    while(!valid || cellAlreadyOccupied(row, col, gameBoard)) {
      System.out.println("That was not a valid move or the cell was occupied");
      System.out.println("You chose: " + row + col + ", that cell has de value: " + gameBoard[row][col]);
      printCurrentBoard(gameBoard);
      System.out.print("Please choose a valid move:");
      move = userIn.nextLine();
      valid = isMoveValid(move);
      row = Integer.parseInt(move.substring(0, 1));
      col = Integer.parseInt(move.substring(1));
    }

    //set the userMove
    gameBoard[row][col] = xTurn;
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

  public static char swapPlayer(char player) {
    if(player == 'O' || player == ' ') {
      return 'X';
    } else {
      return 'O';
    }
  }//end swapPlayer

  public static boolean cellAlreadyOccupied(int row, int col, char[][] gameBoard) {
    if(gameBoard[row][col] != ' ') {
      return true;
    }
    return false;
  }//end cellAlreadyOccupied

  public static char getWinner(char[][] gameBoard) {
    /* Possible Wins: same-symbol-on
    rows[row0(01,02,03), row1, row2], cols[[00,10,20], [01, 11, 21], [02,12,22]], diag[[00,11,22], [02,11,20]]
    */
    //1) Check Rows
    for(char[] row : gameBoard) {
      if(row[0] == row[1] && row[0] == row[2]) {
        return row[0];
      }
    }
    //2) Check Columns
    for(int i = 0; i < gameBoard.length; i++) {
      if(gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i]) {
        return gameBoard[0][i];
      }
    }
    //3) Check Diagonals
    if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2]) {
      return gameBoard[0][0];
    } else if(gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0]) {
      return gameBoard[0][2];
    }

    return ' ';
  }//end getWinner

  public static boolean isBoardFull(char[][] gameBoard) {
    for(char[] row : gameBoard) {
      for(int col = 0; col < row.length; col++) {
        if(row[col] == ' ') {
          return false;
        }
      }
    }

    return true;
  }//end isBoardFull
  
}
