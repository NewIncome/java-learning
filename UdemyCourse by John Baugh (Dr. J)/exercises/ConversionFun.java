/**
 * Documentation comment:
 *  ConversionFun class shows how to do a narrowing
 *  and a widening conversion.
 */

public class ConversionFun {
  /*
   * main is the entry point of the application.
   */

  public static void main(String[] args) {
    double myDouble = 3.14;
    float myFloat = 3.14f; //narrowing or lossy conversion
    double yourDouble = myFloat; //widening or lossless conversion

  }//end main
}

