import java.util.Scanner;

public class Enums {

  public static void main(String[] args) {
    Day day = Day.FRIDAY;
    System.out.println("day: " + day);
    System.out.println("dayNum: " + day.getDayNum());

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter day of the week: ");
    String response = scanner.nextLine().toUpperCase();
    
    try {
      day = Day.valueOf(response);  //Here alone is where we would need the try block, here is where the error lies

      switch (day) {  //Enhanced switch: using -> functions; instead of case "": ..; break; etc
        //MONDAY is not a string, this is a benefit of Enums
        case MONDAY,
             TUESDAY,
             WEDNESDAY,
             THURSDAY,
             FRIDAY -> System.out.println("It is a weekday");
        case SATURDAY, SUNDAY -> System.out.println("It is the weekend!");
        //could also use numbers, but it has 0 readability
      }
    } catch (Exception e) {
      System.out.println("Please enter a valid day");
    }

    scanner.close();
  }//end main

}

enum Day {
  SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

  private final int dayNum;

  Day(int dayNum) { this.dayNum = dayNum; }

  public int getDayNum() { return dayNum; }
}
/* Enums = (Enumeration) A special kind of class that
 *         represents a fixed set of constants.
 *        • They improve code readability and reliability.
 *        • More efficient with switches than Strings.
 */
