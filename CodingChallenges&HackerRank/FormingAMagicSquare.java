import java.util.List;

/**
 * We define a magic square to be an n x n matrix of distinct positive
 * integers from 1 to n^2 where the sum of any row, column, or diagonal of
 * length n is always equal to the same number: the magic constant.
 * You will be given a 3x3 matrix s of integers in the inclusive range
 * [1,9]. We can convert any digit  to any other digit a in the range
 * [1,9] at cost of |a-b|. Given s, convert it into a magic square at minimal cost.
 * Print this cost on a new line.
 * 
 * Note: The resulting magic square must contain distinct integers in the inclusive range [1,9].
 * 
 * • Example
 *  $s = [[5, 3, 4], [1, 5, 8], [6, 4, 2]]    //7
 *  we can convert it to: [[8, 3, 4], [1, 5, 9], [6, 7, 2]]
 *  this took 3 repolacements at cost:  |5-8|+|8-9|+|4-7| = 7
 * 
 * • Needs_return:
 *  ♦ int: int: the minimal total cost of converting the input square to a magic square
 *  ♦ Matrix needs to be like:
 *     8 3 4
 *     1 5 9
 *     6 7 2
 * 
 * • Constraints
 *  ♦ s[i][j] E [1,9]
 * 
 * • Test Cases ()
 *  ♦ s = [[4, 9, 2], [3, 5, 7], [8, 1, 5]]    //1
 *  ♦ s = [[4, 8, 2], [4, 5, 7], [6, 1, 6]]    //4
 * 
 */
/*
 * Paterns:
 * + all the rows, & cols must sum to 15
 * + there are only 8 possible magic squares
 *  + and there are 8 ways to sum to 15 with(1-9)
 * + 5 appears 4 times in those sums
 *  + becuase of this 5 always goes in the MIDDLE
 * + 1, 3, 7, 9, appear 2 times
 *  + therefor they will be EDGES(are part of 2 sums)
 *  + 1 is opposite of 9
 *  + 3 is opposite of 7
 * + 2, 4, 6, 8, appear 3 times
 *  + therefor they will be CORNERS(are part of 3 sums)
 *  + 4 is beside 9 & 3, and opposite to 6
 *  + 8 is beside 3 & 1, and opposite to 2
 *  + 6 is beside 7 & 1, and opposite to 4
 *  + 2 is beside 9 & 7, and opposite to 8
 * 
 *   1+9+5
 *   2+8+5
 *   3+7+5
 *   4+6+5
 *   4+3+8
 *   6+2+7
 *   6+1+8
 *   9+2+4
 *   
 *   8 3 4    4 9 2    2 7 6    6 1 8
 *   1 5 9    3 5 7    9 5 1    7 5 3
 *   6 7 2    8 1 6    4 3 8    2 9 4
 *   
 *   8 1 6    6 7 2    2 9 4    4 3 8
 *   3 5 7    1 5 9    7 5 3    9 5 1
 *   4 9 2    8 3 4    6 1 8    2 7 6
 * 
 */
public class FormingAMagicSquare {
  public static void main(String[] args) {
    int[][] matrix1 = {{5, 3, 4}, {1, 5, 8}, {6, 4, 2}};
    System.out.println(resultOpt1(matrix1));
    int[][] matrix2 = {{4, 9, 2}, {3, 5, 7}, {8, 1, 5}};
    System.out.println(resultOpt1(matrix2));
    int[][] matrix3 = {{4, 8, 2}, {4, 5, 7}, {6, 1, 6}};
    System.out.println(resultOpt1(matrix3));
  }//end main

  public static int resultOpt1(List<List<Integer>> s) {
    int[][][] magicSquares = {
      {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
      {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
      {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
      {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
      {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
      {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
      {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
      {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}
    };

    int min_cost = Integer.MAX_VALUE; //A constant holding the maximum value an int can have: 231-1
    int cur_cost;

    //loop through the possible magic squares and compare them with our input
    for(int[][] magicSquare : magicSquares) {
      cur_cost = 0;
      for(int i=0; i<magicSquare.length; i++) {
        for(int j=0; j<magicSquare[i].length; j++) {
          cur_cost += Math.abs(s.get(i).get(j) - magicSquare[i][j]);
        }
      }

      if(cur_cost < min_cost) min_cost = cur_cost;
    }

    return min_cost;
  }
  /* public static int result(int[][] matrix) {
    //sum per row
    int sum;
    
    System.out.println("row1: " + (matrix[0][0]+matrix[0][1]+matrix[0][2]));
    System.out.println("row2: " + (matrix[1][0]+matrix[1][1]+matrix[1][2]));
    System.out.println("row3: " + (matrix[2][0]+matrix[2][1]+matrix[2][2]));

    System.out.println("col1: " + (matrix[0][0]+matrix[1][0]+matrix[2][0]));
    System.out.println("col2: " + (matrix[0][1]+matrix[1][1]+matrix[2][1]));
    System.out.println("col3: " + (matrix[0][2]+matrix[1][2]+matrix[2][2]));

    System.out.println("diag1: " + (matrix[0][0]+matrix[1][1]+matrix[2][2]));
    System.out.println("diag2: " + (matrix[0][2]+matrix[1][1]+matrix[2][0]));

    return 0;
  }//end result */
}
