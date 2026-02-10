/**
 * Recursion notes, additional:
 * 
 * When you invoque a function, you add what is known as a frame to the call stack
 * It's a Stack DataStructure
 *   We add frames to the CallStack, until our condition is met
 *   Then we undo everything, starting at the top
 * 
 * The 'Base Condition', is the point where the recusrion has to stop
 * 
 * The CallStack has a limit, and that's an issue to keep into consideration
 * Typical recursion depth in Java:  ~5,000 — 20,000 calls (very rough range)
 * But it varies by JVM, so it depends on OS, stack size settings, method complexity, etc.
 * …but it’s not guaranteed.
 * ie.:  (In my current working Asus machine it's:  15,499)
 * 
 */

public class Recursion {
  
  public static void main(String[] args) {
    /**
     * recursion = a function that call itself from within
     *             helps to visualize a complex problem into 'repetitive' basic steps,
     *             which can be solved more easily iteratively or recursively
     *             iterative = faster, complex
     *             recursive = slower, simpler
     */
    walkIt(9);  System.out.println();

    walkRe(9);  System.out.println();

    walkAsc(15499);
  }


  // ITERATIVE
  public static void walkIt(int steps) {
    for (int step = 1; step <= steps; step++) {
     System.out.println("You take step #" + step);
    }
  }

  // RECURSIVE
  public static void walkRe(int steps) {
    if(steps == 0) return; // ¡BASE CONDITION!

    System.out.println("You took step #" + steps);
    walkRe(steps - 1);
    /*  If we print the 'steps' then call the function, it counts in Descending order
        If we call the function, then print the 'steps', it counts in Ascending order  */
  }
  
  public static void walkAsc(int steps) {
    if(steps == 0) return; // Base Condition

    walkAsc(steps - 1);
    System.out.println("You took step #" + steps);
  }


  // Iterative example
  static factorialIt(int x) {
    int result = 1;

    if(x > 0) {
      for (int y = 1; y < x + 1; y++) {
        result *= y;
      }
      return result;
    }
  }

  // Recursive example
  static factorialRe(int x) {
    if(x == 1) return 1;  // ¡BASE CONDITION!

    return x * factorialRe(x - 1);
  }

}
