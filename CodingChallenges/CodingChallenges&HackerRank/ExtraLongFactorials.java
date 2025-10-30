/**
 * The factorial of the integer n, written n!, is defined as:
 * n! = n x (n - 1) x (n - 2) x ... x 3 x 2 x 1
 * Calculate and print the factorial of a given integer.
 * 
 * • For example, if n=30, we calculate 30 x 29 x 28 x ... x 2 x 1
 * and get 265252859812191058636308480000000.
 * • Input
 *  ♦ Input consists of a single integer n
 * • Returns
 *  ♦ Print the factorial of n.
 * 
 * • Constraints
 *  ♦ 1<= n <=50
 * 
 * • TestCase
 *  ♦ n = 25   //15511210043330985984000000
 */
/*
 * Pseudocode
 * ♦ Opt1:
 *  ○ create variable long fact = 1
 *  ○ loop from n to 1 || while n > 0
 *   + fact *= 30;
 *   + n--;
 *  ○ return fact
 * 
 * ♦ Opt2: recursive
 */
import java.math.BigInteger;

public class ExtraLongFactorials {

  public static void main(String[] args) {
    /* extraLongFactorials(30);
    extraLongFactorials(25); */
    //System.out.println(recursiveSolution(30));
    extraLongFactorials(5);
    System.out.println(recursiveSolution(BigInteger.valueOf(5)));
  }//end main

  public static BigInteger recursiveSolution(BigInteger bigN) {
    if (bigN.compareTo(BigInteger.ZERO) < 0) {
      throw new IllegalArgumentException("Factorial is not defined for negative numbers");
    }

    // BASE CASE: 0! = 1! = 1
    if (bigN.equals(BigInteger.ZERO) || bigN.equals(BigInteger.ONE)) {
      return BigInteger.ONE;
    }

    // RECURSIVE STEP: n! = n * (n - 1)!
    return bigN.multiply(recursiveSolution(bigN.subtract(BigInteger.ONE)));
  }//end recursiveSolution

  public static int recursiveSolutionForSimpleIntegers(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Factorial is not defined for negative numbers");
    }
    if (n == 0 || n == 1) {
        return 1; // BASE CASE: 0! = 1! = 1
    }
    
    return n * recursiveSolutionForSimpleIntegers(n - 1); // RECURSIVE CASE. Always incorporate result of recursive call
  }//end recursiveSolutionForSimpleIntegers

    public static void extraLongFactorials(int n) {
    BigInteger fact = new BigInteger("1");
    BigInteger bigN = new BigInteger(String.valueOf(n));
    while (bigN.compareTo(BigInteger.ZERO) > 0) {
      System.out.println("bigN: " + bigN + ", fact: " + fact);
      fact = fact.multiply(bigN);
      bigN = bigN.subtract(BigInteger.ONE);
    }
    System.out.println("extraLongFactorials(): " + fact);
  }//end extraLongFactorials
  
}
