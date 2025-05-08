/* 
 * Java program to show that
 * if the static method is redefined by a derived
 * class, then it is not overriding, it is hiding
 */
class Parent {
  // Static method in base class
  // which will be hidden in subclass
  static void m1()
  {
      System.out.println("From parent "
                         + "static m1()");
  }
  // Non-static method which will
  // be overridden in derived class
  void m2()
  {
      System.out.println(
          "From parent "
          + "non - static(instance) m2() ");
  }
}

class Child extends Parent {
  // This method hides m1() in Parent
  static void m1()
  {
      System.out.println("From child static m1()");
  }

  // This method overrides m2() in Parent
  @Override public void m2()
  {
      System.out.println(
          "From child "
          + "non - static(instance) m2() ");
  }
}

// Driver class
class MethodHidingAndOverriding {
  public static void main(String[] args)
  {
      Parent child1 = new Child();
      Child child2 = new Child();
      Parent parent1 = new Parent();

      // here parents m1 called.
      // bcs static method can not overriden
      // Here the method
      child1.m1();
      child2.m1();
      parent1.m1();
      System.out.println();

      // Here overriding works
      // and Child's m2() is called
      child1.m2();
      child2.m2();
      parent1.m2();
      System.out.println();

      System.out.println("-- Class or Static methods:");
      Parent.m1();
      Child.m1();
  } 
}