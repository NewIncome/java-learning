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
import java.util.ArrayList;
import java.util.List;


public class OrganizingContainersOfBalls {

  public static void main(String[] args) {
    System.out.println(organizingContainers(List.of( List.of(1,4), List.of(2,3) )));  //Impossible
    System.out.println(organizingContainers(List.of( List.of(1,1), List.of(1,1) )));  //Possible
    System.out.println(organizingContainers(List.of( List.of(0,2), List.of(1,1) )));  //Impossible
    System.out.println(organizingContainers(List.of( List.of(1,3,1), List.of(2,1,2), List.of(3,3,3) )));  //Impossible
    System.out.println(organizingContainers(List.of( List.of(0,2,1), List.of(1,1,1), List.of(2,0,0) )));  //Possible
  }

  public static String organizingContainers(List<List<Integer>> container) {
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