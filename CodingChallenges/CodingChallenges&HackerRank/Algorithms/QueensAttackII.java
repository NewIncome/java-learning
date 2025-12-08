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

import javax.swing.text.html.HTMLFrameHyperlinkEvent;

public class QueensAttackII {

  public static void main(String[] args) {
    System.out.println(queensAttack1(8, 1, 4, 4, List.of(List.of(3,5)))); //24
    System.out.println(queensAttack1(4, 0, 4, 4, List.of())); //9
    System.out.println(queensAttack1(5, 3, 4, 3, List.of(List.of(5,5),List.of(4,2),List.of(2,3)))); //10
    System.out.println(queensAttack1(5, 3, 4, 3, List.of(List.of(4,5),List.of(5,3),List.of(3,3),List.of(5,5),List.of(4,2),List.of(2,3)))); //7
  }//end main


  enum Dirs {
    NO(1), SO(2), EA(3), WE(4), NE(5), NW(6), SE(7), SW(8);
    private final int direction;
    Dirs(int direction) { this.direction = direction; }
  }

  //FIRST MAKE IT WORK, THEN REFACTOR!!!
  public static int queensAttack1(int n, int k, int r_q, int c_q,
                                  List<List<Integer>> obstacles) { //mathematical approach
    int attack = 0;

    // NORTH
    if(r_q != n) {  // if queens at the top no attacks available
      List<List<Integer>> obsNO = filterObstaclesByDir(Dirs.NO, r_q, c_q, obstacles);

      attack += obsNO.isEmpty() ? n - r_q :  (closestObs(Dirs.NO, obsNO) - 1) - r_q;
      //System.out.println("attack: " + attack + ", NorthClosestOrbsPos: " + (obsNO.isEmpty() ? "empty" : closestObs(Dirs.NO, obsNO)) + ", NorthObs: " + obsNO);
    }

    // SOUTH
    if(r_q != 1) {  // if queens at the bottom no attacks available
      List<List<Integer>> obsSO = filterObstaclesByDir(Dirs.SO, r_q, c_q, obstacles);

      attack += obsSO.isEmpty() ? r_q - 1 : r_q - (closestObs(Dirs.SO, obsSO) + 1);
      //System.out.println("attack: " + attack + ", SouthClosestOrbsPos: " + (obsSO.isEmpty() ? "empty" : closestObs(Dirs.SO, obsSO)) + ", SouthObs: " + obsSO);
    }

    // EAST
    if(c_q != n) {  // if queens at the mostRight no attacks available
      List<List<Integer>> obsEA = filterObstaclesByDir(Dirs.EA, r_q, c_q, obstacles);

      attack += obsEA.isEmpty() ? n - c_q : (closestObs(Dirs.EA, obsEA) - 1) - c_q;
      //System.out.println("attack: " + attack + ", EastClosestOrbsPos: " + (obsEA.isEmpty() ? "empty" : closestObs(Dirs.EA, obsEA)) + ", EastObs: " + obsEA);
    }

    // WEST
    if(c_q != 1) {  // if queens at the mostLeft no attacks available
      List<List<Integer>> obsWE = filterObstaclesByDir(Dirs.WE, r_q, c_q, obstacles);

      attack += obsWE.isEmpty() ? c_q - 1 : c_q - (closestObs(Dirs.WE, obsWE) + 1);
      //System.out.println("attack: " + attack + ", WestClosestOrbsPos: " + (obsWE.isEmpty() ? "empty" : closestObs(Dirs.WE, obsWE)) + ", WestObs: " + obsWE);
    }

    // DIAGONALS
    // NORTH-EAST VectorAlgorithm withObs (r_obs-1)-r_q
    if(r_q != n && c_q != n) {  // if queens at the top no attacks available
      List<List<Integer>> obsNE = filterObstaclesByDir(Dirs.NE, r_q, c_q, obstacles); //to filter Obs direction matters
      
      attack += obsNE.isEmpty() ? Math.min(n - r_q,n - c_q) : (closestObs(Dirs.NO, obsNE) - 1) - r_q;                          //to get closest one No, from filtered
      //System.out.println("attack: " + attack + ", NorthEastClosestOrbsPos: " + (obsNE.isEmpty() ? "empty" : closestObs(Dirs.NO, obsNE)) + ", NorthEastObs: " + obsNE);
    }

    // NORTH-WEST VectorAlgorithm withObs (r_obs-1)-r_q
    if(r_q != n && c_q != 1) {  // if queens at the top no attacks available
      List<List<Integer>> obsNW = filterObstaclesByDir(Dirs.NW, r_q, c_q, obstacles);
      
      attack += obsNW.isEmpty() ? Math.min(n - r_q,c_q - 1) : (closestObs(Dirs.NO, obsNW) - 1) - r_q;
      //System.out.println("attack: " + attack + ", NorthWestClosestOrbsPos: " + (obsNW.isEmpty() ? "empty" : closestObs(Dirs.NO, obsNW)) + ", NorthWestObs: " + obsNW);
    }

    // SOUTH-EAST VectorAlgorithm withObs (r_q-1)-r_obs
    if(r_q != 1 && c_q != n) {  // if queens at the top no attacks available
      List<List<Integer>> obsSE = filterObstaclesByDir(Dirs.SE, r_q, c_q, obstacles); //to filter Obs direction matters
      
      attack += obsSE.isEmpty() ? Math.min(r_q - 1,n - c_q) : (r_q - 1) - closestObs(Dirs.SO, obsSE);                          //to get closest one No, from filtered
      //System.out.println("attack: " + attack + ", SouthEastClosestOrbsPos: " + (obsSE.isEmpty() ? "empty" : closestObs(Dirs.NO, obsSE)) + ", SouthEastObs: " + obsSE);
    }

    // SOUTH-WEST VectorAlgorithm withObs (r_q-1)-r_obs
    if(r_q != 1 && c_q != 1) {  // if queens at the top no attacks available
      List<List<Integer>> obsSW = filterObstaclesByDir(Dirs.SW, r_q, c_q, obstacles); //to filter Obs direction matters
      
      attack += obsSW.isEmpty() ? Math.min(r_q - 1,c_q - 1) : (r_q - 1) - closestObs(Dirs.SO, obsSW);                          //to get closest one No, from filtered
      //System.out.println("attack: " + attack + ", SouthWestClosestOrbsPos: " + (obsSW.isEmpty() ? "empty" : closestObs(Dirs.NO, obsSW)) + ", SouthWestObs: " + obsSW);
    }

    //*¡I could very well call all the filteredObstacles variables with the same variable, just reassign it each time!

    /* VectorAlgorithms for diagonalAttackAdditionWithout-Obstacle:
     *  NE Math.min(n - r_q,n - c_q)
     *  NW Math.min(n - r_q,c_q - 1)
     *  SE Math.min(r_q - 1,n - c_q)
     *  SW Math.min(r_q - 1,c_q - 1)
    */
    /* VectorAlgorithms for diagonalAttackAdditionWith-Obstacle:
     *  NE (r_obs-1)-r_q
     *  NW (r_obs-1)-r_q
     *  SE (r_q-1)-r_obs
     *  SW (r_q-1)-r_obs
    */
    return attack;
  }

  //*** min-max not needed if sorting done correctly in filterObstaclesByDir() method
  public static int closestObs(Dirs dir, List<List<Integer>> obstacles) {
    switch (dir) {
      case NO:
        return Collections.min(obstacles, Comparator.comparing(e->e.get(0))).get(0);
      case SO:
        return Collections.max(obstacles, Comparator.comparing(e->e.get(0))).get(0);
      case EA:
        return Collections.min(obstacles, Comparator.comparing(e->e.get(1))).get(1);
      case WE:
        return Collections.max(obstacles, Comparator.comparing(e->e.get(1))).get(1);
      default:
        return 0;
    }
  }

  public static List<List<Integer>> filterObstaclesByDir(Dirs direction, int r_q, int c_q, List<List<Integer>> obstacles) {
    return switch (direction) {
      case NO ->
        obstacles.stream()
                    .filter(obs -> obs.get(0) > r_q && obs.get(1) == c_q)
                    .sorted(Comparator.comparingInt(i -> i.get(0)))
                    .collect(Collectors.toList());
      case SO ->
        obstacles.stream()
                    .filter(obs -> obs.get(0) < r_q && obs.get(1) == c_q)
                    .sorted(Comparator.comparingInt(i -> i.get(0)))
                    .collect(Collectors.toList());
      case EA ->
        obstacles.stream()
                    .filter(obs -> obs.get(0) == r_q && obs.get(1) > c_q)
                    .sorted(Comparator.comparingInt(i -> i.get(1)))
                    .collect(Collectors.toList());
      case WE ->
        obstacles.stream()
                    .filter(obs -> obs.get(0) == r_q && obs.get(1) < c_q)
                    .sorted(Comparator.comparingInt(i -> i.get(1)))
                    .collect(Collectors.toList());
      case NE ->
        obstacles.stream()
                    .filter(obs -> obs.get(0) - r_q == obs.get(1) - c_q && obs.get(0) > r_q)
                    .sorted(Comparator.comparingInt(i -> i.get(0)))
                    .collect(Collectors.toList());
      case NW ->
        obstacles.stream()
                    .filter(obs -> obs.get(0) - r_q == c_q - obs.get(1) && obs.get(0) > r_q)
                    .sorted(Comparator.comparingInt(i -> i.get(0)))
                    .collect(Collectors.toList());
      case SE ->
        obstacles.stream()
                    .filter(obs -> r_q - obs.get(0) == obs.get(1) - c_q && obs.get(0) < r_q)
                    .sorted(Comparator.comparingInt(i -> i.get(0)))
                    .collect(Collectors.toList());
      case SW ->
        obstacles.stream()
                    .filter(obs -> r_q - obs.get(0) == c_q - obs.get(1) && obs.get(0) < r_q)
                    .sorted(Comparator.comparingInt(i -> i.get(0)))
                    .collect(Collectors.toList());
      default -> null;
    /* VectorAlgorithms for DiagonalFiltering
      *  NE (r_obs - r_q) == (c_obs - c_q)
      *  NW (r_obs - r_q) == (c_q - c_obs)
      *        3      4        4      5
      *  SE (r_q - r_obs) == (c_obs - c_q)
      *        4     3          5      4
      *  SW (r_q - r_obs) == (c_q - c_obs)
      */
    };
  }



  /* List.of() was introduced in Java 9!! */
  public static int queensAttack(int n, int k, int r_q, int c_q,    //timeLimitExceeded...
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

/* n=5, k=3, r_q=4, c_q=3, obstacles=[[5,5],[4,2],[2,3]]   //7

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


// TESTING
/*
    9   . . . . . . . . .
    8   ○ . . . Q . . . .  (8,5)
    7   . . . Q . ○ . . .  (7,4)
    6   . . Q Q ○ . ○ . .  (6,3) (6,4)
    5   . . . . . ○ . ○ .
    4   . . . . . . ○ . ○
    3   . . . . . . . ○ .
    2   . . . . . . . . ○
    1   . . . . . . . . .
    
        1 2 3 4 5 6 7 8 9
*/
/*
    8   . . . . . . . .
    7   . . . . . . . .
    6   . . . . . . . .
    5   . . . . . . . .
    4   . . . Q . . . .
    3   . . . . . . . .
    2   . . . . . . . .
    1   . . . . . . . .
    
        1 2 3 4 5 6 7 8
*/
/*
    5   . . . . .
    4   . Q Q . .   2(4,3) 3(4,3)   2(atk=3) 3(atk=2)
    3   . Q . ○ .   1(3,2)          1(atk=2)
    2   . . ○ . ○
    1   . . . ○ .
    
        1 2 3 4 5
 */