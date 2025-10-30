/**
 * A jail has a number of prisoners and a number of treats to pass out
 * to them. Their jailer decides the fairest way to divide the treats is
 * to seat the prisoners around a circular table in sequentially numbered
 * chairs. A chair number will be drawn from a hat. Beginning with the
 * prisoner in that chair, one candy will be handed to each prisoner
 * sequentially around the table until all have been distributed.
 * The jailer is playing a little joke, though. The last piece of candy
 * looks like all the others, but it tastes awful. Determine the chair
 * number occupied by the prisoner who will receive that candy.
 * 
 * • Example
 *  ♦ n = 4, m = 6, s = 2    //3
 * There are 4 prisoners, 6 pieces of candy and distribution starts at
 * chair 2. The prisoners arrange themselves in seats numbered 1 to 4.
 * Prisoners receive candy at positions 2,3,4,1,2,3. The prisoner to be
 * warned sits in chair number 3.
 * 
 * • Parameters
 *  ♦ int n: the number of prisoners
 *  ♦ int m: the number of sweets
 *  ♦ int s: the chair number to begin passing out sweets from
 * 
 * • Returns
 *  ♦ int: the chair number of the prisoner to warn
 * 
 * • Constraints
 *  ♦ 1 <= t <= 100
 *  ♦ 1 <= n <= 10^9
 *  ♦ 1 <= m <= 10^9
 *  ♦ 1 <= s <= n
 * 
 * • TestCases
 *  ♦ n = 5, m = 2, s = 1    //2
 *  ♦ n = 5, m = 2, s = 2    //3
 *  ♦ n = 7, m = 19, s = 2    //6
 *  ♦ n = 7, m = 3, s = 3    //3
 */
/*
 * Pseudocode
 *  Opt1
 * ○ declare var int chair = s
 * ○ loop from 0 < m(#candies)
 *  + if chair == n do chair = 1
 *  + else chair = chair + 1
 *           //+ chair = chair == n ? 1 : chair + 1;
 * ○ return chair
 */
public class SaveThePrisoner {
  public static void main(String[] args) {
    System.out.println(result02(4,6,2));  //3
    System.out.println(result02(5,2,1));  //2
    System.out.println(result02(5,2,2));  //3
    System.out.println(result02(7,19,2)); //6
    System.out.println(result02(3,7,3));  //3
  }//end main

  public static int result01(int n, int m, int s) {
    int chair = s;

    for (int i = 1; i < m; i++) {
      chair = chair == n ? 1 : chair + 1;
      //System.out.println("i: " + i + ", chair: " + chair);
    }

    return chair;
  }//end result01

  //video. Approach account the Offset
  public static int result02(int n, int m, int s) {
    int chair;

    //if chair is 1, then there's no offset
    if(s == 1) {
      chair = m % n;
      return chair == 0 ? n : chair;
    }

    // 3,7,3
    /* -1 to define the base-case-Shift
       s=3, 3-1 = 2; we'll be 2 chairs away from the position we want(chair 1) */
    /* Whatever we MOD(%) will give us our chair. If s>1 we'll have to account the offset.
     * shift  + candy   = # % prisoners  0means3 else that's the chair num
     * 3-1 = 2 + 7   =    9 % 3     =    0
     */
    chair = (m + s - 1) % n;

    //oneLiner for 1orOffset:  chair = s == 1 ? m % n : (m + s - 1) % n;
    return chair == 0 ? n : chair; 
  }//result02
}
