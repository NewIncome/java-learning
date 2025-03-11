/**
 * UMD:
 * Circle
 * ------
 * - radius : double
 * -----------------
 * + Circle()
 * + Circle(radius : double)
 * + getRadius() : double
 * + setRadius(radius : double) : void
 * + circumference() : double
 * + area() : double
 */

class Circle {
  private double radius;

  public Circle() {
    this(1.0);
  }//end no-arg ctor
  public Circle(double radius) {
    this.radius = radius;
  }//end param ctor

  public double getRadius() {
    return radius;
  }//end getRadius

  public void setRadius(double radius) {
    this.radius = radius;
  }//end ser radius

  public double circumference() {
    return 2 * (Math.PI * radius);
  }//end circumference

  public double area() {
    return Math.PI * Math.pow(radius, 2);
  }//end area
}//end class
