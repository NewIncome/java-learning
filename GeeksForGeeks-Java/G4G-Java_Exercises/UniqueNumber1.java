/*
 * =- Unique Number I -=
 * Given a unsorted array arr[] of positive integers having all the numbers occurring exactly twice,
 * except for one number which will occur only once. Find the number occurring only once.
 * 
 * - Expected Complexities -
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 */
import java.util.ArrayList;

class UniqueNumber1 {
  public int findUnique(int[] arr) {
      // code here
      /*
       * 0 Create a variable int[] stack1
       * 1 Traverse through the arr
       * 2 if num isn't already in the stack, push it to the stack
       * 3 if it is already in the stack, remove it from the stack
       * 4 at the end, print remaining num in stack. There should only be one
       */
      //int[] stack1 = new int[arr.length()]; //not usabel because it'll have a fixed length
      ArrayList<Integer> stack1 = new ArrayList<>();
      int index;

      for(int num : arr) {
          index = stack1.indexOf(num);
          if(index == -1) {
              stack1.add(num);
          } else {
              stack1.remove(index);
          }
      }
      return stack1.get(0);
  }
}

/* Test Cases Passed: 
 * 1110 /1112
 * 
 * Your program took more time than expected.Expected Time Limit : 5.05sec
 */