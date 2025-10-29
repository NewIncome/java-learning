import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class StreamAPIpractice03 {

  public static void main(String[] args) {

    /* Single/Sequential Stream */
    IntStream
      .rangeClosed(1, 10)
      .forEach(t -> System.out.println(Thread.currentThread().getName() +" "+ t));
      //Thread: main

      System.out.println("========== ==========");

    /* Parallel Stream */
    IntStream
      .rangeClosed(1, 10)
      .parallel()
      .forEach(t -> System.out.println(Thread.currentThread().getName() +" "+ t));
    //Thread: ForkJoinPool.commonPool-worker-2

  }

}
