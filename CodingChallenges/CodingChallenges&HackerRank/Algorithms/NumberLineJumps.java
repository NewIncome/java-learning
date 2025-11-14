/**
 * Number Line Jumps
 * 
 * You are choreographing a circus show with various animals. For one 
 * act, you are given two kangaroos on a number line ready to jump in 
 * the positive direction (i.e, toward positive infinity).
 * The first kangaroo starts at location  and moves at a rate of  
 * meters per jump.
 *  The second kangaroo starts at location  and moves at a rate of  
 * meters per jump.
 * You have to figure out a way to get both kangaroos at the same 
 * location at the same time as part of the show. If it is possible, 
 * return YES, otherwise return NO.
 *
 * • The function accepts following parameters:
 *  1. x1 - position of Kangaroo 1
 *  1. v1 - jumps of Kangaroo 1
 *  1. x2 - position of Kangaroo 2
 *  1. v2 - jumps of Kangaroo 2
 * 
 * • Constraints
 *  ♦ 0 <= x1 < x2 <= 10000
 *  ♦ 1 <= v1 <= 10000
 *  ♦ 1 <= v2 <= 10000
 * 
 * • Test Cases ()
 *  + 2 1 1 2  // YES
 *  + 0 3 4 2  // YES
 *  + 0 2 5 3  // NO
 */
class Result {
  public static String NumberLineJumps(int x1, int v1, int x2, int v2) {
    /* Logical Steps / PseudoCode
     * Option1:
     * Loop both until they meet, and stop before 100 jumps
     * 
     * Option2:
     * Mathematical approach ...
     */
    //Variables
    int kangoo1 = x1;
    int kangoo2 = x2;

    for(int i = 0; i<= 10000; i++) {
      kangoo1 += v1;
      kangoo2 += v2;
      if(kangoo1 == kangoo2) return "YES";
    }

    return "NO";
  }
}

/* for loop
 * at   100, 5 TCs failed
 * at  1000, 2 TCs failed
 * at 10000, 0 TCs failed
*/

/* Mathematical approach #1
 * ------------------------
    if(v1>v2 and ((x2-x1)%(v1-v2)==0)):
        return("YES")
    else:
        return('NO')
 */
/* Mathematical approach #2
 * ------------------------
   if v1 > v2:
        jump_diff = v1 - v2
        position_diff = x2 - x1
        
        if position_diff % jump_diff == 0:
            return "YES"
        return "NO"
    
    
    return "NO"
 */
