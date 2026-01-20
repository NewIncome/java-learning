import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An English text needs to be encrypted using the following encryption scheme.
 * First, the spaces are removed from the text. Let L be the length of this text.
 * Then, characters are written into a grid, whose rows and columns have the
 * following constraints:
 * [√L] <= row <= column <= [√L], where [x] is floor function and [y] is ceil function
 * 
 * ۝ Input
 *  ۞ string s: a string to encrypt
 * ۝ Return
 *  ۞ string: the encrypted string
 * ۝ Constraints
 *  ۞ 1 <= length of s <= 81
 * 
 * ۝ Example
 *  ۞ s = if man was meant to stay on the ground god would have given us roots
 *    ֎ After removing spaces, the string is 54 characters long. √54 is between 7 and 8,
 *      so it is written in the form of a grid with 7 rows and 8 columns.
 *    ֎ ifmanwas
 *      meanttos
 *      tayonthe
 *      groundgo
 *      dwouldha
 *      vegivenu
 *      sroots
 *    ֎ The encoded message is obtained by displaying the characters of each column, with
 *      a space between column texts. The encoded message for the grid above is:
 *       "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau"
 *  ۞ Ensure that rows x columns >= L
 *  ۞ If multiple grids satisfy the above conditions, choose the one with the minimum area(rows x columns)
 * 
 * ۝ TestCases
 *  ۞ s = "haveaniceday"    //"hae and via ecy" , explanation: L=12, √12=3and4, 3rows&4columns
        have
        anic
        eday
 *  ۞ s = "feedthedog"    //"fto ehg ee dd" , explanation: L=10, √10=3and4, 3rows&4columns
 *      feed
        thed
        og
 *  ۞ s = "chillout"    //"clu hlt io" , explanation: L=12, √12=3and4, 3rows&4columns
        chi
        llo
        ut
 */ //۝ ۞ ֎
/*
  Pseudocode
  1۝ Vars. List<String> stringGrid; int L, rows, cols; String resultString
  2۝ Get the value of L = length of s
  3۝ Get the value of rows and cols: Math.sqrt(L) min rows, max cols
  4۝ Loop rows times
    ۞ add to StringGrid the split of the string(cols*i, cols*(i+1))
  5۝ doubleLoop to get the resulting string
    ۞ String += stringGrid[i][j]
    ۞ add the space after 2nd loop
 */
public class Encryption {

  public static void main(String[] args) {
    System.out.println(encryption("ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots")); System.out.println();
    System.out.println(encryption("haveaniceday")); System.out.println();  //"hae and via ecy"
    System.out.println(encryption("feedthedog")); System.out.println();  //"fto ehg ee dd"
    System.out.println(encryption("chillout"));   //"clu hlt io"
  }

  public static String encryption(String s) {
    List<String> stringGrid = new ArrayList<>();
    int L = s.length();
    int rows = (int)Math.floor(Math.sqrt(L));
    int cols = (int)Math.ceil(Math.sqrt(L));
    //List<String> resultString = new ArrayList<>(Collections.nCopies(rows, ""));
    String resultString = "";
    if(rows * cols < L) rows = cols;          //specific condition
    //System.out.println("L: " + L + ", rows: " + rows + ", cols: " + cols + ", " + s);

    //Fill the string Grid
    for (int i = 0; i < rows; i++) {
      int endIndex = cols*(i+1) <= L ? cols*(i+1) : L;
      stringGrid.add(s.substring((cols*i), (endIndex)));
      //System.out.println("i: " + i + ", stringGrid: " + stringGrid);
    }
    //System.out.println("stringGrid: " + stringGrid.toString());

    //Fill the resultString from the stringGrid
    for (int i = 0; i < cols; i++) {
      for (int j = 0; j < rows; j++) {
        if (i >= stringGrid.get(j).length()) break; //need to check length due to different string lengths
        resultString = resultString.concat(stringGrid.get(j).substring(i, i+1));
        //System.out.println("i: " + i + ", j: " + j + ", resultString1: " + resultString1);
      }
      resultString = resultString.concat(" ");
    }

    return resultString;
  }

}
