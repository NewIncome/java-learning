public class InterfacePract01 implements i1, i2 {
  public static void main(String[] args) {
    InterfacePract01 obj1 = new InterfacePract01();
    //i1.super.printInfo();  //Cannot use super in a static context
    obj1.abstractTest();
    obj1.printInfo();
  }

  public void testMethod1() {
    i1.super.printInfo();  //Outside of a static scope you 'can' do this
    //In a static scope, ie. main() you can't use "super" like that
    System.out.println(i1.super.toString());
  }

  @Override
  public void abstractTest() {
    System.out.println("Overriden abstract method abstractTest");
  }
}


interface i1 {
  void abstractTest();
  default void printInfo() { System.out.println("Interface i1 was called"); }
}

/* Cannot implement 2 classes with methods with the same method signature.
   that makes those Interfaces incompatible */
interface i2 {
  //void abstractTest();
  //default void printInfo() { System.out.println("Interface i2 was called"); }
}
