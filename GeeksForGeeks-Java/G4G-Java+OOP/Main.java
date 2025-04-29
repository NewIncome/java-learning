import java.io.*;

class Student implements Serializable {
  private String name;

  public Student(String name) { this.name = name; }

  @Override public String toString() { return "Student: " + name; }
}

public class Main {
  public static void main(String[] args) {
    // Serialization
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(“student.ser”))) {
      out.writeObject(new Student("Alice"));

    } catch (IOException e) {
      e.printStackTrace();
    }
    // Deserialization
    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(“student.ser”))) {
      Student s = (Student) in.readObject();
      System.out.println(s); // Output: Student: Alice

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

// Note: The class must implement serializable.