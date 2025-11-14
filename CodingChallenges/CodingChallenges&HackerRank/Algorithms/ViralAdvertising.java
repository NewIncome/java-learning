/**
 * HackerLand Enterprise is adopting a new viral advertising strategy. When they launch
 * a new product, they advertise it to exactly 5 people on social media.
 * On the first day, half of those 5 people (i.e., floor(5/2)=2) like the advertisement
 * and each shares it with 3 of their friends. At the beginning of the second day,
 * floor(5/2)x3 = 2x3 = 6 people receive the advertisement.
 * Each day, floor(recipients/2) of the recipients like the advertisement and will share
 * it with 3 friends on the following day. Assuming nobody receives the advertisement
 * twice, determine how many people have liked the ad by the end of a given day, beginning
 * with launch day as day 1.
 * 
 * • Example
 * n = 5    //24
 *  Day Shared Liked Cumulative
 *  1      5     2       2
 *  2      6     3       5
 *  3      9     4       9
 *  4     12     6      15
 *  5     18     9      24
 * 
 * • Returns
 *  ♦ int: the cumulative likes at that day
 * 
 * • Constraints
 *  ♦ 1 <= n <= 50
 * 
 * • TestCases
 *  ♦ n = 3    //9
 */
/*
 * Pseudocode
 * ○ declare and init var int shared = 5, likes = 5/2
 * ○ loop from 2 to n
 *  + likes += shared/2
 *  + shared = ((shared/2) * 3)
 * ○ return likes
 */
public class ViralAdvertising {
  public static void main(String[] args) {
    System.out.println(result(5));
    System.out.println(result(3));
  }//end main

  public static int result(int n) {
    int shared = 5, likes = 5/2;

    for(int i = 2; i <= n; i++) {
      shared = ((shared/2) * 3);
      likes += shared / 2;
      System.out.println("i: " + i + ", shared: " + shared + ", likes: " + likes);
    }

    return likes;
  }//end result
}