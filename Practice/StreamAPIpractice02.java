import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//-Declarative- programming approach: to directly see the intention of the developer
public class StreamAPIpractice02 {
  public static void main(String[] args) {
    ArrayList<Business> businesses = new ArrayList<>();
    populateBusinesses(businesses);

    String s = businesses
          .stream()
          .filter(e -> e.getName().startsWith("A"))
          .flatMap(e -> e.getEmployees().stream())    //to get the employees of each business
          //.sorted()
          .filter(e -> e.getAge() >= 30)
          .map(Person::getName)
          .collect(Collectors.joining(","));  //to save the whole thing to a string

    System.out.println(s);
  }

  static void populateBusinesses(ArrayList<Business> businesses) {
    businesses.add(new Business("Google", new ArrayList<Person>() {{
      add(new Person("Lara", 35));
      add(new Person("Peter", 21));
    }} ));
    businesses.add(new Business("Apple", new ArrayList<Person>() {{
      add(new Person("Zach", 45));
      add(new Person("Karl", 50));
      add(new Person("Barbara", 17));
      add(new Person("Lois", 16));
    }} ));
    businesses.add(new Business("Apple", new ArrayList<Person>() {{
      add(new Person("Michael", 41));
      add(new Person("Jessica", 28));
      add(new Person("Laura", 13));
    }} ));
  }//end populateBusinesses

}



class Business {
  String name;
  List<Person> employees;
  public Business(String name, List<Person> employees) {
    this.name = name;
    this.employees = employees;
  }
  public String getName() { return name; }
  public List<Person> getEmployees() { return employees; }
  
}

/* class Person implements Comparable {
  String name;
  int age;

  //constructor
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  //getters
  public String getName() { return name; }
  public int getAge() { return age; }

  @Override
  public String toString() {
    return "(^_^)Person [name=" + name + ", age=" + age + "]";
  }

  @Override
  public int compareTo(Object o) {
    return getName().compareTo(((Person) o).getName());
  }
} */