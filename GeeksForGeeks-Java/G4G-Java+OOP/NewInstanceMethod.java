/**
 * Creation of Object
 * Using new Instance
 */
class Geeks {

  // Declaring and initializing string
  String n = "GeeksForGeeks";

  // Main driver method
  public static void main(String[] args) {
    
      // Try block to check for exceptions
      try {
          // Correcting the class name to match "Geeks"
          Class<?> c = Class.forName("Geeks");
        
          // Creating an object of the main class using reflection
          Geeks o = (Geeks) c.getDeclaredConstructor().newInstance();
        
          // Print and display
          System.out.println(o.n);
      }
      catch (ClassNotFoundException e) {
          e.printStackTrace();
      }
      catch (InstantiationException e) {
          e.printStackTrace();
      }
      catch (IllegalAccessException e) {
          e.printStackTrace();
      }
      catch (NoSuchMethodException e) {
          e.printStackTrace();
      }
      catch (Exception e) {
          e.printStackTrace();
      }
  }
}

/*
 * Output:
 * 
 * GeeksForGeeks
 */