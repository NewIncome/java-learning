/**
 * You have two strings of lowercase English letters. You can perform two
 * types of operations on the first string:
 * 1. Append a lowercase English letter to the end of the string.
 * 2. Delete the last character of the string. Performing this operation
 * on an empty string results in an empty string.
 * Given an integer, k, and two strings, s and t, determine whether or not
 * you can convert s to t by performing exactly k of the above operations
 * on s. If it's possible, print Yes. Otherwise, print No.
 * • Input
 *  ♦ string s: the initial string
 *  ♦ string t: the desired string
 *  ♦ int k: the exact number of operations that must be performed
 * • Return
 *  ♦ string: either Yes or No
 * • Example
 *  ♦ s = [a,b,c], t = [d,e,f], k = 6    //Yes
 * • Constraints
 *  ♦ 1<= |s| <=100
 *  ♦ 1<= |t| <=100
 *  ♦ 1<= k <=100
 *  ♦ s and t consist of lowercase English letters, ascii[a-z].
 * 
 * • Test Cases
 *  ♦ s = "hackerhappy", t = "hackerrank", k = 9   //Yes
 *  ♦ s = "aba", t = "aba", k = 7   //Yes
 *  ♦ s = "ashley", t = "ash", k = 2   //No
 */
/*
 * Pseudocode
 * ○ TC0: if s == t; return Yes
 * ○ TC1: if s.size + t.size <= k; return Yes
 * ○ TC2: if |s.size - t.size| > K; return No
 * ○ TC3: Now to compare
 *  ◘ if t.indexOf(s) == 0 && |s.size - t.size| <= k; return true
 *  ◘ else false
 */
public class AppendAndDelete {

  public static void main(String[] args) {
    System.out.println(appendAndDelete("abc", "def", 6)); //Yes
    System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));
    System.out.println(appendAndDelete("aba", "aba", 7));
    System.out.println(appendAndDelete("ashley", "ash", 2));
  }//end main

  public static String appendAndDelete(String s, String t, int k) {
    if(s == t) return "Yes";
    if((s.length() + t.length()) <= k) return "Yes";
    if(Math.abs(s.length() - t.length()) > k) return "No";

    int i = 1;
    while(i <= k) {
      s = s.substring(0, s.length()-1);
      //System.out.println("i: " + i + ", s: " + s);
      if(t.contains(s)) {
        if((Math.abs(t.length() - s.length()) + i) <= k) return "Yes";
        else return "No";
      }
      ++i;
    }

    return "No";
  }//end appendAndDelete

}
