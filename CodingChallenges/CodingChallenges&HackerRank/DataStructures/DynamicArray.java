/**
 * Declare a 2-dimensional array, arr, with n empty arrays, all zero-indexed.
 * Declare an integer, lastAnswer, and initialize it to 0.
 * You need to process two types of queries:
 * 1. Query: 1xy
 *  ○ Compute idx = (x ⊕ lastAnswer) //***Description Wrong, should be idx = ((x ⊕ lastAnswer) % n)
 *  ○ Append the integer y to arr[idx]
 * 2. Query: 2xy
 *  ○ Compute idx = (x ⊕ lastAnswer)
 *  ○ Set lastAnswer = arr[idx][y%size(arr[idx])]
 *  ○ Store the new value of lastAnswer in an answers array
 * Store the new value of  in an answers array.
 * ⊕
 * • Input
 *  ♦ int n: the number of empty arrays to initialize in arr
 *  ♦ int queries[q][3]: 2-D array of integers
 * • Return
 *  ♦ int[]: the results of each type 2 query in the order they are presented
 * • Constraints
 *  ♦ 1<= n,q <=10^5
 *  ♦ 0<= x,y <=10^9
 *  ♦ It is guaranteed that query type 2 will never query an empty array or index.
 * • Notes:
 *  - ⊕ is the bitwise XOR operation, which corresponds to the ^ operator in most languages.
 *  - % is the modulo operator.
 *  - Finally, size(arr[idx]) is the number of elements in arr[idx].
 * • TestCases
 *  ♦ size of arr[] n = 2, queries = [[1,0,5],[1,1,7],[1,0,3],[2,1,0],[2,1,1]]   //[7,3]
 */
/*
 * Pseudocode
 * ○ Assume: queries[i][0] will always be 1 or 2
 * ○ vars: int idx = 0, int lastAnswer=0, int[] answersArr, int[][] arr2D = new int[n][];
 * ○ Loop through queries[] //through outer arrays only
 *   ◙ if(queries[i][0] == 1) do query 1xy
 *      idx = (x ⊕ lastAnswer)
 *      arr[idx] = y
 *   ◙ else do query 2xy
 *      idx = (x ⊕ lastAnswer)
 *      lastAnswer = arr[idx][y%size(arr[idx])]
 *      answersArr.push(lastAnswer)
 * ○ return answersArr
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DynamicArray {

  public static void main(String[] args) {
    System.out.println(dynamicArray(2, List.of(
                                                List.of(1, 0, 5),
                                                List.of(1, 1, 7),
                                                List.of(1, 0, 3),
                                                List.of(2, 1, 0),
                                                List.of(2, 1, 1)
                                                )
                                   )
    );  //[7,3]
  }//end main

  public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    int idx = 0, lastAnswer = 0, x=0, y=0;
    List<Integer> answersArr = new ArrayList<>();
    List<List<Integer>> arr2D = new ArrayList<>();
    
    //Dynamically populate the empty arr2D
    //for (int i = 0; i < n; i++) arr2D.add(new ArrayList<>());  //or with streams:
    arr2D = Stream.generate(ArrayList<Integer>::new).limit(n).collect(Collectors.toList());

    for(List<Integer> q : queries) {
      x = q.get(1);
      y = q.get(2);
      idx = ((x ^ lastAnswer) % n);
      System.out.println();
      System.out.println("idx: " + idx + ", [x,y]: " + "[" + x + "," + y + "]" +
                      ", lastAnswer: " + lastAnswer + ", arr2D.size: " + arr2D.size());
      if(q.get(0) == 1) {
        /* Compute idx = (x ⊕ lastAnswer) && Append the integer y to arr[idx] */
        arr2D.get(idx).add(y);
        //System.out.println("inIf, arr2D: " + arr2D);
      } else {
        /* Compute idx = (x ⊕ lastAnswer) && Set lastAnswer = arr[idx][y%size(arr[idx])] && Store the new value of lastAnswer in an answers array */
        lastAnswer = arr2D.get(idx).get(y % arr2D.get(idx).size());
        answersArr.add(lastAnswer);
        //System.out.println("inElse, arr2D: " + arr2D);
      }
    }

    return answersArr;
  }//end dynamicArray

}
