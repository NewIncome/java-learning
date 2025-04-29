/**
 * Creation of Object
 * Using clone() method
 */

// Main class
// Implementing Cloneable interface
class Geeks implements Cloneable {

  // Method 1
  @Override
  protected Object clone()
      throws CloneNotSupportedException
  {
      // Super() keyword refers to parent class
      return super.clone();
  }
  String name = "GeeksForGeeks";

  // Method 2
  // main driver method
  public static void main(String[] args)
  {
      Geeks o1 = new Geeks();
    
      // Try block to check for exceptions
      try {
          Geeks o2 = (Geeks)o1.clone();
          System.out.println(o2.name);
      }
      catch (CloneNotSupportedException e) {
          e.printStackTrace();
      }
  }
}

/*
 * Output:
 * 
 * GeeksForGeeks
 */