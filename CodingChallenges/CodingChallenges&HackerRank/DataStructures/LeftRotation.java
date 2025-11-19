/**
 * A leftRotation operation on a circular array shifts each of the array's
 * elements 1 unit to the left. The elements that fall off the left end reappear
 * at the right end. Given an integer d, rotate the array that many steps to the
 * left and return the result.
 * • Input
 *  ♦ int d: the amount to rotate by
 *  ♦ int arr[n]: the array to rotate
 * • Returns
 *  ♦ int[n]: the rotated array
 * • Constraints
 *  ♦ 1<= n <=10^5
 *  ♦ 1<= d <= n
 *  ♦ 1<= a[i] <=10^6
 * • Example
 *  ♦ arr=[1,2,3,4,5], d=2   //[3,4,5,1,2]
 * • TestCases
 *  ♦ arr=[1,2,3,4,5], d=4   //[5,1,2,3,4]
 */
/*
 * Pseudocode
 * ○ loop d times
 *   ○ rotate array to the left
 * ○ return array
 * 
 * Opt#2
 * ○ E.C.1: n=1, return the arr
 * ○ createa sublist A(0 to d) and B(last d ints) of the and concat them B+A
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class LeftRotation {

  public static void main(String[] args) {
    //System.out.println(rotateLeftV2(2, List.of(1,2,3,4,5)));
    System.out.println(rotateLeftV2(4, new ArrayList(List.of(1,2,3,4,5))));
  }//end main

  public static List<Integer> rotateLeftV2(int d, List<Integer> arr) { //timedOUT
    for (int i=0; i<d; i++) Collections.rotate(arr, d);
    return arr;
  }//end rotateLeftV2

  public static List<Integer> rotateLeft(int d, List<Integer> arr) { //passed OK
    List<Integer> swapedArr = new ArrayList<>();
    List<Integer> A = new ArrayList<>(arr.subList(0, d));
    List<Integer> B = new ArrayList<>(arr.subList(d, arr.size()));

    swapedArr.addAll(B);
    swapedArr.addAll(A);

    return swapedArr;
  }//end rotateLeft

}
