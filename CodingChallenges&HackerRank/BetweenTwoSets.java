/**
 * Between Two Sets
 * 
 * There will be two arrays of integers. Determine all integers that satisfy the following two conditions:
 * 1. The elements of the first array are "all factors of" the integer being considered
 * 2. The integer being considered "is a factor of" all elements of the second array
 * These numbers are referred to as being between the two arrays. Determine how many such numbers exist.
 * • Return the number of integers that are betwen the sets
 * 
 * (A 'factor' of a number is a whole number that divides that number evenly, leaving no remainder)
 * 
 * • Input Format
 * The first line contains two space-separated integers, n and m, the number of elements in arrays a and b.
 * 
 * • Constraints
 *  ♦ 0 <= x1 < x2 <= 10000
 *  ♦ 1 <= v1 <= 10000
 *  ♦ 1 <= v2 <= 10000
 */
/*
 * In short terms:
 * 
 * 1. get the multiples of the 1st Array, up to the LCM (Least Common Divider ||== the lowest value of the 2ndArray)
 *  i % a[] == 0
 * 2. get the Factors || Dividers of the 2nd Array
 *  b[] % i == 0
 * 
 * • Test Cases ()
 *  + a = [2,6]; b = [24,36]  // 2    // (6,12)
 *  + a = [2,4]; b = [16,32,96]  // 3    // (4,8,16)
 */
import java.util.ArrayList;
import java.util.List;

class BetweenTwoSets {
  public static void main(String[] args) {
    List<Integer> a1 = new ArrayList<>();
    List<Integer> b1 = new ArrayList<>();
    a1.add(2);
    a1.add(6);
    b1.add(24);
    b1.add(36);

    List<Integer> a2 = new ArrayList<>();
    List<Integer> b2 = new ArrayList<>();
    a2.add(2);
    a2.add(4);
    b2.add(16);
    b2.add(32);
    b2.add(96);

    // call for TC 1
    System.out.println(BetweenTwoSetsTest(a1, b1));
    // call for TC 2
    System.out.println(BetweenTwoSetsTest(a2, b2));
  }

  /*
    * Complete the 'getTotalX' or 'BetweenTwoSets' function below.
    *
    * The function is expected to return an INTEGER.
    * The function accepts following parameters:
    *  1. INTEGER_ARRAY a
    *  2. INTEGER_ARRAY b
    */
  // Write your code here
  public static int BetweenTwoSetsTest(List<Integer> a, List<Integer> b) {
    //HashSet<Integer> factors = new HashSet<>();
    int count = 0;
    int lowestMultiple = a.get(a.size() - 1);
    int largestDivider = b.get(0);

    System.out.println();
    for(int i = lowestMultiple; i <= largestDivider; i++) {
      if(checkMultiples(a, i) && checkDivisors(b, i))
        count++;
    }

    return count;
  }

  public static boolean checkMultiples(List<Integer> myList, int i) {
    for(int m : myList)
      if(i % m != 0) return false;
    return true;
  }

  public static boolean checkDivisors(List<Integer> myList, int i) {
    for(int m : myList)
      if(m % i != 0) return false;
    return true;
  }
}
