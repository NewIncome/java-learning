public class ContinueBreak {
  public static void main(String[] args) {
    int count = 0;

    while(count < 10) {

      if(count == 5) {
        count++;
        continue; // just jumps it. break; breaks the loop and ends it, 
      }
      System.out.print(count + "\t");

      count++;
    }//end while
  }//end main
}

