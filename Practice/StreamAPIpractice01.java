import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StreamAPIpractice01 {
  public static void main(String[] args) {

    personsExample();
    numbersExample();
    System.out.println();

  }//end main


/*->  // ===-- Example 03 --===  */
  public static void businessesExample() {

  }//end businessesExample


/*->  // ===-- Example 02 --===  */
  public static void numbersExample() {
    int[] numbers = {0,1,2,3,4,5,6,7,8,9};

    Arrays.stream(numbers).limit(5).forEach(System.out::println);
  }//end numbersExample

/*->  // ===-- Example 01 --===  */
  static void personsExample() {
    List<Person> persons = new ArrayList<>();
    populatePersons(persons);

    List<Person> minors = new ArrayList<>();

    //Imperative/classic programming approach. But less performant
    for(Person p : persons) {
      if(p.getAge() < 18) minors.add(p);
    }

    //Streams approach
    List<Person> minorsPerStream = persons
            .stream()   //opens the stream
            .filter(p -> p.getAge() < 18)   //intermediate(returns a stream) & tunnel operations
            .toList();  //closes the stream

    //minorsPerStream.forEach(System.out::println);  //different logging method
    System.out.println(minorsPerStream);

    // ===-- Example 03 --===
    persons.stream()
            .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))   // *
            .forEach(System.out::println);
    /* * that comparation can also be done prettier by class Perons implements Comparable
         then Overriding the compareTo method:  public int compareTo(Object o) {
                                                  return getName().compareTo(((Person) o).getName());
                                                }
         then just calling .sorted() empty */
  }//end numbersExample



  //default: package-private, so only accessible in the same package
  static void populatePersons(List<Person> persons) {
    persons.add(new Person("Lara", 35, 0));
    persons.add(new Person("Peter", 21, 0));
    persons.add(new Person("Zach", 45, 0));
    persons.add(new Person("Karl", 50, 0));
    persons.add(new Person("Barbara", 17, 0));
    persons.add(new Person("Lois", 16, 0));
  }
}//end populatePersons




class Person {
  String name;
  int age;
  int salary;

  //constructor
  public Person(String name, int age, int salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  //getters
  public String getName() { return name; }
  public int getAge() { return age; }
  public int getSalary() { return salary; }

  @Override
  public String toString() {
    return "(^_^)Person [name=" + name + ", age=" + age + "]";
  }
}