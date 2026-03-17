/*
    How many games can you buy during the Halloween Sale?

    • Example
     + p,d,m,s = 20,3,6,70    //5 ,  20,17,14,11,8
    • TestCase
     + p,d,m,s = 20,3,6,80    //6 ,  20,17,14,11,8,6
     + p,d,m,s = 20,3,6,85    //7 ,  20,17,14,11,8,6,6
     + p,d,m,s = 100,19,1,180 //1 ,  

    Pseudocode
    ○ 1st purchase costs 'p'
    ○ 2nd+ purchase costs 'p-d'
      + if price(p-d) <= m
    ○ while s >= m                //(s) starting budget

    >>> 2nd Try
    → 1st price = p   ;                   if(s < p) finish
    → 2nd+price = p-d ;  until(p <= m) ;  if(s < p-d) finish
    → 3rd+price = m   ;                   if(s < m) finish
 */

public class HalloweenSale {

  public static int howManyGames(int p, int d, int m, int s) {
    int saleCount = 0;

    while(s > 0) {
      if(saleCount == 0) {
        s -= p;
      } else if((p-d) > m) {  //must check 1st because: "until the cost becomes <= m"
        p -= d;
        s -= p;
      } else {
        s -= m;
      }

      if(s < 0) break;  //*
      saleCount += 1;
      //System.out.println("starting budget(end): " + s + ", p: " + p);
    }

    return saleCount;
  }


  public static void main(String[] args) {
    System.out.println(howManyGames(100,19,1,180));
  }

}
//* We add this break because sometimes the last substraction before s<0 would count
//  and we would have to do additional checks depending on the difference of value
//  between 'm', 'd', and 's'
//  And in some cases we want to add the sustraction that makes s == 0 also,
//  besides s < m; and s < p-d on very specific cases; and even possibly on s < p;
// break on (s < 0) covers them;