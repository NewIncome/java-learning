/**
 * Class to practice the use of the 'super' keyword
 */

public class SuperPract {

  public static void main(String[] args) {

    // super = Refers to the parent class (subclass <- superclass)
    //         Used in constructors and method overriding
    //         Calls the parent constructor to initialize attributes

    Person person = new Person("Tom", "Riddle");
    Student student = new Student("Harry", "Potter", 3.25);
    Employee employee = new Employee("Rubeus", "Hagrid", 50_000);

    person.showcaseName();
    student.showGPA();
    employee.showSalary();
    
  }

}

class Person {
  String first;
  String last;

  Person(String first, String last) {
    this.first = first;
    this.last = last;
  }

  void showcaseName() { System.out.println(this.first + " " + this.last); }
}

class Student extends Person {
  double gpa;

  Student(String first, String last, double gpa) {
    super(first, last);
    this.gpa = gpa;
  }

  void showGPA() { System.out.println(this.first + "'s gpa is: " + this.gpa); }
}

class Employee extends Person {
  int salary;

  Employee(String first, String last, int salary) {
    super(first, last);
    this.salary = salary;
  }

  void showSalary() { System.out.println(this.first + "'s salary is $" + this.salary); }
}
