public class ObjectInitializationOrder {

  public static void main(String[] args) {
    Parent p = new Child();
    System.out.println("============================");
    p = new Child();
  }

}

class Parent {
  static {  //First, Static blocks are executed when classes are uploaded into JVM
    //AND, only executed Once
    System.out.println("Static init block parent");
  }

  {         //Second, JVM initializes 'Parent' fields first. Init block and constructor
    System.out.println("Init block parent");
  }

  public Parent() {
    System.out.println("Parent constructor");
  }
}

class Child extends Parent {
  static {
    System.out.println("Static init block Child");
  }

  {         //Third, JVM initializes 'Child' fields. Init block and constructor  
    System.out.println("Init block Child");
  }

  public Child() {
    System.out.println("Child constructor");
  }
}
