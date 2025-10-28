import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamReducePractice {
  public static void main(String[] args) {
  /* Methods mainly from Basant's code
   * https://github.com/Java-Techie-jt/java8/blob/master/map_reduce/MapReduceExample.java
   */
  /* List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

  List<String> words = Arrays.asList("corejava", "spring", "hibernate");

  int sum = 0;
  for (int no : numbers) {
      sum = sum + no;
  }
  System.out.println(sum);

  int sum1 = numbers.stream().mapToInt(i -> i).sum();
  System.out.println(sum1);

  Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
  System.out.println(reduceSum);

  Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
  System.out.println(reduceSumWithMethodReference.get());

  Integer mulResult = numbers.stream().reduce(1, (a, b) -> a * b);
  System.out.println(mulResult);

  Integer maxvalue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
  System.out.println(maxvalue);

  Integer maxvalueWithMethodReference = numbers.stream().reduce(Integer::max).get();
  System.out.println(maxvalueWithMethodReference);


  String longestString = words.stream()
          .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
          .get();
  System.out.println(longestString);

  //get employee whose grade A
  //get salary
  double avgSalary = EmployeeDatabase.getEmployees().stream()
          .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
          .map(employee -> employee.getSalary())
          .mapToDouble(i -> i)
          .average().getAsDouble();

  System.out.println(avgSalary);

  double sumSalary = EmployeeDatabase.getEmployees().stream()
          .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
          .map(employee -> employee.getSalary())
          .mapToDouble(i -> i)
          .sum();
  System.out.println(sumSalary); */

  /* Now with Collectors.groupingBy(), show list-of-employees by grade */
  List<Employee> employees =  Stream.of(
              new Employee(101,"john","A",60000),
              new Employee(109,"peter","B",30000),
              new Employee(102,"mak","A",80000),
              new Employee(103,"kim","A",90000),
              new Employee(104,"json","C",15000))
              .collect(Collectors.toList());
  
  /* Approach #1:   with .collect(Collectors.groupingBy()
      group employees by grade */
  Map<String, List<Employee>> employeeMap1 = employees
                                .stream()
                                .collect(Collectors.groupingBy(Employee::getGrade));

  /* Approach #2:   with Custom Comparator
      group employees by grade And filter them by highestSalary */
  Comparator<Employee> compareBySalary = Comparator.comparing(Employee::getSalary);
  Map<String, Optional<Employee>> employeeMap2 = employees
                                .stream()
                                .collect(
                                  Collectors.groupingBy(
                                      Employee::getGrade,
                                      Collectors.reducing(BinaryOperator.maxBy(compareBySalary)))
                                );

  /* Approach #3:   with Collectors.collectingAndThen() 
      same... */
  Map<String, Employee> employeeMap3 = employees
                                .stream()
                                .collect(Collectors.groupingBy(
                                    Employee::getGrade,
                                    Collectors.collectingAndThen(
                                        BinaryOperator.maxBy(
                                            Comparator.comparingDouble(Employee::getSalary)
                                        ),
                                        Optional::get
                                      )
                                ));
  /* Error in Approach#3:
   *  error: method collectingAndThen in class Collectors cannot be applied to given types;
   *  
   *  required: Collector<T#1,A,R>,Function<R,RR>
   * found:    BinaryOperator<Employee>,Optional::get
   * reason: cannot infer type-variable(s) T#1,A,R,RR
   *   (argument mismatch; no instance(s) of type variable(s) T#2 exist so that BinaryOperator<T#2> conforms to Collector<T#1,A,R>)
   * where T#1,A,R,RR,T#2 are type-variables:
   *   T#1 extends Object declared in method <T#1,A,R,RR>collectingAndThen(Collector<T#1,A,R>,Function<R,RR>)
   *   A extends Object declared in method <T#1,A,R,RR>collectingAndThen(Collector<T#1,A,R>,Function<R,RR>)
   *   R extends Object declared in method <T#1,A,R,RR>collectingAndThen(Collector<T#1,A,R>,Function<R,RR>)
   *   RR extends Object declared in method <T#1,A,R,RR>collectingAndThen(Collector<T#1,A,R>,Function<R,RR>)
   *   T#2 extends Object declared in method <T#2>maxBy(Comparator<? super T#2>)
   */

  System.out.println(employeeMap1);
  System.out.println(employeeMap2);
  System.out.println(employeeMap3);
  }
}

class EmployeeDatabase {
    public static List<Employee> getEmployees(){
      return  Stream.of(new Employee(101,"john","A",60000),
              new Employee(109,"peter","B",30000),
              new Employee(102,"mak","A",80000),
              new Employee(103,"kim","A",90000),
              new Employee(104,"json","C",15000))
              .collect(Collectors.toList());
    }
}

class Employee {
  private int id;
  private String name;
  private String grade;
  private double salary;

  public Employee() {}

  public Employee(int id, String name, String grade, double salary) {
      this.id = id;
      this.name = name;
      this.grade = grade;
      this.salary = salary;
  }
  //getters
  public int getId() { return id; }
  public String getName() { return name; }
  public String getGrade() { return grade; }
  public double getSalary() { return salary; }
  public void setId(int id) { this.id = id; }
  public void setName(String name) { this.name = name; }
  public void setGrade(String grade) { this.grade = grade; }
  public void setSalary(double salary) { this.salary = salary; }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", grade=" + grade + ", salary=" + salary + "]";
  }
}