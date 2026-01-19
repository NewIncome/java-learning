/**
 * Example of how to use the Comparable Interface
 * 
 * The Comparable Interface is directly tied to our class
 * 
 * Comparable implements the class "NaturalOrdering"
 * • Once implemented Comparable, it will sort your objects in "Natural Order"
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class ComparableExample implements Comparable<ComparableExample>{

  private int value;

  public ComparableExample(int value) { this.value = value; }


  public int getValue() { return value; }

  @Override
  public String toString() { return String.valueOf(this.value); }

  @Override
  public int compareTo(ComparableExample other) {
    return Integer.compare(this.value, other.getValue());  // <, ==, > :: -1, 0, 1
    // this reverses the sorting:
    //return -Integer.compare(this.value, other.getValue());  // <, ==, > :: 1, 0, -1
  }

  
  public static void main(String[] args) {
    ComparableExample comparableExample1 = new ComparableExample(10);
    ComparableExample comparableExample2 = new ComparableExample(20);
    ComparableExample comparableExample3 = new ComparableExample(15);

    ComparableExample[] objects = {
      comparableExample1,
      comparableExample2,
      comparableExample3
    };

    ArrayList<ComparableExample> arrayList = new ArrayList<>(List.of(objects));

    System.out.println("Printing array: " + Arrays.toString(objects));
    System.out.println("Printing array list: " + arrayList);

    Arrays.sort(objects);
    Collections.sort(arrayList);
    System.out.println("sorted...");

    System.out.println("Printing array: " + Arrays.toString(objects));
    System.out.println("Printing array list: " + arrayList);
  }

}
