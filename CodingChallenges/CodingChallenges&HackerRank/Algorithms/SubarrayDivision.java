import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Two children, Lily and Ron, want to share a chocolate bar.
 * Each of the squares has an integer on it.
 * Lily decides to share a -contiguous segment- of the bar selected such that:
 * • The length of the segment matches Ron's birth month, and,
 * • The sum of the integers on the squares is equal to his birth day.
 * Determine how many ways she can divide the chocolate.
 * 
 * • Example:
 * s = [2,2,1,3,2]; d = 4; m = 2   // 2 ; [2,2] and [1,3]
 * 
 * • Needs:
 *  ♦ find segments summing to Ron's birth day(d)
 *  ♦ with a length equalling his birth month(m)
 * 
 * • Constraints
 *  ♦ 0 <= x1 < x2 <= 10000
 *  ♦ 1 <= v1 <= 10000
 *  ♦ 1 <= v2 <= 10000
 * 
 * • Test Cases ()
 *  ♦ s=[1,1,1,1,1,1]; d=3, m=2  // 0
 *  ♦ s=[4]; d=4, m=1  // 1
 *  ♦ s=[1,2,1,3,2]; d=3; m=2  // 2
 */
/*
 * Pseudo-code (nestedLoop)
 * 0-  List<List<Integer>> dynamicMatrix = new ArrayList<>(); //to not use up memory, just sum
 * 1- Loop over the array
 * 2- L: check if sum current = i[i][j]+i[i][j+1] <= day && j <= m
 * 3- L: if 
 * 4- return 
 */
public class SubarrayDivision {
  public static void main(String[] args) {
    //T.C.1
    List<Integer> s1 = Arrays.asList(1,1,1,1,1,1);
    System.out.println(birthday(s1, 3, 2));
    System.out.println();

    //T.C.2
    List<Integer> s2 = Arrays.asList(1,2,1,3,2);
    System.out.println(birthday(s2, 3, 2));

  }//end main
  
  public static int birthday(List<Integer> s, int d, int m) {
    //ArrayList<List<Integer>> segments = new ArrayList<>(); //not used to avoid over-complication
    int segments = 0;
    int count = 0;
 
    if(s.size() == 1) return 1;

    for (int i = 0; i <= s.size()-1; i++) {
      count = s.get(i);
      for (int j = i; j <= s.size()-2; j++) {
        count += s.get(j+1);
        //System.out.println("i: " + i + ", j: " + j + ", count: " + count + ", (j-i+2): " + (j-i+2));
        if(count == d && (j-i+2) == m)
          segments++;

        if(count >= d || (j-i+2) >= m)
          break;
      }
    }

    return segments;
  }//end birthday
}
