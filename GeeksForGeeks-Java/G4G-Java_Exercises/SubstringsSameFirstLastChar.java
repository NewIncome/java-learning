/**
 * Given a string s consisting of lowercase characters,
 * the task is to find the count of all substrings that
 * start and end with the same character.
 * 
 * T.C.
 * Input: s = "abcab"
 * Output: 7  -> "a", "abca", "b", "bcab", "c", "a", and "b"
 * 
 * Input: s = "aba"
 * Output: 4  -> "a", "aba", "b", "a"
 * 
 * Input: s = "cafdgjjg"   <- got it wrong
 * Output: 10  ->
 * 
 */

/*
 * Pseudo-code (steps)
 * 0. Create vars:
 *     ArrayList<String> strings
 *     StringBuilder str = new StringBuilder(string)
 *     int j = strings.length -1
 * 1. Loop over string
 * 2. If str[i] == str[j]
 *     then strings.add(str)
 * 3. If str[i] == str[j-1]
 *     then strings.add(str)
 * 4. deleteCharAt(j)
 * 5. j--
 * 6. return strings.length
 */
import java.util.ArrayList;

public class SubstringsSameFirstLastChar {
  public static void main(String[] args) {
    System.out.println(countSubstring("abcab"));
    System.out.println();
    System.out.println(countSubstring("aba"));
  }//end of main

  public static int countSubstring(String s) {
    // Variables
    ArrayList<String> strings = new ArrayList<>();
    StringBuilder str = new StringBuilder(s);
    int j = str.length() - 1;

    // Loop
    for(int i = 0; i <= j; i++) {
      System.out.println("i: " + i + ", j:" + j + ", String: " + str + ", ArrL: " + strings);
      System.out.println(" Comparison 1: " + str.charAt(0) + ", " + str.charAt(j));
      System.out.println(" Comparison 2: " + str.charAt(1) + ", " + str.charAt(j));
      if(str.charAt(0) == str.charAt(j))
        strings.add(str.toString());
      if(str.length() > 2 && str.charAt(1) == str.charAt(j)) {
        System.out.println(" Substring to add: " + str.substring(i+1, j+1));
        strings.add(str.substring(1));
      }
      str.deleteCharAt(j);
      j--;
    }
    System.out.println(strings);

    return strings.size() + s.length();
  }//end of countSubstring
}
