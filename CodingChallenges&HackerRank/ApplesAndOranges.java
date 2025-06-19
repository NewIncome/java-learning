/**
 * Complete the 'countApplesAndOranges' function below.
 * 
 * When a fruit falls from its tree, it lands  units of 
 * distance from its tree of origin along the -axis. *A 
 * negative value of  means the fruit fell  units to the 
 * tree's left, and a positive value of  means it falls  
 * units to the tree's right.
 * • Given the value of  for  apples and  oranges, determine 
 * how many apples and oranges will fall on Sam's house (i.
 * e., in the inclusive range )?
 * • Print 2 integers on 2 different lines
 *
 * • The function accepts following parameters:
 *  1. INTEGER s  #Starting point of Sam´s house
 *  2. INTEGER t  #Ending point of Sam´s house
 *  3. INTEGER a  #Apple tree position-point
 *  4. INTEGER b  #Orange tree position-point
 *  5. INTEGER_ARRAY apples
 *  6. INTEGER_ARRAY oranges
 * 
 * • Test Cases (s, t, a, b, ap[], or[])
 * + 7 11 5 15 [-2 2 1] [5 -6]
 */
import java.util.List;

class Result {
  public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
    /* Logical Steps / PseudoCode
     * + Need 2 variables: int applesIn = 0, orangesIn = 0
     * + to fill the applesIn and orangesIn arrays loop over apples & oranges arr
     *   + add values to arr if
     *    treePos(a) + fruitPos(apples(i)) IS >= s && <= t
     * + print applesIn and print orangesIn
     */
     //Print apples count
     //System.out.println(countFruit(s, t, a, apples));
     System.out.println(countFruit(s, t, a, apples));

     //Print oranges count
     //System.out.println(countFruit(s, t, a, oranges));
     System.out.println(countFruit(s, t, b, oranges));
  }

  public static int countFruit(int s, int t, int tree, List<Integer> fruits) {
    int fruitsIn = 0;
    int fruitPos;

    for(int fruit : fruits) {
      fruitPos = tree + fruit;
      if(fruitPos >= s && fruitPos <= t)
        fruitsIn++;
    }

    return fruitsIn;
  }
}
