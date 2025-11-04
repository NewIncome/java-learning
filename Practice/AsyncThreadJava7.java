/*
 * Program to print even and odd numbers using 2 threads
 * with Java 7
 */
public class AsyncThreadJava7 implements Runnable {

  static int count = 1;
    Object object;

  public AsyncThreadJava7(Object object) {  //EvenAndOddPrinterBy2Threads
    this.object = object;
  }

  @Override
  public void run() {

    while (count <= 10) {
      if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
        synchronized (object) {
          System.out.println("Thread Name : " + Thread.currentThread().getName() + " value :" + count);
          count++;
          try {
            object.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
      if (count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
        synchronized (object) {
          System.out.println("Thread Name : " + Thread.currentThread().getName() + " value :" + count);
          count++;
          object.notify();
        }
      }

    }

  }

  public static void main(String[] args) {
    Object lock=new Object();
    Runnable r1=new AsyncThreadJava7(lock);
    Runnable r2=new AsyncThreadJava7(lock);
    new Thread(r1, "even").start();
    new Thread(r2, "odd").start();
  }

}
