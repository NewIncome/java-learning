import java.io.File;
import java.io.IOException;
import java.util.Timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CreateRenameDeleteFile {
  public static void main(String[] args) {
    File f1;
    File f2 = new File("myNewFile.txt");
    //call snippet to physically create the 1st file
    f1 = createTheFile("myFile.txt");

    //pause thread to see the file creating before renaming
    time1sV1(5000);

    //to rename the file
    f1.renameTo(f2);

    //pause time to see the renamed file before deletion
    time1sV1(5000);

    //to delete the 2nd file created just for the name
    f2.delete();

  }//end main

  public static File createTheFile(String path) {
    File file = new File(path);
    try {
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    return file;
  }//end createTheFile

  //code snippet to pause execution for one second
  public static void time1sV1(int milliseconds) {
    // but this Blocks the current thread 
    try {
      Thread.sleep(milliseconds); // Sleep for 1000 milliseconds (1 second)
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // For real app, it's better to use: 'Timer'(best for GUI) or 'ScheduledExecutorService'(good for concurrent tasks)
  }//end time1sV1

  /* not working correctly
  public static void time1sV2() {
    new Timer(1000, e -> {
      // Code to run after 1 second
      System.out.println("Timer test");
    }).start();
  }//end time1sV2
  */

  public static void time1sV3() {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    scheduler.schedule(() -> {
        // Code to run after 1 second
    }, 1, TimeUnit.SECONDS);
  }//end time1sV3
}
