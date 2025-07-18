public class GenericsDemo {
  public static void main(String[] args) {
    MyGenericsClass g1 = new MyGenericsClass();

    g1.setMyVar(6);
    g1.printValue();

    g1.setMyVar(6.1);
    g1.printValue();

    g1.setMyVar("Java rules");
    g1.printValue();
    System.out.println();

    // This is 'type-checking', to avoid unexpected errors in Generics
    MyGenericsClass<Integer> g2 = new MyGenericsClass();

    g2.setMyVar(8); // Any other type would give an error
    g2.printValue();
  }
}

class MyGenericsClass<T> { //T == 'type parameter'
  private T myVar;

  void setMyVar (T v) {
    myVar = v;
  }

  void printValue() {
    System.out.println("The value of myVar is " + myVar);
  }
}
