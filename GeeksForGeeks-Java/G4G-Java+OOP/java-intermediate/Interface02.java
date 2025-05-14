/**
 * Example of Java inheritance
 * + with different fields/attributes
 * + and using 'try-catch blocks'
 */
// Parent Class
class Person
{
    // Variables
    int id;
    String name;
  
    // Java Methods
    void set_Person(int id, String name) {
        try {
            this.id = id;
            this.name = name;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
  
    void display_Person() {
        System.out.println("Person-id: " + id + "\nname: " + name + "\n");
    }
}

// Child Class
class Employee1 extends Person
{
    int salary;
    String designation;
  
    void set_Employee(int id, String name, String designation, int salary)
    {
        try {
            set_Person(id, name);
            this.designation = designation;
            this.salary = salary;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
  
    void display_Emp()
    {
        display_Person();
        System.out.println("Employee-designation: " + designation + "\nsalary: " + salary);
    }
  
    // Main function can also be here
}

public class Interface02 {
  // Main function
    public static void main(String args[])
    {
        Employee1 e1 = new Employee1();
        e1.set_Employee(1001, "Manjeet", "AP", 20000);
        e1.display_Emp();
        System.out.println();

        Person p1 = new Person();
        p1.set_Person(78, "Jack");
        p1.display_Person();
    }
}
