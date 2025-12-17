/**
 * Taum is planning to celebrate the birthday of his friend, Diksha. There
 * are two types of gifts that Diksha wants from Taum: one is black and the
 * other is white. To make her happy, Taum has to buy b black gifts and w
 * white gifts.
 * - The cost of each black gift is  units.
 * - The cost of every white gift is  units.
 * - The cost to convert a black gift into white gift or vice versa is  units.
 * Determine the minimum cost of Diksha's gifts.
 * • Input
 *  ♦ int b: the number of black gifts
 *  ♦ int w: the number of white gifts
 *  ♦ int bc: the cost of a black gift
 *  ♦ int wc: the cost of a white gift
 *  ♦ int z: the cost to convert one color gift to the other color
 * • Returns
 *  ♦ int: the minimum cost to purchase the gifts
 * • Constraints
 *  ♦ 1 <= t <= 10
 *  ♦ 0 <= b,w,bc,wc,z <= 10^9
 * • Example
 *  ♦ b=3, w=5, bc=3, wc=4, z=1    //29
 * • TestCases
 *  ♦ b=10, w=10, bc=1, wc=1, z=1    //20
 *  ♦ b=5, w=9, bc=2, wc=3, z=4    //37
 *  ♦ b=3, w=6, bc=9, wc=1, z=1    //12
 *  ♦ b=7, w=7, bc=4, wc=2, z=1    //35
 *  ♦ b=3, w=3, bc=1, wc=9, z=2    //12
 */
public class TaumAndBDay {

  public static void main(String[] args) {
    System.out.println(taumBday(3,5,3,4,1));
    System.out.println(taumBday(10,10,1,1,1));
    System.out.println(taumBday(5,9,2,3,4));
    System.out.println(taumBday(3,6,9,1,1));
    System.out.println(taumBday(7,7,4,2,1));
    System.out.println(taumBday(3,3,1,9,2));
  }

  public static long taumBday(int b, int w, int bc, int wc, int z) {  //passed 7/14
    //if(bc == wc) { return (b*bc) + (w*wc); }
    if(bc > (wc + z)) { return ((b+w) * wc) + (b*z); }  //is this the same?: (b*(wc+z)) + (w*wc)
    if(wc > (bc + z)) { return ((b+w) * bc) + (w*z); }

    return (b*bc) + (w*wc);
  }

}
