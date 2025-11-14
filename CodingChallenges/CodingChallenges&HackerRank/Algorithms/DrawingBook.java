/**
 * A teacher asks the class to open their books to a page number. A
 * student can either start turning pages from the front of the book or
 * from the back of the book. They always turn pages one at a time. When
 * they open the book, page 1 is always on the right side.
 * When they flip page 1, they see pages 2 and 3. Each page except the
 * last page will always be printed on both sides. The last page may only
 * be printed on the front, given the length of the book. If the book is
 * n pages long, and a student wants to turn to page p, what is the minimum
 * number of pages to turn? They can start at the beginning or the end of
 * the book.
 * 
 * Given n and p, find and print the minimum number of pages that must be
 * turned in order to arrive at page p.
 * 
 * • Example:
 *  n = 5, p = 3   // 1 #1page needs to be flipped, either from front or back
 * [0,1] > [2,3] > [4,5]
 * 
 * • Needs_return:
 *  ♦ int: the minimum number of pages to turn (can be from front or back of the book)
 * 
 * • Constraints
 *  ♦ 1 <= n <= 10^5
 *  ♦ 1 <= p <= n
 * 
 * • Test Cases ()
 *  ♦ n = 6, p = 2   // 1(2) ; [0,1] > [2,3] > [4,5] > [6,0]  //f:1,b:2
 *  ♦ n = 5, p = 4   // 0(2) ; [0,1] > [2,3] > [4,5]          //f:2,b:0
 *  ♦ n = 10, p = 8   // 1(4) ; [0,1] > [2,3] > [4,5] > [6,7] > [8,9] > [10,0]   //f:4,b:1
 *  ♦ n = 10, p = 7   // 2(3) ; [0,1] > [2,3] > [4,5] > [6,7] > [8,9] > [10,0]   //f:3,b:2
 *  ♦ n = 6, p = 5   // 1(2) ; [0,1] > [2,3] > [4,5] > [6,0]  //f:2,b:1
 * (18min read&setup)
 */
/*
 * Pseudo-code
 * 
 */
public class DrawingBook {

  public static void main(String[] args) {
    System.out.println(pageCountVidSolV2(5,3)); //1
    System.out.println(pageCountVidSolV2(6,2)); //1
    System.out.println(pageCountVidSolV2(5,4)); //0
    System.out.println(pageCountVidSolV2(10,8)); //1
    System.out.println(pageCountVidSolV2(10,7)); //2
    System.out.println(pageCountVidSolV2(6,5)); //1
  }//end main
  
  public static int pageCountOpt1(int n, int p) {
    int pC;
    if (n%2 == 0) {
      pC = (int)((float)n / 2.0) / p;
    } else {
      pC = (int)(((float)n / 2.0) + 0.5) / p;
    }
    return pC;
  }//end pageCountOpt1
  //((35t)18 min 1st failed solution intent)

  public static int pageCountOpt2(int n, int p) {
    int frontToBack = (int)(p / 2);
    int backToFront = (int)Math.ceil((n - p) / 2);

    return Math.min(frontToBack, backToFront);
  }//end pageCountOpt2 [✔]
  //((60t)25 min 2st failed solution intent(only one TC failed p=5))

  public static int pageCountVidSol(int n, int p) {
    return Math.min((p / 2), ((n / 2) - (p / 2)));
  }//end pageCountVidSol

  public static int pageCountVidSolV2(int n, int p) {
    int left = p / 2;
    n = n%2 == 0 ? n+1 : n; //change it to odd
    int right = (n - p) / 2;
    return Math.min(left, right);
  }//end pageCountVidSolV2 [✔]

}
