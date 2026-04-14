/**
 * Little Bobby loves chocolate. He frequently goes to his favorite 5&10 store,
 * Penny Auntie, to buy them. They are having a promotion at Penny Auntie.
 * If Bobby saves enough wrappers, he can turn them in for a free chocolate.
 * Example:
 * He has 15 to spend, bars cost 3, and he can turn in 2 wrappers to receive another
 * bar. Initially, he buys 5 bars and has 5 wrappers after eating them. He turns in 4
 * of them, leaving him with 1, for 2 more bars. After eating those two, he has 3
 * wrappers, turns in 2 leaving him with 1 wrapper and his new bar. Once he eats that
 * one, he has 2 wrappers and turns them in for another bar. After eating that one, he
 * only has 1 wrapper, and his feast ends. Overall, he has eaten 5+2+1+1 = 9 bars.
 * • Input
 *  ◙ int n: Bobby's initial amount of money
 *  ◙ int c: the cost of a chocolate bar
 *  ◙ int m: the number of wrappers he can turn in for a free bar
 * • Returns
 *  ◙ int: the number of chocolates Bobby can eat after taking full advantage of the promotion
 * • Constraints
 *  ◙ 1 <= t <= 1000
 *  ◙ 2 <= n <= 10^5
 *  ◙ 1 <= c <= n
 *  ◙ 2 <= m <= n
 * • TestCases
 *  ◙ 10 2 5  //6
 *  ◙ 12 4 4  //3
 *  ◙ 6 2 2   //5
 */
/*
  Pseudocode
  0. Variables: int totalBars, wrappers, exchangableBars
  1. Get amount of purchaseable bars, totalBars = n / c (floor)
  2. Store the 1st amount of wrappers. wrappers = totalBars
  3. Exchange wrappers for bars
    3.1. get amount of exchangeable bars. exchangableBars = wrappers / m (floor)
    3.2. add echangeableBars to totalBars.
    3.3. substract wrappers. wrappers -= exchangableBars * m
    3.4. add to wrappers, the exchanged Bars
    3.5. reset exhangeable bars.
  4. Do step 3 until wrappers < m
  5. return totalBars
 */
public class ChocolateFeast {

    public static int chocolateFeast(int n, int c, int m) {
        // -Pseudocode-
        //0. Variables: int totalBars, wrappers, exchangableBars
        //1. Get amount of purchaseable bars, totalBars = n / c (floor)
        //2. Store the 1st amount of wrappers. wrappers = totalBars
        //3. Exchange wrappers for bars
            //3.1. get amount of exchangeable bars. exchangableBars = wrappers / m (floor)
            //3.2. add echangeableBars to totalBars.
            //3.3. substract wrappers. wrappers -= exchangableBars * m
            //3.4. add to wrappers, the exchanged Bars
            //3.5. reset exhangeable bars.
        //4. Do step 3 until wrappers < m
        //5. return totalBars
        
        // Step 0
        int totalBars = 0, wrappers, exchangedBars;
        
        // Step 1 & 2
        totalBars = (int) Math.floor(n / c);
        wrappers = totalBars;
        
        // Step 4
        while(wrappers >= m) {
            // Step 3, .1, .2, .3, .4
            exchangedBars = (int) Math.floor(wrappers / m);
            totalBars += exchangedBars;
            wrappers -= exchangedBars * m;
            wrappers += exchangedBars;
            exchangedBars = 0;
        }
        
        // Step 5
        return totalBars;
    }

}
