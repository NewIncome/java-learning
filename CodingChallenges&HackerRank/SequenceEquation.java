/**
 * Given a sequence of n integers, p(1),p(2),...,p(n) where each
 * element is distinct and satisfies 1<=p(x)<=n. For each x where
 * 1<=p(x)<=n, that is x increments from 1 to n, find any integer
 * y such that p(p(y)) === x and keep a history of the values of y
 * in a return array.
 * • Input
 *  ♦ int p[n]: an array of integers
 * • Returns
 *  ♦ int[n]: the values of y for all x in the arithmetic sequence 1 to n
 * • Example
 *  ♦ p = [5,2,1,3,4]  //[4,2,5,1,3]
 * • Constraints
 *  ♦ 1<= n <=50
 *  ♦ 1<=p[i]<=50 where 1<= i <=n
 *  ♦ Each element in the sequence is distinct
 * 
 * • TestCase
 *  ♦ p = [2,3,1]   //[2,3,1]
 *  ♦ p = [4,3,5,1,2]    //[1,3,5,4,2]
 * 
 * • Conclusion jic
 *  ♦ You have to find the index-position of 1,
 *    then the index-position of that prev-index-position-num,
 *    and that index-num is saved to the array to return
 */
/*
 * Pseudocode
 * ○ create an array to store the sequence, int x, y; for 1st & 2nd indexes
 * ○ loop from 1 to p.length
 *  + x = p.findIndexOf(i) + 1
 *  + y = p.findIndexOf(x) + 1
 *  + seq.push(y)
 * ○ return seq
 */
import java.util.ArrayList;
import java.util.List;

public class SequenceEquation {
  public static void main(String[] args) {
    System.out.println(permutationEquation(List.of(5,2,1,3,4)));
    System.out.println(permutationEquation(List.of(2,3,1)));
    System.out.println(permutationEquation(List.of(4,3,5,1,2)));
  }//end main

  public static List<Integer> permutationEquation(List<Integer> p) {
    int x, y;
    List <Integer> sequence = new ArrayList<>();

    for(int i=1; i<=p.size(); i++) {
      x = p.indexOf(i) + 1;
      y = p.indexOf(x) + 1;
      sequence.add(y);
    }

    return sequence;
  }//end permutationEquation
}
