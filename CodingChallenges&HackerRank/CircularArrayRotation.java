/**
 * John Watson knows of an operation called a right circular rotation on an array
 * of integers. One rotation operation moves the last array element to the first
 * position and shifts all remaining elements right one. To test Sherlock's abilities,
 * Watson provides Sherlock with an array of integers. Sherlock is to perform the
 * rotation operation a number of times then determine the value of the element at a
 * given position.
 * For each array, perform a number of right circular rotations and return the values
 * of the elements at the given indices.
 * 
 * • Return
 *  ♦ int[q]: the values in the rotated a as requested in m
 * 
 * • Example: 
 *  ♦ a = [3,4,5], k = 2, queries = [1,2]   //[5,3]
 * 
 * • Constraints
 *  ♦ 1 <= n <= 10^5       <- number of elements
 *  ♦ 1 <= a[i] <= 10^5    
 *  ♦ 1 <= k <= 10^5       <- number of shifts
 *  ♦ 1 <= q <= 500        <- queries
 *  ♦ 0 <= queries[i] < n
 * 
 * • TestCase
 *  ♦ a = [1,2,3], k = 2, queries = [0,1,2]    //
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularArrayRotation {

  public static void main(String[] args) {
    System.out.println(result(Arrays.asList(3,4,5), 2, Arrays.asList(1,2)));
    System.out.println();
    System.out.println(result(Arrays.asList(1,2,3), 2, Arrays.asList(0,1,2)));
  }//end main

  public static List<Integer> result(List<Integer> a,
  int k, List<Integer> queries) {

    List<Integer> qArr = new ArrayList<>();
    int last;
    
    //shift array
    for (int i = 0; i < k; i++) {
      last = a.get(a.size()-1);   //a.getLast(); isn't available in Java 15
      //shift positions 1-last
      for (int j = a.size() - 1; j > 0; j--) {
        a.set(j, a.get(j-1));
        System.out.println("i: " + i + ", j: " + j + ", a: " + a);
      }
      //shift last to 1st(0)
      a.set(0, last);
    }

    System.out.println("a-shifted: " + a);

    //set queriesArray
    for (int i = 0; i < queries.size(); i++) {
      System.out.println("i: " + i + ", qArr: " + qArr);
      qArr.add(a.get(queries.get(i)));
    }

    return qArr;

  }//end result

}
