public class CircleDemo {
  public static void main(String[] args) {
    Circle c1 = new Circle();
    Circle c2 = new Circle(5);
    Circle c3 = new Circle(12.75);

    getInfo(c1);
    getInfo(c2);
    getInfo(c3);
  }//end main

  public static void getInfo(Circle c){
    System.out.println("r = " + String.format("%.2f", c.getRadius()));
    // the % tells it following is a special meaning string
    // the .2 are the decimal places we want
    // the f indicates we're dealing with real numbers
    System.out.println("C = " + String.format("%.2f", c.circumference()));
    System.out.println("A = " + String.format("%.2f", c.area()));
    System.out.println();
  }//end getInfo
}//end CircleDemo
