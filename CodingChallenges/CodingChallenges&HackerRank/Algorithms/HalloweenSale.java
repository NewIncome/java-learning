/*
    How many games can you buy during the Halloween Sale?

    • TestCase
     + p,d,m,s = 20,3,6,80    //6
     + p,d,m,s = 20,3,6,85    //7
     + p,d,m,s = 100,19,1,180 //1

    Pseudocode
    ○ 1st purchase costs 'p'
    ○ 2nd+ purchase costs 'p-d'
      + if price(p-d) <= m
    ○ while s >= m                //(s) starting budget
 */

public class HalloweenSale {

  public static int howManyGames(int p, int d, int m, int s) {
    int saleCount = 0;

    while(s > 0) {
      if(saleCount == 0)
        s -= p;
      else if((p-d) > m) {
        p -= d;
        s -= p;
      }
      else
        s -= m;

      if(s < 0) break;
      saleCount += 1;
    }

    System.out.println("starting budget(end): " + s);
    return saleCount;
  }


  public static void main(String[] args) {
    System.out.println(howManyGames(100,19,1,180));
  }

}
