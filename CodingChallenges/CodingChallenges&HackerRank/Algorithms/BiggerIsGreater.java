/**
 * Lexicographical order is often known as alphabetical order when dealing
 * with strings. A string is greater than another string if it comes later
 * in a lexicographically sorted list.
 * Given a word, create a new word by swapping some or all of its characters.
 * This new word must meet two criteria:
 * • It must be greater than the original word
 * • It must be the smallest word that meets the first condition
 * 
 * ۝ Input
 *  ۞ string w: a word
 * ۝ Return
 *  ۞ string: the smallest lexicographically higher string possible or no answer
 * ۝ Constraints
 *  ۞ 1 <= T <= 10^5
 *  ۞ 1 <= lengthOfW <= 100
 * 
 * ۝ Example
 *  ۞ w = "abcd"    //"abcd"
 * 
 * ۝ TestCases
 *  ۞ ab    //ba
 *  ۞ bb    //no answer
 *  ۞ hefg  //hegf
 *  ۞ dhck  //dhkc
 *  ۞ dkhc  //hcdk
 *  ۞ lmno  //lmon
 *  ۞ dcba  //no answer
 *  ۞ dcbb  //no answer
 *  ۞ abdc  //acbd
 *  ۞ abcd  //abdc
 *  ۞ fedcbabcd  //fedcbabdc
 */
/*
  Conditions:
  + It must be greater than the original word::
     -It must come next in alphabetical order
  + It must be the smallest word that meets the first condition
     -IT must be the closest in order to the original Word
  
  Pseudocode
  1۝ vars: char nextMaxChar, copy w to W
  2۝ Loop through W to get nextMaxChar
    - which will be: nextMaxChar > x > W[0]
  3۝ Remove nextMaxChar from W
  4۝ sort W
  5۝ append nextMaxChar to beggining of W
  6۝ return if W == w ? no answer : W

  2ndTry
  ۝ descendingSort W from [1] to [end]
  ۝ if not the same as w return nextMaxChar+W
   if the same, means we need to look for a greater letter than the beginning one, so:
  ۝ look for the real nextMaxChar
     loop, and check:  if char > W[0] && <= nextMaxChar then nextMaxChar = that-Char
  ۝ if nextMaxChar == W[0] return W
  ۝ remove NextMaxChar from W
  ۝ descendingSort W
  ۝ return nextMaxChar+W
 */
import java.util.stream.IntStream;


public class BiggerIsGreater {

  public static void main(String[] args) {
    System.out.println(biggerIsGreater("ab"));
  }

  public static String biggerIsGreater(String w) {
    if(w.length() == 1) return "no answer";
    if(w.length() == 2) {
      if(w.charAt(0) >= w.charAt(1)) return "no answer";
      else return (String.valueOf(w.charAt(0)) + String.valueOf(w.charAt(1)));
    }
    
    char nextMaxChar = w.charAt(0);
    char[] W = w.toCharArray();
    //2۝ Loop through W to get nextMaxChar
    
    for(int i=1; i<W.length; i++) {
      if(W[i] > w.charAt(0) && W[i] < ) {

      }
    }
    
    return "";
  }

}
