import java.util.Arrays;

/**
 * Marie invented a Time Machine and wants to test it by time-traveling
 * to visit Russia on the Day of the Programmer (the 256th day of the
 * year) during a year in the inclusive range from 1700 to 2700.
 * From 1700 to 1917, Russia's official calendar was the Julian
 * calendar; since 1919 they used the Gregorian calendar system.
 * The transition from the Julian to Gregorian calendar system occurred
 * in 1918, when the next day after January 31st was February 14th.
 * This means that in 1918, February 14th was the 32nd day of the year
 * in Russia.
 * 
 * In both calendar systems, February is the only month with a variable
 * amount of days; it has 29 days during a leap year, and 28 days during
 * all other years. In the Julian calendar, leap years are divisible by
 * 4; in the Gregorian calendar, leap years are either of the following:
 * • Divisible by 400.
 * • Divisible by 4 and not divisible by 100.
 * Given a year, y, find the date of the 256th day of that year
 * according to the official Russian calendar during that year.
 * Then print it in the format dd.mm.yyyy, where dd is the two-digit
 * day, mm is the two-digit month, and yyyy is y.
 * For example, the given year = 1984. 1984 is divisible by 4, so it is
 * a leap year. The 256th day of a leap year after 1918 is September 12,
 * so the answer is 12.09.1984.
 * 
 *  * • Example:
 *    y = 1984   // 12.09.1984
 * 
 * • Needs:
 *  ♦ Print the full date of Day of the Programmer during year y
 *    in the format dd.mm.yyyy
 * 
 * • Constraints
 *  ♦ 1700 \le y \le 2700
 *  ♦ leap year, February has 29 days
 *  ♦ common year, February has 28 days
 * 
 * • Test Cases ()
 *  ♦ y = 2017  // 13.09.2017
 *  ♦ y = 2016  // 12.09.2016
 *  ♦ y = 1800  // 12.09.1800
 *  ♦ y = 1918  // 26.09.1918
 * (8min base setup)
 */
/*
 * Pseudo-code
 * 1○ define if the year is a leap-year y/4. (> 1917 Gregorian)
 * 2○ define 2 arr vars for GregorianCalendarDays and JulianCalendarDays
 * 3○ declare an int sumDays and month variables
 * 4○ declare+initialize an int[] setCalendar var
 *    ◘ this depending if it's leap/common year, and if gregorian/julian
 * 5○ loop through the setCalendar until before the next month sum > 256
 * 6○ sum each arr/monthNum value
 * 7○ when it is, break
 * 8○ then substract the sumDays from 256
 * 9○ return String.format("$d.$d.$d", sumDays, month, y);  ||  int+"."+int+"."+int
 * (15min to understand and create p-c)
 */
public class DayOfTheProgrammer {
  public static void main(String[] args) {
    //Test Cases setup
    /* System.out.println(result(1984));
    System.out.println(result(2017));
    System.out.println(result(2016));
    System.out.println(result(1800)); */
    System.out.println(result(1918));
  }

  public static String result(int year) {
    //Code Solution
    int sumDays = 0;
    String monthNum = "";
    int[] calendar = setCalendar(year);

    for(int month = 0; month <= calendar.length; month++) {
      if ((sumDays + calendar[month]) < 256) {
        sumDays += calendar[month];
      } else {
        System.out.println("sumDays = " + sumDays + ", monthI: " + month + ", calendar[month] = " + calendar[month] + " , Year: " + Arrays.toString(calendar));
        monthNum = month<9 ? "0"+(month+1) : Integer.toString(month);
        break;
      }
    }

    System.out.printf("The answer for %.3f divided by %d is %.2f.\n", 5.45, 3, 5.45/3);

    System.out.printf("%2d.%2d.%2d\n", sumDays, Integer.parseInt(monthNum), year);
    System.out.println(String.format("\n%d.%d.%d", sumDays, Integer.parseInt(monthNum), year));

    return (256-sumDays) + "." + monthNum  + "." + year;
  }
  
  public static int[] setCalendar(int year) {
    final int[] LEAP_YEAR = {31,29,31,30,31,30,31,31,30,31,30,31};
    final int[] COMMON_YEAR = {31,28,31,30,31,30,31,31,30,31,30,31};
    final int[] SHIFT18Common = {31,15,31,30,31,30,31,31,30,31,30,31};
    
    if (year == 1918) return SHIFT18Common;

    //Check if it's gregorian or julian
    if (year < 1918) { //It's Julian
      if (year%4 == 0) {
        return LEAP_YEAR;
      }
    } else {           //It's Gregorian
      if ((year%400 == 0) || (year%4 == 0 && year%100 != 0)) {
        return LEAP_YEAR;
      }
    }

    return COMMON_YEAR;
  }//end setCalendar
}
