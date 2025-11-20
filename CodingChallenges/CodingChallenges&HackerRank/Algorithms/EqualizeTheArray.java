/**
 * Given an array of integers, determine the minimum number of elements
 * to delete to leave only elements of equal value.
 * • Input
 *  ♦ int arr[n]: an array of integers
 * • Returns
 *  ♦ int: the minimum number of deletions required
 * • Constraints
 *  ♦ 1 <= n <= 100
 *  ♦ 1 <= a[i] <= 100
 * • Example
 *  ♦ arr=[1,2,2,3]    //2
 * • TestCases
 *  ♦ arr=[3,3,2,1,3]    //2
 */
/*
 * Pseudocode
 * //Not taking into account EdgeCase with more than 1 most repeated val
 * +Opt1: set of arrValues and count reps of each value
 * ○ vars: HashMap of arrValueReps, int maxRepsKey, maxRepsCount
 * ○ get the max value of reps
 * 
 * ○ loop and remove the rest that are not maxRepsKey
 * 
 * ○ OR, return arr.size() - maxRepsCount
 * 
 * ○ OR, create a set, them check the max freq with Collections.frequency
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class EqualizeTheArray {

  public static void main(String[] args) {
    System.out.println(equalizeArray(List.of(1,2,2,3)));
    System.out.println(equalizeArray(List.of(3,3,2,1,3)));
  }//end main

  public static int equalizeArray(List<Integer> arr) {
    HashMap<Integer, Integer> reps = new HashMap<>();
    int maxRepsKey, maxRepsCount;

    //count reps of each value
    arr.stream().forEach(e -> reps.put(e, reps.getOrDefault(e, 0) + 1));

    //assign values of max
    maxRepsCount = Collections.max(reps.values());
    //maxRepsKey = Collections.max(reps.keySet());

    return arr.size() - maxRepsCount;
  }//end equalizeArray
  
}
