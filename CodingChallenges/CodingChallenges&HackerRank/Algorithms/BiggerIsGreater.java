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

  wWebpage:Nayuki.io
  1. Firstly, identify the longest suffix that is non-increasing. Better found from RtoL
  2. Identify pivot. Element immediately to the left
  3. Find rightmost successor to pivot in the suffix.  ...Assume(should be) suffix is sorted  Descending sorted
  4. Swap rightmost-successor with pivot
  5. Reverse the suffix (ascending sort)
 */
import java.util.Arrays;
import java.util.stream.IntStream;


public class BiggerIsGreater {

  public static void main(String[] args) {
    /* for (String s : Arrays.asList(
      "ab","bb","hefg","dhck","dkhc","lmno","dcba","dcbb","abdc","abcd"))
    {
      System.out.println(biggerIsGreater(s));
    } */
    System.out.println(biggerIsGreater("dkhc"));
    System.out.println(biggerIsGreater("abdc"));
  }


  public static String biggerIsGreater(String w) {  //wWebpage
    char[] W = w.toCharArray();
    int suffixStart = 0;
    int pivot = 0;
    int rightMSuccessor = 0;

    //1.Identify non-inc suffix
    for (int i = W.length-1; i > 0; i--) {  //from RtoL
      if(W[i-1] < W[i]) {
        suffixStart = i;

        //2.Identify pivot
        pivot = i-1;
        break;
      }
    }

    //end, there was no non-inc suffix available
    if(suffixStart == 0) return "no answer";

    //3.Identify righmost-successor to pivot
    //rightMSuccessor = suffixStart;
    for (int i = W.length-1; i >= suffixStart; i--) {
      //System.out.println("i: " + i);
      if(W[i-1] <= W[i] && W[i] > W[pivot]) rightMSuccessor = i;
    }

    //4.Swap
    char temp = W[rightMSuccessor];
    W[rightMSuccessor] = W[pivot];
    W[pivot] = temp;
    //System.out.println("pivot: " + pivot + ", suffixStart: " + suffixStart + ", rightMSuccessor: " + rightMSuccessor);
    
    //5.Reverse suffix; sort
    Arrays.sort(W, suffixStart, W.length);

    return String.valueOf(W);
  }

  public static String biggerIsGreaterWVid(String w) { //Works
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

      for (int i = endIndex + 1; i < n; i++) {
        if(charArray[i] > firstSmallChar && charArray[i] < charArray[nextSmallChar]) {
          nextSmallChar = i;
        }
      }
      System.out.println("firstSmallChar(pivot): " + (char)firstSmallChar + ", endIndex(suffixStart): " + endIndex + ", nextSmallChar: " + nextSmallChar);

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
