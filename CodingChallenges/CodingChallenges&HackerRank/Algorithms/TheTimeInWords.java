/**
 * The Time in Words
 * 
 * Given the time in numerals we may convert it into words, as shown below:
 *   5:00 -→ five o' clock
 *   5:01 -→ one minute past five
 *   5:10 -→ ten minutes past five
 *   5:15 -→ quarter past five
 *   5:28 -→ twenty eight minutes past five
 *   5:30 -→ half past five
 *   5:40 -→ twenty minutes to six
 *   5:45 -→ quarter to six
 *   5:47 -→ thirteen minutes to six
 * At minutes=0, use o' clock. For 1<=minutes<=30, use past, and for 30<minutes
 * use to. Note the space between the apostrophe and clock in o' clock. Write a
 * program which prints the time in words for the input given in the format described.
 * 
 * • Constraints
 *   + 1 <= h <= 12
 *   + 0 <= m < 60
 */
/*
  Pseudocode
  ○ 1. create a enum class for the numbers in text; or better, an ArrayList
  ○ 2. create a switch for fixed cases:
    + minute: == 0, 15, 30, 45
    + display respectively "five o' clock", "quarter past", "half past", "quarter to"
  ○ 3. create an if-else cases for ranges:
    + 0<minute<30 || 30<minute<59
    + special inner if for 1, or use a variable with: String min = min == 1 ? "minute" : "minutes";
    + display respectively "${minutes} minutes past ${hour}"
 */
/* *** Can't use enum becaus
        1st- values must be capitalized
        2nd- for the amount of values, it overcomplicates it's use vs using a List */
import java.util.Arrays;
import java.util.List;


public class TheTimeInWords {

  private static final List<String> NUMBER_WORDS = Arrays.asList("zero","one",
  "two","three","four","five","six","seven","eight","nine","ten","eleven","twelve",
  "thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
  "twenty one","twenty two","twenty three","twenty four","twenty five","twenty six",
  "twenty seven","twenty eight","twenty nine","thirty","thirty one","thirty two",
  "thirty three","thirty four","thirty five","thirty six","thirty seven","thirty eight",
  "thirty nine","forty","forty one","forty two","forty three","forty four","forty five",
  "forty six","forty seven","forty eight","forty nine","fifty","fifty one","fifty two",
  "fifty three","fifty four","fifty five","fifty six","fifty seven","fifty eight",
  "fifty nine");

  public static String timeInWords(int h, int m) {
    switch(m) {
      case 0:
        return NUMBER_WORDS.get(h) + " o' clock";
      case 15:
        return "quarter past " + NUMBER_WORDS.get(h);
      case 30:
        return "half past " + NUMBER_WORDS.get(h);
      case 45:
        return "quarter to " + NUMBER_WORDS.get(h + 1);
    }

    if(m == 1)
      return NUMBER_WORDS.get(m) + " minute past " + NUMBER_WORDS.get(h);
    else if(m > 1 && m < 30)
      return NUMBER_WORDS.get(m) + " minutes past " + NUMBER_WORDS.get(h);
    else //it's 30<m<59 . Assuming it wil never be a number greater than 59
      return NUMBER_WORDS.get(60 - m) + " minutes to " + NUMBER_WORDS.get(h + 1);
  }

  // Demo
  public static void main(String[] args) {
  }
  
}
