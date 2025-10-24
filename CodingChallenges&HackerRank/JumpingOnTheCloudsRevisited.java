/**
 * A child is playing a cloud hopping game. In this game, there are
 * sequentially numbered clouds that can be thunderheads or cumulus
 * clouds. The character must jump from cloud to cloud until it reaches
 * the start again.
 * There is an array of clouds, c and an energy level e=100. The
 * character starts from c[0] and uses 1 unit of energy to make a jump
 * of size k to cloud c[(i+k)%n]. If it lands on a thundercloud, c[i]=1,
 * its energy (e) decreases by 2 additional units. The game ends when
 * the character lands back on cloud 0.
 * Given the values of n, k, and the configuration of the clouds as an
 * array c, determine the final value of  after the game ends.
 * Note: Recall that % refers to the modulo operation. In this case,
 * it serves to make the route circular. If the character is at c[n-1]
 * and jumps 1, it will arrive at c[0].
 * 
 * • Input
 *  ♦ int c[n]: the cloud types along the path
 *  ♦ int k: the length of one jump
 * 
 * • Returns
 *  ♦ int: the energy level remaining.
 * 
 * • Example
 *  ♦ c = [0,0,1,0], k = 2   //96 ; it passes by indices 0->2->0
 * 
 * • Constraints
 *  ♦ 2 <= n <= 25
 *  ♦ 1 <= k <= n
 *  ♦ n % k = 0
 *  ♦ c[i] ∈ {0,1}
 * 
 * • Test Cases                           i:  0 2 4 6 0
 *  ♦ c = [0,0,1,0,0,1,1,0], k = 2    //92 ; -1-3-1-3-1
 *  ♦ c = [1,1,1,0,1,1,0,0,0,0], k = 3   //80
 */
public class JumpingOnTheCloudsRevisited {

  public static void main(String[] args) {
    System.out.println(jumpingOnClouds(new int[]{0,0,1,0}, 2));
    System.out.println(jumpingOnClouds(new int[]{0,0,1,0,0,1,1,0}, 2));
    System.out.println(jumpingOnClouds(new int[]{1,1,1,0,1,1,0,0,0,0}, 3));
  }//end main

  static int jumpingOnClouds(int[] c, int k) {
    int e = 100;
    int i = 0;
    final int n = c.length;
    while(i<n) {
      e--;  // 1 energy less in every jump
      if(c[i] == 1) e-=2;
      i = (i+k) % n;
      if(i == 0) break;
      //System.out.println("i: " + i + ", e: " + e + ", i+k%n: " + (i+k % n));
    }

    return e;
  }//end jumpingOnClouds

}
