import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CopyTest {

  public static void main(String[] args) {

    /* Shallow Copy of a List of Strings(Primitive wraps) */
    List<String> original1 = new ArrayList<>(Arrays.asList("apple", "banana"));
    List<String> copy1 = new ArrayList<>(original1);  // Shallow copy1
    System.out.println(original1); // [apple, banana]
    System.out.println(copy1); System.out.println();
    //Make a change to the copy1
    copy1.set(0, "orange");   // Is OK, modifies copy1 only
    System.out.println(original1);  // [apple, banana]
    System.out.println(copy1);      // [orange, banana]  ← different object!
    System.out.println();

    /* Shallow Copy of a List of Lists */
    List<List<String>> original2 = new ArrayList<>();
    original2.add(new ArrayList<>(Arrays.asList("x", "y")));
    List<List<String>> copy2 = new ArrayList<>(original2);
    System.out.println(original2);
    System.out.println(copy2); System.out.println();
    //Make a change to the copy2
    copy2.get(0).add("z");               // Modify the INNER list
    System.out.println(original2.get(0));  //→ ["x", "y", "z"]  ← same object!
    System.out.println(copy2.get(0));      //→ ["x", "y", "z"]  ← same object!
    System.out.println();


    /* Example with a List of Cars, Shallow vs Deep Copy */
    copyCars1();
    /* Example with simple Cars, Shallow vs Deep Copy */
    copyCars2();
  }

  /* Example with a List of Cars, Shallow vs Deep Copy */
  public static void copyCars1() {
    List<Car> original = new ArrayList<>();
    original.add(new Car("Toyota", 2020, 25_000, "white"));
    original.add(new Car("Honda",  2022, 28_500, "black"));
    //Create Shallow and Deep copies
    List<Car> shallowCopy = new ArrayList<>(original);
    List<Car> deepCopy = original.stream()
      /* Options to create many objects for .map() method */
            //.map(c -> new Car(c.model, c.year, c.price, c.color))
            //.map(Car::copy)    //reference to Static method
            //.map(Car::copies)  //reference to Instance method
            .map(Car::new)      //needs an empty Constructor
            .collect(Collectors.toList());
    // Mutate the shallow copy
    shallowCopy.get(0).setPrice(99_999);
    shallowCopy.get(0).setColor("red");
    //Test Mutation
    System.out.println("Original list : " + original);
    System.out.println("Shallow copy  : " + shallowCopy);
    System.out.println("Deep copy     : " + deepCopy);
    System.out.println();
  }

  /* Example with simple Cars, Shallow vs Deep Copy */
  public static void copyCars2() {
    Car original = new Car("Tesla", 2023, 60_000, "black");
    // Shallow copy (just reference)
    Car shallowCopy = original;  // SAME object!
    // Deep copy (new object)
    Car deepCopy = new Car(original.model, original.year, original.price, original.color);
    //Test Mutation
    shallowCopy.setPrice(1_000_000);
    shallowCopy.setColor("Orange");
    System.out.println("Original     : " + original); // Tesla(2023, $1000000.0)  ← CHANGED!
    System.out.println("Shallow copy : " + shallowCopy);
    System.out.println("DeepCopy     : " + deepCopy); // Tesla(2023, $60000.0)     ← Safe!
    System.out.println();
  }

}


class Car {
    String model;
    int year;
    double price;
    String color;

    Car(String model, int year, double price, String color) {
        this.model = model;
        this.year  = year;
        this.price = price;
        this.color = color;
    }

    //for Car::new empty constructor method reference. Just like copy()
    Car(Car car) {
      this.model = car.model;
      this.year  = car.year;
      this.price = car.price;
      this.color = car.color;
    }
    // for Static Method Reference (Car::copy)
    static Car copy(Car car) {
      return new Car(car.model, car.year, car.price, car.color);
    }
    //for Instance method reference (Car Toyota::copys)
    Car copies() {
      return new Car(this.model, this.year, this.price, this.color);
    }

    void setPrice(double price) { this.price = price; }
    
    void setColor(String color) { this.color = color; }

    @Override
    public String toString() { return model + "(" + color + ", " + year + ", $" + price + ")"; }
}
