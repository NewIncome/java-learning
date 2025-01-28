/*
 * Intro to User-Defined methods
 */

public class MethodsDemo {
    public static void main(String[] args) {
        printHello();
        printNumber(10); //argument 10 is passed in
        int result = giveMe10();
        System.out.println(result);

        result = addThese(3, 5); //passed in 3 and 5 as arguments
        System.out.println(result);
    }//end main

    // ~~~~~ void, parameterless ~~~~~
    public static void printHello() { /* Header of the method */
        System.out.println("Hello there!"); /* { Body of the method } */
    }//end printHello

    // ~~~~~ void, parameterized ~~~~~ //void == doesn't return value, only computes something
    public static void printNumber(int a) {
        System.out.println("The number is " + a);
    }//end printNumber

    // ~~~~~ value-returning, parameterless ~~~~~
    public static int giveMe10() {
        return 10;
    }//end giveMe10

    // ~~~~~ value-returning, parameterized ~~~~~
    public static int addThese(int num1, int num2) {
        return num1 + num2;
    }//end addThese
}