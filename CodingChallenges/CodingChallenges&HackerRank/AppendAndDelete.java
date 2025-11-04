/**
 * You have two strings of lowercase English letters. You can perform two
 * types of operations on the first string:
 * 1. Append a lowercase English letter to the end of the string.
 * 2. DELETE the last character of the string. Performing this operation
 * ON AN EMPTY STRING results in an empty string.
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
 *  ♦ s = "y", t = "yu", k = 2    //No
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
    System.out.println(solution05("abc", "def", 6)); //Yes
    System.out.println(solution05("hackerhappy", "hackerrank", 9)); //Yes
    System.out.println(solution05("aba", "aba", 7)); //Yes
    System.out.println(solution05("ashley", "ash", 2)); //No
    System.out.println(solution05("y", "yu", 2)); //No
  }//end main

  public static String solution05(String s, String t, int k) {  //Mine
    int totalL = s.length() + t.length();
    int eqChars = 0;
    int remSnT;
    /* //Case#1 s == t //they're already the same
    if(s == t) return "Yes #1"; */
    //Case#2 tLength <= k //can replace the whole string
    if(totalL <= k) return "Yes #1";
    //Case#3 "hackerhappy", "hackerrank"
    for (int i = 0; i < s.length() && i < t.length(); i++) {
      //System.out.println("i: " + i + ", s.split(\"\")[i]: " + s.split("")[i] + ", eqChars: " + eqChars);
      if(s.toCharArray()[i] == t.toCharArray()[i]) eqChars+=1;
      else break;
    }
    remSnT = (s.length() - eqChars) + (t.length() - eqChars);
    if (remSnT > k) return "No #1"; //MUST HAVE TAKEN THIS INTO ACCOUNT!!!
    //Because of the next line; % takes values as absolute, doesn't matter the sign(-)
    else if((k - remSnT) % 2 == 0) return "Yes #2";  //You can use a step to delete from "an empty String"
    //System.out.println("remSnT: " + remSnT + ", (s.length() - eqChars): " + (s.length() - eqChars) + ", (t.length() - eqChars): " + (t.length() - eqChars));

    return "No #2";
  }//end solution05

  public static String solution04(String s, String t, int k) { //WORKING, from HRdiscussions
    int sLen = s.length();
    int tLen = t.length();
    int i = 0;
    char[] a = s.toCharArray();
    char[] b = t.toCharArray();

    while (i < sLen && i < tLen && a[i] == b[i]) i++;

    int opsNeeded = (sLen - i) + (tLen - i);

    if (opsNeeded > k) {
        return "No #1";
    }
    else if ((k - opsNeeded) % 2 == 0 || k >= sLen + tLen) {
        return "Yes";
    }
    else {
        return "No #2";
    }
  }//end solution04

  //having the same issue/error/bad answer, as in solution02()
  public static String solution03(String s, String t, int k) {
    int count = 0;
    char[] sArr = s.toCharArray();
    char[] tArr = t.toCharArray();
    System.out.println("sArr[i] == tArr[i]");
    for (int i = 0; i < t.length(); i++) {
      System.out.println("i: " + i + ", " + sArr[i] + " == " + tArr[i]);
      if (sArr[i] == tArr[i]) count+=1;
    }
    int tMinus = t.length();
    int sMinus = s.length();
    int stk = k - (tMinus + sMinus);

    if(tMinus+sMinus < k && t.length()+s.length() > k && stk%2!=0) return "No";
    else if (tMinus+sMinus <= k) return "Yes";
    else return "No";
  }//end solution03

  //Solution from Python code, not working
  public static String solution02(String s, String t, int k) {
    int count = 0;

    for(char i : s.toCharArray()) {
      for(char j : t.toCharArray()) {
        if (i == j) ++count;
        else break;
      }
    }

    int totalL = s.length() + t.length();

    /*  Case 1
        totalL <= ((2*count) + k)
        Case 2
        totalL%2 == k%2 : "Yes"
        Case 3
        totalL < k
        case 1 and case 2 or case 3 */

        if(((totalL <= ((2*count) + k)) && (totalL%2 == k%2)) || totalL<k) {
          return "Yes";
        } else {
          return "No";
        }
  }//end solution02

  public static String solution01(String s, String t, int k) {  //Mine
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
  }//end solution01

}
