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

  wVid
   1• Traverse from Right-to-Left. Because we need to swap the to-right char with the nearestBigLeft
   2• Find the lower char. the elm that's lower than the previous elm
   3• Separate the String, get the Left-side, after the 1stLower
   4• Find the min-char in that sub-string after 1stLower that is also greater than 1stLower
   5• Swap that min-char-subString(2ndLower) with 1stLower
   6• Now Sort that substring after 2ndLower, in ascending order
 */
import java.util.Arrays;
import java.util.stream.IntStream;


public class BiggerIsGreater {

  public static void main(String[] args) {
    System.out.println(biggerIsGreater("ab"));
  }


  public static String biggerIsGreater(String w) {
    char charArray[] = w.toCharArray();
    int n = charArray.length;
    int endIndex = 0;

    for (endIndex = n-1; endIndex > 0; endIndex--) {
      if(charArray[endIndex] > charArray[endIndex - 1]) break;
    }

    if(endIndex == 0) return "no answer";
    else {
      int firstSmallChar = charArray[endIndex - 1];
      int nextSmallChar = endIndex;

      for (int startIndex = endIndex + 1; startIndex < n; startIndex++) {
        if(charArray[startIndex] > firstSmallChar && charArray[startIndex] < charArray[nextSmallChar]) {
          nextSmallChar = startIndex;
        }
      }

      swap(charArray, endIndex - 1, nextSmallChar);

      Arrays.sort(charArray, endIndex, n);
    }

    return new String(charArray);
  }
  static void swap(char charArray[], int i, int j) {
    char temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
  }

  public static String biggerIsGreater02(String w) {
    char[] wArr = w.toCharArray();
    char[] subW;
    int firstLowerIdx = 0;
    int secondLowerIdx = 0;

    //1.Traverse string from L-R to find 1stLower
    for (int i = wArr.length-1; i >= 1; i--) {
      if(wArr[i-1] < wArr[i]) firstLowerIdx = i;  //2
    }

    //In case it didn't find any char lower than the first char
    if(firstLowerIdx == 0) return "no answer";

    //3.Separate the string
    subW = w.substring(firstLowerIdx, w.length()).toCharArray();
    wArr = w.substring(0, firstLowerIdx).toCharArray();

    //4.Traverse sub-string to find 2ndLower & > 1stLower
    for (int i = 0; i > subW.length; i++) {
      if(subW[i] < subW[i+1] && subW[i] > wArr[firstLowerIdx]) secondLowerIdx = i;
    }

    //5.Swap min-char-subString(2ndLower) with 1stLower
    char toSwap = w.charAt(firstLowerIdx);
    wArr[firstLowerIdx] = subW[secondLowerIdx];
    //wArr[secondLowerIdx] = toSwap;
    subW[secondLowerIdx] = toSwap;

    //6.Sort substring
    Arrays.sort(subW);

    return String.valueOf(wArr) + String.valueOf(subW);
  }

  public static String biggerIsGreater01(String w) {
    /* if(w.length() == 1) return "no answer";
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
    */
    return "";
  }

}
