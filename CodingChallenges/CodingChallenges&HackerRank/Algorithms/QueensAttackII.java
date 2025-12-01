/**
 * You will be given a square chess board with one queen and a number of
 * obstacles placed on it. Determine how many squares the queen can attack.
 * A queen is standing on an nxn chessboard. The chess board's rows are
 * numbered from 1 to n, going from bottom to top. Its columns are numbered
 * from 1 to n, going from left to right. Each square is referenced by a tuple,
 * (r,c), describing the row, r, and column, c, where the square is located.
 * The queen is standing at position (rq,cq). In a single move, she can attack
 * any square in any of the eight directions (left, right, up, down, and the
 * four diagonals). In the diagram below, the green circles denote all the
 * cells the queen can attack from.
 * Given the queen's position and the locations of all the obstacles, find and
 * print the number of squares the queen can attack from her position at (rq,cq).
 * In the board above, there are 24 such squares.
 * • Input
 *  ♦ int n: the number of rows and columns in the board
 *  ♦ nt k: the number of obstacles on the board
 *  ♦ int r_q: the row number of the queen's position
 *  ♦ int c_q: the column number of the queen's position
 *  ♦ int obstacles[k][2]: each element is an array of  integers, the row and
 *     column of an obstacle
 * • Returns
 *  ♦ int: the number of squares the queen can attack
 * • Constraints
 *  ♦ 0 <= n <= 10^5
 *  ♦ 0 <= k <= 10^5
 * • Subtasks
 *  ♦ For 30% of the maximum score:
 *   ◘ 0 <= n <= 100
 *   ◘ 0 <= k <= 100
 *  ♦ For 55% of the maximum score:
 *   ◘ 0 <= n <= 1000
 *   ◘ 0 <= k <= 10^5
 * • Example
 *  ♦ n=8, k=1, r_q=4, c_q=4, obstacles=[[3,5]]   //24
 * • TestCases
 *  ♦ n=4, k=0, r_q=4, c_q=4, obstacles=[]   //9
 *  ♦ n=5, k=3, r_q=4, c_q=3, obstacles=[[5,5],[4,2],[2,3]]   //10
 */
/*
 * Pseudocode
 * ○ vars: int attack
 * ○ make a loop for each direction the queen can attack from. From 1 to ...
 * ○ in each loop:
 *   ○ if(r_q,c_q exists in obctacles) break;
 *   ○ attack += 1
 * ○ return attack
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class QueensAttackII {

  public static void main(String[] args) {
    //System.out.println(queensAttack1(8, 1, 4, 4, List.of(List.of(3,5)))); //24
    //System.out.println(queensAttack1(4, 0, 4, 4, List.of())); //9
    System.out.println(queensAttack1(5, 3, 4, 3, List.of(List.of(5,5),List.of(4,2),List.of(2,3)))); //10
    //System.out.println(queensAttack1(5, 3, 4, 3, List.of(List.of(4,5),List.of(5,3),List.of(3,3),List.of(5,5),List.of(4,2),List.of(2,3)))); //10
  }//end main


  //FIRST MAKE IT WORK, THEN REFACTOR!!!
  public static int queensAttack1(int n, int k, int r_q, int c_q,
                                  List<List<Integer>> obstacles) { //mathematical approach
    int attack = 0;
    int closestObs = 0;
    List<Integer> closeObs;

    //up
    if(r_q != n) {
      //check if obstacles
      filteredObstacles(attack, 0, n, r_q, c_q, obstacles, obs -> obs.get(0) > r_q && obs.get(1) == c_q);

      /* List<List<Integer>> upObs = obstacles.stream()
                            .filter(obs -> obs.get(0) > r_q && obs.get(1) == c_q)
                            .sorted(Comparator.comparingInt(i -> i.get(0)))
                            .collect(Collectors.toList());
      if(upObs.isEmpty()) attack += n-r_q;
      else {
        closestObs = Collections.min(upObs, Comparator.comparing(e->e.get(0))).get(0);
        attack += (closestObs-(n+1));
      } */
      System.out.println("attack: " + attack + ", upClosestOrbs: " + closestObs + ", upObs: " + upObs);
    }

    //down
    if(r_q != 1) {
      //check if obstacles
      List<List<Integer>> downObs = obstacles.stream()
                            .filter(obs -> obs.get(0) < r_q && obs.get(1) == c_q)
                            .sorted(Comparator.comparingInt(i -> i.get(0)))
                            .collect(Collectors.toList());
      if(downObs.isEmpty()) attack += r_q-1;
      else {
        closestObs = Collections.max(downObs, Comparator.comparing(e->e.get(0))).get(0);
        attack += (r_q-1)-closestObs;
      }
      System.out.println("attack: " + attack + ", downClosestOrbs: " + closestObs + ", downObs: " + downObs);
    }

    //right
    if(c_q != n) {
      //check if obstacles
      List<List<Integer>> rightObs = obstacles.stream()
                            .filter(obs -> obs.get(0) == r_q && obs.get(1) > c_q)
                            .sorted(Comparator.comparingInt(i -> i.get(1)))
                            .collect(Collectors.toList());
      if(rightObs.isEmpty()) attack += n-c_q;
      else {
        closestObs = Collections.min(rightObs, Comparator.comparing(e->e.get(1))).get(1);
        attack += (closestObs-(n+1));
      }
      System.out.println("attack: " + attack + ", rightClosestOrbs: " + closestObs + ", rightObs: " + rightObs);
    }

    //left
    if(c_q != 1) {
      //check if obstacles
      List<List<Integer>> leftObs = obstacles.stream()
                            .filter(obs -> obs.get(0) == r_q && obs.get(1) < c_q)
                            .sorted(Comparator.comparingInt(i -> i.get(1)))
                            .collect(Collectors.toList());
      if(leftObs.isEmpty()) attack += c_q-1;
      else {
        closestObs = Collections.max(leftObs, Comparator.comparing(e->e.get(1))).get(1);
        attack += (c_q-1)-closestObs;
      }
      System.out.println("attack: " + attack + ", leftClosestOrbs: " + closestObs + ", leftObs: " + leftObs);
    }

    return attack;
  }
  /* Refactoring intent */
  public static List<Integer> filteredObstacles(int toInc, int idx, char d, int r_q, int c_q,
                                                      List<List<Integer>> obstacles,
                                                      Predicate<List<Integer>> filterCondition
                                                      //Comparator<List<Integer>> sorter,
                                                      ) {
    List<List<Integer>> upObs = obstacles.stream()
                            .filter(filterCondition)
                            .sorted(Comparator.comparingInt(i -> i.get(idx)))
                            .collect(Collectors.toList());

      return d == 'u' !! d == 'r' ? Collections.min(upObs, Comparator.comparing(e->e.get(idx))).get(idx) :
                                    Collections.max(upObs, Comparator.comparing(e->e.get(idx))).get(idx);
                                                        /* return obstacles.stream()
                          .filter(filterCondition)
                          .sorted(Comparator.comparingInt(i -> i.get(0)))
                          .collect(Collectors.toList()); */
  }


  /* List.of() was introduced in Java 9!! */
  public static int queensAttack(int n, int k, int r_q, int c_q,
                                 List<List<Integer>> obstacles) {   //Mine.passed 2 TC
    int attack = 0, axis = 0;

    //System.out.println("Constains obstacle(3,5)? " + obstacles.contains(List.of(3,5)));
    //System.out.println("n: " + n + ", queen: (" + r_q + "," + c_q + "), obstacles: " + obstacles.toString());

    //up
    axis=1;
    while(r_q+axis <= n) {
      //System.out.println("check (cq+axis,rq)=(" + (r_q+axis) + "," + c_q + ") ; while(" + r_q + "+" + axis + " <= " + n + ")");
      if(obstacles.contains(Arrays.asList(r_q+axis,c_q))) break;
      attack += 1;
      axis += 1;
    }
    //System.out.println("up:          " + attack + " attacks, " + axis + " axisMoves");
    //up-left
    axis=1;
    while(r_q+axis <= n && c_q-axis >= 1) {
      if(obstacles.contains(Arrays.asList(r_q+axis,c_q-axis))) break;
      attack += 1;
      axis += 1;
    }
    //System.out.println("up-left:     " + attack + " attacks, " + axis + " axisMoves");
    //up-right
    axis=1;
    while(r_q+axis <= n && c_q+axis <= n) {
      if(obstacles.contains(Arrays.asList(r_q+axis,c_q+axis))) break;
      attack += 1;
      axis += 1;
    }
    //System.out.println("up-right:    " + attack + " attacks, " + axis + " axisMoves");

    //right
    axis=1;
    while(c_q+axis <= n) {
      if(obstacles.contains(Arrays.asList(r_q,c_q+axis))) break;
      attack += 1;
      axis += 1;
    }
    //System.out.println("right:      " + attack + " attacks, " + axis + " axisMoves");
    //down-right
    axis=1;
    while(r_q-axis >= 1 && c_q+axis <= n) {
      if(obstacles.contains(Arrays.asList(r_q-axis,c_q+axis))) break;
      attack += 1;
      axis += 1;
    }
    //System.out.println("down-right: " + attack + " attacks, " + axis + " axisMoves");
    //down
    axis=1;
    while(r_q-axis >= 1) {
      if(obstacles.contains(Arrays.asList(r_q-axis,c_q))) break;
      attack += 1;
      axis += 1;
    }
    //System.out.println("down:       " + attack + " attacks, " + axis + " axisMoves");
    //down-left
    axis=1;
    while(r_q-axis >= 1 && c_q-axis >= 1) {
      if(obstacles.contains(Arrays.asList(r_q-axis,c_q-axis))) break;
      attack += 1;
      axis += 1;
    }
    //System.out.println("down-left:  " + attack + " attacks, " + axis + " axisMoves");
    //left
    axis=1;
    while(c_q-axis >= 1) {
      if(obstacles.contains(Arrays.asList(r_q,c_q-axis))) break;
      attack += 1;
      axis += 1;
    }
    //System.out.println("left:       " + attack + " attacks, " + axis + " axisMoves");

    return attack;
  }//end queensAttack

}

/* n=5, k=3, r_q=4, c_q=3, obstacles=[[5,5],[4,2],[2,3]]   //10

    5   . ○ x ○ x
    4   . x Q ○ x
    3   . ○ x ○ .
    2   ○ . x . ○
    1   . . . . .
    
        1 2 3 4 5
 */

/* n=5, k=3, r_q=4, c_q=3, obstacles=[[5,5],[4,2],[2,3]]   //10

    5   . ○ ○ ○ x
    4   . x Q ○ ○
    3   . ○ ○ ○ .
    2   ○ . x . ○
    1   . . . . .
    
        1 2 3 4 5
 */

/* T.C.1  n=4, k=0, r_q=4, c_q=4, obstacles=[]   //9

    4   ○ ○ ○ Q
    3   . . ○ ○
    2   . ○ . ○
    1   ○ . . ○

        1 2 3 4
 */

/* Example  n=8, k=1, r_q=4, c_q=4, obstacles=[[3,5]]   //24

    8   . . . ○ . . . ○
    7   ○ . . ○ . . ○ .
    6   . ○ . ○ . ○ . .
    5   . . ○ ○ ○ . . .
    4   ○ ○ ○ Q ○ ○ ○ ○
    3   . . ○ ○ x . . .
    2   . ○ . ○ . . . .
    1   ○ . . ○ . . . .
    
        1 2 3 4 5 6 7 8
 */
