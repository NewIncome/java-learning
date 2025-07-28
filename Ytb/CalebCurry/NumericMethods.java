package Ytb.CalebCurry;

public class NumericMethods {
  public static void main(String[] args) {
    //Common Numeric methods
    int m = 10;
    int n = 20;
    System.out.println(Integer.max(m,n));
    System.out.println(Integer.compare(m,n));
    
    String money = "300";
    
    System.out.println(Integer.valueOf(money));
    System.out.println(Integer.parseInt(money));

    //This to get the value of an String
    Integer a = Integer.valueOf(money);
    //And save our Integer object to an int primitive
    int b = Integer.parseInt(money);
    //the same methods are available for the obj Double
    System.out.println();

    //PROPERTIES for all DataTypes
    /* You can see this in your text editor with a Java extension,
     * after typing the DataType and a dot
     */
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.SIZE); //in bits
    System.out.println(Double.NEGATIVE_INFINITY);
    System.out.println(Double.POSITIVE_INFINITY);
    System.out.println(Double.isNaN(Math.sqrt(-1)));
    System.out.println();

    /* TO use this, make sure to use the dataType conv in
     * the operand, this according to the result you need
     */
    double x = (double) a / 2;
    System.out.println(x);
  }
}
