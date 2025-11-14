/**
 * Your local library needs your help! Given the expected and actual return dates
 * for a library book, create a program that calculates the fine (if any). The fee
 * structure is as follows:
 * 1. If the book is returned on or before the expected return date, no fine will
 *    be charged (i.e.: fine = 0).
 * 2. If the book is returned after the expected return day but still within the
 *    same calendar month and year as the expected return date,
 *    fine = 15 Hackos x (number of days late).
 * 3. If the book is returned after the expected return month but still within the
 *    same calendar year as the expected return date, the
 *    fine = 500 Hackos x (number of months late).
 * 4. If the book is returned after the calendar year in which it was expected, there
 *    is a fixed fine of 10000 Hackos.
 * Charges are based only on the least precise measure of lateness. For example,
 * whether a book is due January 1, 2017 or December 31, 2017, if it is returned
 * January 1, 2018, that is a year late and the fine would be 10,000 Hackos.
 * • Input
 *  ♦ d1,m1,y1, denoting the respective day, month, and year on which the book was returned
 *  ♦ d2,m2,y2, denoting the respective day, month, and year on which the book was DUE to be returned
 * • Returns
 *  ♦ int: the amount of the fine or 0 if there is none
 * • Constraints
 *  ♦ 1<= d1,d2 <=31
 *  ♦ 1<= m1,m2 <=12
 *  ♦ 1<= y1,y2 <=3000
 *  ♦ It is guaranteed that the dates will be valid Gregorian calendar dates
 * • Example
 *  ♦ d1,m1,y1 = 14,7,2018
 *    d2,m2,y2 = 5,7,2018   //14-5=9, 9*15=135, 135 Hackos
 * • TestCase
 *  ♦ d1,m1,y1,d2,m2,y2 = 9,6,2015, 6,6,2015   //45
 *  ♦ d1,m1,y1,d2,m2,y2 = 28,2,2015, 15,4,2015   //0
 */
/*
 * Pseudocode : case of nested if else statements
 * ○ Case1(1): no debt
 *  + if y1==y2 && m1==m2 && d2<=d1 then return 0;
 * ○ Case2(4): Debt over a year
 *  + if y2 > y1 then return 10000;
 * ○ Case3(2): debt within same month
 *  + if y1==y2
 *    + if m1==m2 then return (d2-d1)*15;
 * ○ Case4(3): debt within same year
 *    + else return (m2-m1)*500;
 * ○ return 0;
 */
public class LibraryFine {

  public static void main(String[] args) {
    System.out.println(libraryFine(14,7,2018,5,7,2018)); //135
    System.out.println(libraryFine(9,6,2015,6,6,2015));  //45
    System.out.println(libraryFine(28,2,2015,15,4,2015));  //0
  }

  public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

    if(y1==y2) {
      if(m1<m2) return 0;        //EdgeCase: Payed before the due-month
      else if(m1==m2) {
        if(d1<=d2) return 0;     //Case1: Payed before the due-day
        else return (d1-d2)*15;  //Case2: debt within same month
      }
    }

    if(y1 > y2) return 10000;    //Case4: Debt over a year
    
    if(y1==y2 && m1>m2) return (m1-m2)*500;  //Case3: debt within same year

    return 0;

  }

}
