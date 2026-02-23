/**
 * A modified Kaprekar number is a positive whole number with a special property.
 * If you square it, then split the number into two integers and sum those integers,
 * you have the same value you started with.
 * Consider a positive whole number n with d digits. We square n to arrive at a number
 * that is either 2xd digits long or (2xd)-1 digits long. Split the string representation
 * of the square into two parts, l and r. The right hand part, r must be d digits long.
 * The left is the remaining substring. Convert those two substrings back to integers,
 * add them and see if you get n.
 * Given two positive integers  and  where  is lower than , write a program to print
 * the modified Kaprekar numbers in the range between  and , inclusive. If no modified
 * Kaprekar numbers exist in the given range, print INVALID RANGE.
 * ۝ Input
 *  ۞ int p: the lower limit
 *  ۞ int q: the upper limit
 * ۝ Returns/Prints
 *  ۞ print the list of modified Kaprekar numbers,
 *    space-separated on one line and in ascending order
 *    If no modifiedKaprekarNumbers exist in range, print INVALID RANGE
 * ۝ Constraints
 *  ۞ 0 < p < q < 100000
 * ۝ Example
 *  ۞ n = 5, d = 1   //not a modified Kaprekar number
 *  ۞ n = 9, d = 1   //9
 * ۝ TestCase
 *  ۞ p = 1, q = 100   //1 9 45 55 99
 *  ۞ p = 100, q = 300   //297
 */
/*
  Pseudocode
  + Use an ArrayList to store the kaprekar numbers
  + squareRoot > split(literally) in 2 > if sum both integers == n
  + if empty print "..." else sort then print arrayList
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class ModifiedKaprekarNumbers {

  public static void main(String[] args) {
    //kaprekarNumbers(1,100);  //passed
    //kaprekarNumbers(100, 300);  //passed
    kaprekarNumbers(1, 99999);  //NOT passed, Expects:  1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999
    //missing:  77778 82656 95121 99999
  }

  public static void kaprekarNumbers(int p, int q) {
    List<Integer> kaprekarNumsArr = new ArrayList<>();
    int l,r, kLength = 0;

    for(int i = p; i <= q; i++) {
      kLength = String.valueOf(i).length();
      int sq = (int) Math.pow(i, 2);
      String sqS = String.valueOf(sq);

      if(sqS.length() == 1) {  //for single digits
        l = 0;
        r = sq;
      } else {
        String rS = sqS.substring(sqS.length() - kLength);
        r = Integer.parseInt(rS);
        l = Integer.parseInt(sqS.replace(rS, ""));
      }
      /* // ***---Debugging start---***
      if(i == 297) {
        System.out.println("i: " + i + ", kLength: " + kLength + ", sq: " + sq + ", l: " + l + ", r: " + r);
      }
      // ***---Debugging end---*** */
      if(l+r == i) kaprekarNumsArr.add(i);
    }

    if(kaprekarNumsArr.isEmpty()) System.out.println("INVALID RANGE");
    else {
      kaprekarNumsArr.stream().map(e -> String.valueOf(e) + " ").forEach(System.out::print);
    }
  }

}
