/**
 * David has several containers, each with a number of balls in it. He has just
 * enough containers to sort each type of ball he has into its own container.
 * David wants to sort the balls using his sort method.
 * David wants to perform some number of swap operations such that:
 * - Each container contains only balls of the same type.
 * - No two balls of the same type are located in different containers.
 * 
 * • Input
 *  ♦ int containter[n][m]: a two dimensional array of integers that represent the number of balls of each color in each container
 * • Return
 *  ♦ string: either Possible or Impossible
 * • Constraints
 *  ♦ 1 <= q <= 10
 *  ♦ 1 <= n <= 100
 *  ♦ 0 <= containers[i][j] <= 10^9
 * • Example
 *  ♦ container = [[1,4], [2,3]]  //Impossible
 * • TestCases
 *  ♦ container = [[1,1], [1,1]]  //Possible
 *  ♦ container = [[0,2], [1,1]]  //Impossible
 *  ♦ container = [[1,3,1], [2,1,2], [3,3,3]]  //Impossible
 *  ♦ container = [[0,2,1], [1,1,1], [2,0,0]]  //Possible
 */
/*
 * Pseudocode:
 * 
 * For the WholeOperation to be Possible we need:
 * ♦ Vars:  int ballTypes, notCorrespond, current; 
 * ♦ in a 2x2 matrix:  that both containers have the same number of not corresponding balls
 *  ♦ for container[0] we check the index cont[0][i]
 * ♦ So: we need a nested loop
 *  ♦ 2ndLoop from 0 to container.size() = ballTypes int
 *    ♦ if(j == i) continue;  to not count the balls that are in place
 *    ♦ in a current var save the value of each non corresponding balls per container
 *      current += container[i][j]
 *  ♦ Compare the current value of non-corresponding balls with the next 
 *      if(i!=0)
 *        if(notCorrespond != current) return "Impossible"
 *  ♦ Save the value of current to notCorrespond, And reset current
 *  ♦ return "Possible" 
 * 
 * ...
 * Totals matter.
 * How many of it's corresponding balls are in other containers
 * And, how many of ball does it have that don't belong?
 * 
 * ...  solution intent #2
 * TotalBalls == TotalContainers + TotalBallsNotInPlace
 *         10     >       2      +   6    (=  8)      //-example (X)
 *     *    4    ==       2      +   2    (=  4)      //-TC1  (✔)
 *          4     <       2      +   3    (=  5)      //-TC2  (X)
 *         19     >       3      +  14    (= 17)      //-TC3  (X)
 *     *    8     <       3      +   7    (= 10)      //-TC4  (✔)
 */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OrganizingContainersOfBalls {

  public static void main(String[] args) {
    //double startTimeMillis = System.currentTimeMillis();
    double startTimeNano = System.nanoTime();


    System.out.println(organizingContainers(List.of( List.of(1,4), List.of(2,3) )));  //Impossible
    System.out.println(organizingContainers(List.of( List.of(1,1), List.of(1,1) )));  //Possible
    System.out.println(organizingContainers(List.of( List.of(0,2), List.of(1,1) )));  //Impossible
    System.out.println(organizingContainers(List.of( List.of(1,3,1), List.of(2,1,2), List.of(3,3,3) )));  //Impossible
    System.out.println(organizingContainers(List.of( List.of(0,2,1), List.of(1,1,1), List.of(2,0,0) )));  //Possible


    //double endTimeMillis = System.currentTimeMillis();
    double endTimeNano = System.nanoTime();
    //double totalMillis = endTimeMillis - startTimeMillis;
    double totalNano = endTimeNano - startTimeNano;
    //System.err.printf("Total time elapsed: %.2f milliS :: %.4f seconds%n", totalMillis, (totalMillis/1_000));
    System.err.printf("Total time elapsed: %.2f nanoS :: %.3f seconds.", totalNano, (totalNano/1_000_000_000));
    System.err.println(" Mustn't be greater than 2 seconds");
  }


  /* My issue was thinking each container had to be fixed with a ballType,
   * as if the containers also had types.
   * Basically,
   *  - there are ballTypes
   *  - there are container sizes
   * And, we just have to see if we can match containerSizes vs/per ballTypeCount
   * Therefore, sorting is best used here
   * 
   *  >=>-> *** So MUST ASSUME, containers are not fixed with/for a specific ballType !!! <-<=<
   */
  public static String organizingContainers(List<List<Integer>> container) {
      int n = container.size();
      int balls;

      long[] containerSums = new long[n];
      long[] typeSums = new long[n];

      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              balls = container.get(i).get(j);
              containerSums[i] += balls;  // row sum
              typeSums[j] += balls;       // column sum
          }
      }

      Arrays.sort(containerSums);
      Arrays.sort(typeSums);

      return Arrays.equals(containerSums, typeSums)
              ? "Possible"
              : "Impossible";
  }


  public static String organizingContainers03(List<List<Integer>> container) {
    int n = container.size();
    BigInteger contCapacity = BigInteger.ZERO;
    BigInteger ballTypeCount = BigInteger.ZERO;

    for (int i = 0; i < n; i++) {
      contCapacity = BigInteger.valueOf(container.get(i).stream().reduce((a,b)->a+b).orElse(0));

      for (int j = 0; j < n; j++) {
        //System.out.println("j: " + j + ", BigInteger.valueOf(container.get(j).get(i)): " + BigInteger.valueOf(container.get(j).get(i)) + ", ballTypeCount: " + ballTypeCount);
        ballTypeCount = ballTypeCount.add(BigInteger.valueOf(container.get(j).get(i)));
      }

      //System.out.println("i: " + i + ", containerCount: " + contCapacity + ", ballTypeCount: " + ballTypeCount);
      if(contCapacity.compareTo(ballTypeCount) != 0) return "Impossible";
      ballTypeCount = BigInteger.ZERO;
      contCapacity = BigInteger.ZERO;
    }

    return "Possible";
  }

  public static String organizingContainers02(List<List<Integer>> container) {
    //int val;
    int n = container.size();
    long[] contCapacity = new long[n];
    long[] ballTypeCount = new long[n];

    //fill sums of: row & col, contCapacity & ballTypeCount
    /* for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        val = container.get(i).get(j);
        contCapacity[i] += val;
        ballTypeCount[j] += val;
      }
    } */
    for (int i = 0; i < n; i++) {
      contCapacity[i] = container.get(i).stream().reduce((a,b)->a+b).orElse(0);
      //contCapacity[i] = container.get(i).stream().mapToInt(Integer::intValue).sum();
      for (int j = 0; j < n; j++) {
        ballTypeCount[i] += container.get(j).get(i);
      }
      //System.out.println("i: " + i + ", containerCount: " + contCapacity[i] + ", ballTypeCount: " + ballTypeCount[i]);
      if(contCapacity[i] != ballTypeCount[i]) return "Impossible";
    }

    //compare
    /* for (int i = 0; i < n; i++) {
      if(contCapacity[i] != ballTypeCount[i]) return "Impossible";
    } */

    //can i make a loop that sums and compares row by col?

    return "Possible";
  }
  /* if done the sum separately:
    • add the Rows
       List<Integer> rowSums = matrix.stream()
          .map(row -> row.stream().mapToInt(Integer::intValue).sum())
          .toList();
    • add the Cols
       List<Integer> colSums = IntStream.range(0, numCols)
          .mapToObj(colIdx -> matrix.stream()
              .mapToInt(row -> row.get(colIdx))
              .sum())
          .toList();
   */


  public static String organizingContainers01(List<List<Integer>> container) {
    // I need to get:  TotalBalls, TotalBallsNotInPlace, TotalContainers
    int totalBalls = 0;
    int totalBallsNotInPlace = 0;
    int totalContainers = container.size();

    for (int i = 0; i < totalContainers; i++) {
      for (int j = 0; j < totalContainers; j++) {
        if(j != i) totalBallsNotInPlace += container.get(i).get(j);
        totalBalls += container.get(i).get(j);
        //System.out.println("i: " + i + ", j: " + j + ", totalBalls: " + totalBalls + ", totalContainers: " + totalContainers + ", totalBallsNotInPlace: " + totalBallsNotInPlace);
      }
    }
    
    //System.out.println("totalBalls: " + totalBalls + ", totalContainers: " + totalContainers + ", totalBallsNotInPlace: " + totalBallsNotInPlace);
    //return totalBalls == (totalContainers + totalBallsNotInPlace) ? "Possible" : "Impossible";
    if(isPair(totalBalls) && isPair((totalContainers + totalBallsNotInPlace)) && totalBalls <= (totalContainers + totalBallsNotInPlace)) {
      return "Possible";
    } else return "Impossible";
  }

  public static boolean isPair(int a) { return a % 2 == 0 ? true : false; }


  public static String organizingContainers0(List<List<Integer>> container) {
    int current = 0;
    int notCorrespond = 0;
    int ballTypes = container.size();

    System.out.println("ballTypes: " + ballTypes);
    for (int i = 0; i < ballTypes; i++) {
      for (int j = 0; j < ballTypes; j++) {
        if(j == i) continue;
        current += container.get(i).get(j);
        //System.out.println("i: " + i + ", j: " + j + ", notCorrespond: " + notCorrespond + ", current: " + current);
      }
      if(i!=0) {
        if(notCorrespond != current) return "Impossible";
      }
      notCorrespond = current;
      current = 0;
    }

    return "Possible";
  }

}

/* Expected output for TestCase06 file

Possible
Impossible
Impossible
Possible
Impossible
Possible
Possible
Possible
Possible
Possible
*/