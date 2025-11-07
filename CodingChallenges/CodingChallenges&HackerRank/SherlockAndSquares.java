/**
 * Watson likes to challenge Sherlock's math ability. He will provide a
 * starting and ending value that describe a range of integers, inclusive
 * of the endpoints. Sherlock must determine the number of square integers
 * within that range.
 * Note: A square integer is an integer which is the square of an integer,
 * e.g. 1,4,9,16,25.
 * • Input
 *  ♦ int a: the lower range boundary
 *  ♦ int b: the upper range boundary
 * • Return
 *  ♦ int: the number of square integers in the range
 * • Constraints
 *  ♦ 1<= q <=100
 *  ♦ 1<= a <= b <=10^9
 * • Example
 *  ♦ a=24, b=49   //3
 *  There are three square integers in the range: 25,36 and 49. Return 3.
 *
 * • TestCases
 *  ♦ a=3, b=9   //3
 *  ♦ a=17, b=24   //3
 *  ♦ a=62, b=999999982   //31613
 */
/*
 * Pseudocode
 * ○ Make vars: int[] to store the squareValues; a var for the Sqrt value
 * ○ Loop from a to b
 *  + if 
 * ○ 
 */
import java.util.ArrayList;

public class SherlockAndSquares {
  public static void main(String[] args) {
    
  }

  public static int solution2(int a, int b) {
    int ceilNum = (int) Math.ceil(Math.sqrt(a));
    int floorNum = (int) Math.floor(Math.sqrt(b));
    return floorNum - ceilNum + 1;
  }

  public static int squares(int a, int b) { //too time consumming
    ArrayList<Integer> sqrs = new ArrayList<>();
    for (int i = a; i <= b; i++) {
      double sqr = Math.sqrt(i);
      if(sqr == (int) sqr) sqrs.add(i);
    }
    return sqrs.size();
  }

}

/*
 * Input
 * 100
59 999999922
9 999999966
12 999999988
68 999999975
19 999999910
78 999999987
11 999999995
13 999999942
1 999999930
57 999999908
35 999999927
87 999999973
8 999999903
53 999999915
17 999999990
34 999999935
7 999999952
24 999999953
62 999999982{-truncated-}
 *
 * Output
 * 31615
31620
31619
31614
31618
31614
31619
31619
31622
31615
31617
31613
31620
31615
31618
31617
31620
31618
31615
31613{-truncated-}
 */