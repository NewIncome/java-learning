/*
 * Program to print even and odd numbers using 2 threads
 * with Java 8
 */
import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class AsyncThreadJava8 {

  //Is the root of the class hierarchy
  private static Object object = new Object();

  /* All F.I. in Java8:  Function, Predicate, Consumer, Supplier */
  //Functional interface, for a "boolean-valued function" of one int-valued argument.
  private static IntPredicate evenCondition = e -> (e % 2) == 0;
  private static IntPredicate oddCondition = e -> (e % 2) != 0;   //FUNTIONAL INTERFACE

  public static void main(String[] args) throws InterruptedException {

    //create 2 thread objects
    CompletableFuture
      .runAsync(() -> AsyncThreadJava8.printNumber(oddCondition));    //LAMBDA
    CompletableFuture
      .runAsync(() -> AsyncThreadJava8.printNumber(evenCondition));
    Thread.sleep(1000);
    
  }//end main


  public static void printNumber(IntPredicate condition) {
    IntStream
      .rangeClosed(1, 10)
      .filter(condition)                    //STREAM PIPELINE
      .forEach(AsyncThreadJava8::execute);  //METHOD REFERENCE from this class
  }

  public static void execute(int n) {
    synchronized (object) {
      try {
        System.out.println(Thread.currentThread().getName() + " " + n);
        object.notify();
        object.wait();
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }
    }
  }//end execute

}
