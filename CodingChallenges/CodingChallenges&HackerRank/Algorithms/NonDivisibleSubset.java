/**
 * Given a set of distinct integers, print the size of a maximal subset of S
 * where the sum of any 2 numbers in S' is not evenly divisible by k.
 * • Input
 *  ♦ int S[n]: an array of integers
 *  ♦ int k: the divisor
 * • Return
 *  ♦ int: the length of the longest subset of S meeting the criteria
 * • Constraints
 *  ♦ 1<= n <=10^5
 *  ♦ 1<= k <=100
 *  ♦ 1<= S[i] <=10^9
 *  ♦ All of the given numbers are distinct.
 * • Example
 *  ♦ S=[19,10,12,10,24,25,22], k=4    //3
 * • TestCase
 *  ♦ S=[1,7,2,4], k=3    //3
 *  ♦ S=[278,576,496,727,410,124,338,149,209,702,282,718,771,575,436], k=7    //11
 */
/*
 * Pseudocode
 * ○ variables: int maxS = Imin, int currentS = 0, (no need to save each array)
 * ○ Loop i over S
 *   ◙ reset currentS
 *   ◙ Loop j over S.size+1   //lopp over subarray without S[i]
 *     ◘ if (S[i] + S[j]) % k == 0 then currentS += 1
 *   ◙ maxS = Math.max(maxS, currentS)
 * ○ return maxS
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonDivisibleSubset {

  public static void main(String[] args) {
    System.out.println(nonDivisibleSubset(4, Arrays.asList(19,10,12,10,24,25,22))); //3
    System.out.println(nonDivisibleSubset(3, Arrays.asList(1,7,2,4))); //3
    System.out.println(nonDivisibleSubset(7, Arrays.asList(278,576,496,727,410,124,338,149,209,702,282,718,771,575,436))); //11
  }//end main

  public static int nonDivisibleSubset(int k, List<Integer> s) {
    int maxS = Integer.MIN_VALUE;
    int currentS = 0;
    List<Integer> resizedS;

    for (int i=0; i<s.size(); i++) {
      /* subList() returns an AbstractList$SubList (a view) */
      resizedS = new ArrayList<>(s.subList(0, i));
      /* System.out.println("Before 2nd loop");
      System.out.println("s.subList(i+1, s.size()): " + s.subList(i+1, s.size())); */
      resizedS.addAll(s.subList(i+1, s.size()));
      currentS = 0;
      for (int j = 0; j < resizedS.size(); j++) {
        if((s.get(i) + resizedS.get(j)) % k == 0) currentS += 1; 
      }
      maxS = Math.max(maxS, currentS);
    }

    return maxS;
  }//end nonDivisibleSubset

}
