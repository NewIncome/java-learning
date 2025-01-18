import java.util.Scanner;

public class RepetitionFun {
  public static void main(String[] args) {

    /* while loop
    int count = 0;
    while(count < 10) {
      System.out.println(count);
      count++;
    }//end while
    */

    /* do-while loop
    int count2 = 0;
    do {
      System.out.println(count2);
      count2++;
    }
    while(count2 < 10);*/

    Scanner keyboard = new Scanner(System.in);
    int input;

    //priming read
    System.out.println("Enter a non-negative integer");
    System.out.println("Or negative to exit");
    input = keyboard.nextInt();

    while(input >= 0) {
      System.out.println(input);

      System.out.println("Enter a non-negative integer");
      System.out.println("Or negative to exit");
      input = keyboard.nextInt();
    }//end while

    System.out.println("Done!");

  }//end main
}
