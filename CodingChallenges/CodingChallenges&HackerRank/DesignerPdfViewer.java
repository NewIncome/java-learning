/**
 * When a contiguous block of text is selected in a PDF viewer, the selection is
 * highlighted with a blue rectangle. In this PDF viewer, each word is highlighted
 * independently. For example:  -abc- -def- -ghi-
 * There is a list of  character heights aligned by index to their letters. For
 * example, 'a' is at index  and 'z' is at index . There will also be a string.
 * Using the letter heights given, determine the area of the rectangle highlight
 * in  assuming all letters are  wide.
 * 
 * • Example:
 *  h = [1,3,1,3,1,4,1,3,2,5,5,5,5,1,1,5,5,1,5,2,5,5,5,5,5,5], word="torn"  //8
 *  The heights are t=2, o=1, r=1 and n=1. The tallest letter is 2 high and there
 *  are 4 letters. The hightlighted area will be 2*4=8mm^2 so the answer is 8.
 * 
 * • Return
 *  int: the size of the highlighted area  //tallestHeight * word.length
 * 
 * • TestCases
 *  ♦ h=[1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5], word="abc"   //9
 *  ♦ h=[1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,7], word="zaba"  //28
 */
/*
 * Pseudocode
 * ○ Define a maxHeight variable = Integer.MIN_VALUE;
 * ○ Loop through word.toCharArray()
 *  ◙ Compare the h[wordChar_value((int)'char' - 97)] (the post) against maxHeight,
 *    and add to maxHeight the bigger value
 * ○ return max * word.length
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesignerPdfViewer {
  public static void main(String[] args) {
    List<Integer> h1 = new ArrayList<>(Arrays.asList(1,3,1,3,1,4,1,3,2,5,5,5,5,1,1,5,5,1,5,2,5,5,5,5,5,5));
    List<Integer> h2 = new ArrayList<>(Arrays.asList(1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5));
    List<Integer> h3 = new ArrayList<>(Arrays.asList(1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,7));
    System.out.println(result(h1, "torn"));
    System.out.println(result(h2, "abc"));
    System.out.println(result(h3, "zaba"));
  }//end main

  public static int result(List<Integer> h, String word) {
    int maxHeight = Integer.MIN_VALUE;
    int i = 0;

    for(char letter : word.toCharArray()) {
      i = (int)letter - 97;  //to get the asccii value of the letter/character, a=97
      if(h.get(i) > maxHeight) maxHeight = h.get(i);
    }

    return maxHeight * word.length();
  }//end result
}