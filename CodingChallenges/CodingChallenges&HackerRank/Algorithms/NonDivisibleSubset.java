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
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class NonDivisibleSubset {

  public static void main(String[] args) {
    //System.out.println(nonDivisibleSubset2(4, Arrays.asList(19,10,12,10,24,25,22))); //3
    //System.out.println(nonDivisibleSubset2(3, Arrays.asList(1,7,2,4))); //3
    System.out.println(nonDivisibleSubset2(7, Arrays.asList(278,576,496,727,410,124,338,149,209,702,282,718,771,575,436))); //11
  }//end main

  /* This approach is with the premise that if the sum of n numbers is divisible by k,
   * then the sum of their remainders will also be divisible by k.
   * And viceversa for non-divisible.
   */
  public static int nonDivisibleSubset2(int k, List<Integer> s) {
    int maxnum = 0;
    HashMap<Integer, Integer> remainder = new HashMap<>();

    //create the HashMap with the s[i]%k as keys and count as values
    s.stream().forEach(e -> remainder.put(e%k, remainder.getOrDefault(e%k, 0) + 1));
    System.out.println("remainder: " + remainder);

    /* EdgeCase#1: when there are more than 1 elements that got 0 in % op.
     * That are divisible by k. If there are more than one, add only 1 */
    maxnum += Math.min(remainder.getOrDefault(0, 0), 1);
    /* EdgeCase#2: in case k is pair, then we can only select 1 element
     * with that remainder, because it will be half of k. And with 2 it will already be
     * divisible be k.
     */
    if (k%2 == 0) maxnum += Math.min(remainder.get(k/2), 1);

    /* We start from 1 because we already took care of rem 0,
     * and we traverse to half of the array because ...
     */
    for (int i = 1; i <= k/2; i++) {
      //We only add either of those remainder-indexes, because we cannot have 2
      System.out.println("i: " + i + ", k-i: " + (k-i));
      if(i != (k-i)) maxnum += Math.max(remainder.getOrDefault(i, 0), remainder.getOrDefault(k-i, 0));
    }

    return maxnum;
  }//end nonDivisibleSubset2

  public static int nonDivisibleSubset(int k, List<Integer> s) {
    int maxS = Integer.MIN_VALUE;
    int currentS = 0;
    List<Integer> resizedS;

    for (int i=0; i<s.size(); i++) {
      /* subList() returns an AbstractList$SubList (a view) */
      System.out.print(s.get(i) % k);
      /* resizedS = new ArrayList<>(s.subList(0, i));
      //System.out.println("Before 2nd loop");
      //System.out.println("s.subList(i+1, s.size()): " + s.subList(i+1, s.size()));
      resizedS.addAll(s.subList(i+1, s.size()));
      currentS = 0;
      for (int j = 0; j < resizedS.size(); j++) {
        if((s.get(i) + resizedS.get(j)) % k == 0) currentS += 1; 
      }
      maxS = Math.max(maxS, currentS); */
    }

    return maxS;
  }//end nonDivisibleSubset

}
