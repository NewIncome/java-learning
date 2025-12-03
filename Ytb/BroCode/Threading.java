import java.util.Scanner;

import javax.swing.plaf.multi.MultiButtonUI;

public class Threading {
  public static void main(String[] args) {

    // Threading = Allows a program to run multiple tasks simultaneously
    //             • Helps improve performance with time-consuming operations
    //               (File I/O, nretwork communications, or any background tasks)

    // How to create a Thread
    // Option 1. Extend the Thread class (simpler)
    // Option 2. Implement the Runnable interface (better)

    Scanner scanner = new Scanner(System.in);

    MyTimer myTimer = new MyTimer();
    Thread timedThread = new Thread(myTimer);   // creates a new thread from our runnableClass
    timedThread.setDaemon(true);  // so that this thread ends when the Main thread ends
    timedThread.start();

    System.out.println("You have 5 seconds to enter your name");
    System.out.print("Enter your name: ");
    String name = scanner.nextLine();
    System.out.println("Hello " + name);

    scanner.close();
  }// end main
}// end Threading

/* *** 2 things to take into account are:
    1. That if we create a normal timerThread and our Main-thread finishes,
     we'll still have to wait for the timerThread to finish for our program to end.
     Thus  timedThread.setDaemon(true);
    2. That if we have an IOscanner, and we create a timerThread to end,
     and don't terminate the program on timer end,
     the program will com back to the Main-thread and wait for userInput.
     Thus  System.exit(0);
 */

class MyTimer implements Runnable {

  @Override
  public void run() {

    for(int i=0; i<=5; i++) {

      // We need the try-catch block because dealing with threads is considered dangerous
      try {
        Thread.sleep(1000);   //Current-thread to sleep in milliseconds
      } catch(InterruptedException e) {
        System.out.println("Thread was interrupted");
      }

      if(i == 5) {
        System.out.println("Time's up"); // we "need an exit condition"...
        System.exit(0);   // Terminates the currently running Java Virtual Machine
        /* The argument serves as a status code;
           by convention, a nonzero status code indicates abnormal termination. */
      }

    }

  }

}
