/**
 * Given a positive integer n, return the nth row of pascal's triangle.
 * Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.
 *            1
 *          1   1
 *        1   2   1         <- 3rd row
 *      1   3   3   1       <- 4th row
 *    1   4   6   4   1     <- 5th row
 *  1   5  10  10   5   1   <- 6th row
 * 
 * Constraints:
 *  1 ≤ n ≤ 20
 */
/*
 * For this try we will use Jagged Arrays
 */
import java.util.Arrays;

public class PascalTriangle {
  public static void main(String[] args) {
    makingAll(2);
    makingAll(5);
    makingAll(7);
  }

  public static void makingAll(int n) {
    int[][] pTriang = new int[n][];
    pTriang[0] = new int[]{1};
    if(n > 1) pTriang[1] = new int[]{1,1};

    if(n > 2) {
      for(int i = 2; i < n; i++) {
        pTriang[i] = new int[i + 1]; //to create the nth row
  
        for(int j = 0; j <= i; j++) { //to fill the row
          //System.out.println("i: " + i + ", j: " + j);
          if(j == 0 || j == i) pTriang[i][j] = 1;
          else pTriang[i][j] = pTriang[i-1][j-1] + pTriang[i-1][j];
        }
      }
    }

    //For 1D Arrays -->  Arrays.toString(array)
    //System.out.println(Arrays.deepToString(pTriang)); //For +2D
    System.out.println(Arrays.toString(pTriang[n-1]));
  }
}
/*
 * Time Complexity O(n^2) if n>2
 */

/*  There's a problem in the code of the page and couln't test it there
  class Solution {
  ArrayList<Integer> nthRowOfPascalTriangle(int n) {
      // code here
      int[][] pTriang = new int[n][];

      for(int i = 0; i < n; i++) {
        pTriang[i] = new int[i + 1]; //to create the nth row

        for(int j = 0; j < i; j++) { //to fill the row
          pTriang[i][j] = j + 1;
        }
      }

      System.out.println(pTriang);
  }
}*/