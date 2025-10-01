/**
 * Given an array of bird sightings where every element represents a bird
 * type id, determine the id of the most frequently sighted type.
 * If more than 1 type has been spotted that maximum amount, return the
 * smallest of their ids.
 * 
 * • Example:
 * arr = [1,1,2,2,3]; n=5   // type 1 //is the lowest of the 2 most spotted
 * 
 * • Needs:
 *  ♦ determine the id of the most spotted bird
 *  ♦ if there are >1 most spotted, pick the lowest
 * 
 * • Constraints
 *  ♦ 2 <= n <= 5 x 10^5
 *  ♦ It is guaranteed that each type is 1, 2, 3, 4, or 5.
 * 
 * • Test Cases ()
 *  ♦ arr=[1,4,4,4,5,3]  // 4
 *  ♦ arr=[1,2,3,4,5,4,3,2,1,3,4]  // 3
 * 
 */
/*
 * Pseudo-code
 * Opt1:
 * ○ variables: a set, and a map
 * ○ create a set var with the single arr values
 * Opt2:
 * ○ variables: a map, int
 * ○ create a map var, and int max
 * ○ loop through each element in the arr
 *  ○ if exists as key in the map do it's value +1
 *  ○ assign that modified value to max
 *  ○ else add it with a value of 1
 * ○ filter-return the keys of the values that are equals to max
 * //(15min in pseudocode)
 * Opt3:
 * ○ saving the value in an array of same s
 * ○ create an array of the size of arr
 * ○ and fill it be adding +1 to each index depending on the value to count
 *   [1, 2, 3, 4, 5] those will be the positions where to add a valueCount
 * ○* will use size 6 to not have to substract 1 for index 0
 * Btcya:
 * ○ using Collections.frequency (Java +8)
 */
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MigratoryBirds {
  public static void main(String[] args) {
    List<Integer> arr1 = List.of(1,1,2,2,3);  //For an Immutable List (Java 9+)
    List<Integer> arr2 = Arrays.asList(1,4,4,4,5,3);
    List<Integer> arr3 = Arrays.asList(1,2,3,4,5,4,3,2,1,3,4);

    System.out.println(resultOpt3(arr1) + "\n");
    System.out.println(resultOpt3(arr2) + "\n");
    System.out.println(resultOpt3(arr3));
    //(setup 5min)
  }//end main

  public static int resultOpt2(List<Integer> arr) {
    //declare variables
    Map<Integer, Integer> mapValues = new HashMap<>();
    int max;

    //loop arr to fill map
    for(int i : arr) {
      if(mapValues.containsKey(i)) {
        mapValues.put(i, 1);
      } else {
        mapValues.put(i, mapValues.get(i) + 1);
        max = mapValues.get(i);
      }
    }

    /* return mapValues.entrySet()
                      .stream()
                      .filter(e -> e.getValue() == max);
                      .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)); */
    return 0;
  }//end result

  //Solution by TKGgames youtube channel
  public static int resultOpt3(List<Integer> arr) {
    int max = 0;
    int[] countArray = new int[6]; //for ease of use, index 0 won't be used

    for(int val : arr) {
      countArray[val]++;
      max = Math.max(max, countArray[val]);
    }
    for(int i = 0; i < countArray.length; i++) {
      /* this will return the lowest repeatedValue that's equal to max
      thanks to this index-value method */
      if(countArray[i] == max) return i;
    }

    //will never reach here
    return 0;
  }//end resultOpt3

  //BeyondTheCode youtube channel Approach  ¡Amazing approach!
  public static int resultBtcya(List<Integer> arr) {
    int bird = 1;
    for (int i = 2; i <= 5; i++) {
      if (Collections.frequency(arr, i) > Collections.frequency(arr, bird)) {
        bird = i;
      }
    }

    return bird;
  }//end resultBtcya
}
