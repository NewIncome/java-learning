// Java Program to show the use of
// Instance Variables
import java.io.*;

class GFG {

    // Constructor of this class

    // Declared Instance Variable
    public String geek;
    public int i;
    public Integer I;
    public GFG() // also can be not-public
    {
        // Default Constructor
        // initializing Instance Variable
        this.geek = "Shubham Jain";
    }

    // Declared static variable
    // Can be declared inside the constructor
    public static String geek02 = "Shubham Jain 02";

    // Main Method
    public static void main(String[] args)
    {
        // Object Creation
        GFG name = new GFG();

        // Displaying O/P
        System.out.println("Geek name is: " + name.geek);
        System.out.println("Default value for int is "+ name.i);
      
        // toString() called internally
        System.out.println("Default value for Integer is "+ name.I);

        // static variable in use
        System.out.println("2nd Geek Name is : " + GFG.geek02);
    }
}

/*
 * Output:
 *  Geek name is: Shubham Jain
 *  Default value for int is 0
 *  Default value for Integer is null
 *  2nd Geek name is: Shubham Jain 02
 */