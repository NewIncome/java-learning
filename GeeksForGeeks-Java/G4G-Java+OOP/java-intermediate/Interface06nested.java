/* 
 * Nested Interfaces
 * Working of interface inside a class
 */
/*=====================================
 * EXAMPLE #1
 */
// Parent Class
class Parent {
  
  	// Nested Interface
    interface Test {
        void show();
    }
}

// Child Class
class Child implements Parent.Test {
    public void show()
    {
        System.out.println("show() method of Interface#1, Parent_class.Test_interface");
    }
}
/*===================================== */


class Interface06nested 
{
  /*=====================================
   * EXAMPLE #2
   */
  public interface NestedInterface { 
    public void nestedMethod();
  /* If both the interface and the method are public,
   * they can both be accessed the same way, but
   * if they are outside the class that has the 'public main'
   * method, the interface has to be in a separate file
   */
  }
  /*===================================== */

  public static void main(String[] args)
  {
    // ==============================
    // EXAMPLE #1

    // instance of Parent class
    // with Nested Interface
    Parent.Test obj;
  
    // Instance of Child class
    Child t = new Child();
    
    obj = t;
    obj.show();
    extraSpace();
    // ==============================

    // ==============================
    // EXAMPLE #2
    // Implement nested interface
    NestedInterface nested = new NestedInterface() {
        public void nestedMethod()
        {
            System.out.println(
                "Hello from nested interface! Interface#2");
        }
    };

    // Call nested interface method
    nested.nestedMethod();
    // ==============================
  }

  public static void extraSpace() {
    System.out.println();
  }
}
