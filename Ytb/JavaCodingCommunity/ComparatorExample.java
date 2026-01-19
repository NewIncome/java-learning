/**
 * Example of how to use the Comparator Interface
 * 
 * The Comparator Interface is directly tied to a helper class,
 * which defines how the sorting method will respond based on the
 * comparator() definition
 * 
 * Comparator needs a specific definition of how-to-compare your
 * specific / complex objects, based on a specific criteria
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class ComparatorExample {

  private int value;

  public ComparatorExample(int value) { this.value = value; }

  public int getValue() { return value; }


  @Override
  public String toString() { return String.valueOf(this.value); }

  public static void main(String[] args) {
    ComparatorExample comparatorExample1 = new ComparatorExample(10);
    ComparatorExample comparatorExample2 = new ComparatorExample(20);
    ComparatorExample comparatorExample3 = new ComparatorExample(15);

    ArrayList<ComparatorExample> arrayList = new ArrayList<>();
    arrayList.add(comparatorExample1);
    arrayList.add(comparatorExample2);
    arrayList.add(comparatorExample3);
    System.out.println("Printing array list: " + arrayList);

    // ascending
    arrayList.sort(new MyObjectComparatorAscending());  //we need to define how to c
    System.out.println("Printing ascending list...");
    System.out.println(arrayList);

    // descending
    arrayList.sort(new MyObjectComparatorDescending());
    System.out.println("Printing descending list...");
    System.out.println(arrayList);
  }

}


class MyObjectComparatorAscending implements Comparator<ComparatorExample> {
  @Override
  public int compare(ComparatorExample o1, ComparatorExample o2) {
    return Integer.compare(o1.getValue(), o2.getValue());
  }
}

class MyObjectComparatorDescending implements Comparator<ComparatorExample> {
  @Override
  public int compare(ComparatorExample o1, ComparatorExample o2) {
    return Integer.compare(o2.getValue(), o1.getValue());  //reversed, could also reverse with '-'
  }
}
