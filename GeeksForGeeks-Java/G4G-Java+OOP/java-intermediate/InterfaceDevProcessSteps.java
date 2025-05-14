/**
 * Implementation of interfaces - Level wise
 */
import java.io.*;
import java.lang.*;
import java.util.*;

// Level 1 – interfaces: It contains the service details
interface Bank {
    void deposit();
    void withdraw();
    void loan();
    void account();
}

// Level 2 – abstract classes: It contains partial implementation
abstract class Dev1 implements Bank {
  @Override
  public void deposit()
  {
    System.out.println("Your deposit Amount :" + 100);
  }
}

abstract class Dev2 extends Dev1 {
  @Override
  public void withdraw()
  {
    System.out.println("Your withdraw Amount :" + 50);
  }
}

// Level 3 – implementation classes: It contains all implementations
class Dev3 extends Dev2 {
  @Override
  public void loan() {}
  @Override
  public void account() {}
  //If either one of the above aren't implemented it will give a compile error
}

// Level 4 – Final Code / Main Method: It have access of all interfaces data
class InterfaceDevProcessSteps {
    public static void main(String[] args)
    {
        Dev3 d = new Dev3();
        //d.account();
        d.loan();
        d.deposit();
        d.withdraw();
    }
}