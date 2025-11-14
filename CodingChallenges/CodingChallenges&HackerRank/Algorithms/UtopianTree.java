/**
 * The Utopian Tree goes through 2 cycles of growth every year. Each
 * spring, it doubles in height. Each summer, its height increases by 1
 * meter. A Utopian Tree sapling with a height of 1 meter is planted at
 * the onset of spring. How tall will the tree be after  growth cycles?
 * For example, if the number of growth cycles is , the calculations are
 * as follows:
 *  Period  Height
 *  0          1
 *  1          2
 *  2          3
 *  3          6
 *  4          7
 *  5          14
 * 
 * • Returns
 *  ♦ int: the height of the tree after the given number of cycles
 * 
 * • Constraints
 *  ♦ 1 <= t <= 10
 *  ♦ 0 <= n <= 60
 * 
 * • TestCases
 *  ♦ int = 0, 1, 4   //1, 2, 7
 */
/*
 * Pseudocode
 * ○ Declare a var int heightIncrement = 1
 * ○ if n=0 return heightInc
 * ○ loop from 1 to n times
 *  + if i % 0 != 0(impair) then heightInc *= 2
 *  + else then heightInc += 1
 * ○ return heightInc
 */
public class UtopianTree {
  public static void main(String[] args) {
    System.out.println(result(5)); //14
    System.out.println(result(0)); //1
    System.out.println(result(1)); //2
    System.out.println(result(4)); //7
  }//end main

  public static int result(int n) {
    int heightInc = 1;
    
    for (int i = 1; i <= n; i++) {
      if(i % 2 != 0) heightInc *= 2;
      else heightInc ++;
    }

    return heightInc;
  }//end result
}