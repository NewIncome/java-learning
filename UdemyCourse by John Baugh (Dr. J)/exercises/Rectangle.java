/**
 * Rectangle class as a whole example of OOP
 * 
 * UML Diagram:
 * Rectangle
 * ---------
 * - length : double
 * - width : double
 * - _numRectangles : int_ //underlined
 * ------------------------------------
 * + Rectangle()
 * + Rectangle(length : double, width : double)
 * + getLength() : double
 * + getWidth() : double
 * + setLength(length : double) : void
 * + setWidth(width : double) : void
 * + area() : double
 * + _getNumRectangles() : int_ //underlined
 */

class Rectangle {
  private double length;
  private double width;

  private static int numRectangles;

  public Rectangle() { // no-arg ctor, for default behaviour
    this(1.0, 1.0); // calls the param ctor
  }//end no-arg ctor

  public Rectangle(double length, double width) { // param ctor
    this.length = length;
    this.width = width;
    numRectangles++;
  }//end param ctor

  public double getLength() {
    return length;
  }//end getLength

  public double getWidth() {
    return width;
  }//end getWidth

  public void setLength(double length) {
    this.length = length;
  }//end setLength

  public void setWidth(double width) {
    this.width = width;
  }//end setWidth

  public double area() {
    return length * width;
  }//end area

  public double perimeter() {
    return (length * 2) + (width * 2);
  }//end perimeter

  public static int getNumRectangles() {
    return numRectangles;
  }//end getNumRectangles
}