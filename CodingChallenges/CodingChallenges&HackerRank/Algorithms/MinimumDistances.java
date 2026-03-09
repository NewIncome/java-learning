/*
   Pseudocode
   ○ Need to: 
    ◙ save each element's position (HashMap<key(num), index>)
    ◙ loop through arr
    ◙ then, check: if repeated, add different distance
       if(i - hashMap.index) is lower than minDistance to compare each time, reassing minDistance
       and reassign hashMap.index each time
 */

import java.util.HashMap;
import java.util.List;

public class MinimumDistances {

  public static void main(String[] args) {
  }

  public static int minimumDistances(List<Integer> a) {
    HashMap<Integer, Integer> repeatedValues = new HashMap<>();  //<value, index>
    int val, minDistance = Integer.MAX_VALUE;

    for (int i = 0; i < a.size(); i++) {
      val = a.get(i);
      if(repeatedValues.containsKey(val)) {  //if it contains it, check for minVal
        minDistance = Math.min((i - repeatedValues.get(val)), minDistance);
      }
      repeatedValues.put(val, i);
    }

    return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
  }

}
