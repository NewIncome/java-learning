/**
 * You are given a number of sticks of varying lengths. You will iteratively cut
 * the sticks into smaller sticks, discarding the shortest pieces until there are
 * none left. At each iteration you will determine the length of the shortest stick
 * remaining, cut that length from each of the longer sticks and then discard all
 * the pieces of that shortest length. When all the remaining sticks are the same
 * length, they cannot be shortened so discard them.
 * Given the lengths of n sticks, print the number of sticks that are left before
 * each iteration until there are none left.
 * • Input
 *  ♦ n space-separated integers, each an arr[i], where each value represents the
 *    length of the i^th stick.
 * • Returns
 *  ♦ int[]: the number of sticks after each iteration
 * • Constraints
 *  ♦ 1<= n <=1000
 *  ♦ 1<= arr[i] <=1000
 * • Example
 *  ♦ arr=[1,2,3]  //[3,2,1]
 * • TestCases
 *  ♦ arr=[5,4,4,2,2,8]  //[6,4,2,1]
 *  ♦ arr=[1,2,3,4,3,3,2,1]  //[8,6,4,1]
 * • Explanation
 *  sticks-length        length-of-cut   sticks-cut
 *   5 4 4 2 2 8             2               6
 *   3 2 2 _ _ 6             2               4
 *   1 _ _ _ _ 4             1               2
 *   _ _ _ _ _ 3             3               1
 *   _ _ _ _ _ _           DONE            DONE
 */
/*
 * Pseudocode
 * ○ Variables, need: int minStk; List<Integers> cutted, sortedCopyArr copy arr, int i=0
 * ○ Sort the arr and save it to sortedCopyArr
 * ○ get the minStk value from sortedArr[0]
 * ○ Loop While sortedCopyArr.length > 0
 *  • add an element to cutted = 0
 *  • define min
 *  • for(let j=0; j<sortedCopyArr.size(); j++)
 *   • if(sortedCopyArr.get(j)-minStk > 0) then
 *    ◙ cutted.set(i, current + 1)  //add 1 to cutted[i]
 *    ◙ substract minStk to sortedCopyArr[j]
 *   • else
 *    ◙ //remove sortedCopyArr[i]
 *    ◙ j -= 1;
 *   • ++i;
 * ○ return cutted
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class CutTheSticks {

  public static void main(String[] args) {
    //System.out.println(List.of(1,2,3));            //[3,2,1]
    System.out.println(cutTheSticks(Arrays.asList(5,4,4,2,2,8)));      //[6,4,2,1]
    //System.out.println(cutTheSticks(new ArrayList<>(Arrays.asList(1,2,3,4,3,3,2,1))));  //[8,6,4,1]
  }//end main

  public static List<Integer> cutTheSticks(List<Integer> arr) {
    int minStk = 0, i=0, j;
    List<Integer> cutted = new ArrayList<>();
    List<Integer> sortedArr = new ArrayList<>(arr);
    Collections.sort(sortedArr);
    
    //System.out.println(sortedArr);
    while(sortedArr.size() > 0 && i < arr.size()) {
      cutted.add(0);
      minStk = sortedArr.get(0);
      j=0;
      while(j < sortedArr.size()) {
        sortedArr.set(j, (sortedArr.get(j) - minStk));
        cutted.set(i, cutted.get(i) + 1);
        /* System.out.println("j: " + j + ", sortedArr.get(j) == 0 ?: " + sortedArr.get(j)
        + " == 0: " + (sortedArr.get(j) == 0)); */
        /* System.out.println("i: " + i + ", j: " + j + ", minStk: " + minStk +
        ", cutted: " + cutted + ", sortedArr: " + sortedArr +
        ", sortedArr.get(j): " + sortedArr.get(j));
        System.out.println(); */
        if(sortedArr.get(j) == 0) {
          sortedArr.remove(j);
          j-=1;
        }
        ++j;
        //System.out.println("Bottom of 2nd while, j: " + i);
      }
      ++i;
      //System.out.println("Bottom of 1st while, i: " + i);
    }
    
    return cutted;
  }//end cutTheSticks

}
