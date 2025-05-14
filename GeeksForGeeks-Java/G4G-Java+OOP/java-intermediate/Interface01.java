interface InterfaceName {
  // Constant fields (public static final by default)  
  int CONSTANT = 10;  
  // Abstract method (public abstract by default)  
  void methodName();  

  // Default method (JDK 8+)  
  default void defaultMethod() {  
    System.out.println("Default implementation");
  }

  // Static method (JDK 8+)  
  static void staticMethod() {  
    System.out.println("Static method in interface");
  }

  // Private method (JDK 9+)  
  private void privateMethod() {  
    System.out.println("Private helper method");
  }
}

/*
 * -Private methods- can only be called inside default or static methods in the interface, not by implementing classes
 * -Static methods- are also accessible via the3interface itself not through objects
 * 
 */

/*
 *  Interface used to define common behavior
 */
 interface Vehicle {
     
     // Abstract methods defined
     void changeGear(int a);
     void speedUp(int a);
     void applyBrakes(int a);
 }
 
 // Class implementing vehicle interface
 class Bicycle implements Vehicle{
     
     int speed;
     int gear;
     
     // Change gear
     @Override
     public void changeGear(int newGear){
         gear = newGear;
     }
     
     // Increase speed
     @Override
     public void speedUp(int increment){
         speed = speed + increment;
     }
     
     // Decrease speed
     @Override
     public void applyBrakes(int decrement){
         speed = speed - decrement;
     }
     
     public void printStates() {
         System.out.println("speed: " + speed
             + " gear: " + gear);
     }
 }
 
 // Class implementing vehicle interface
 class Bike implements Vehicle {
     
     int speed;
     int gear;
     
     // Change gear
     @Override
     public void changeGear(int newGear){
         gear = newGear;
     }
     
     // Increase speed
     @Override
     public void speedUp(int increment){
         speed = speed + increment;
     }
     
     // Decrease speed
     @Override
     public void applyBrakes(int decrement){
         speed = speed - decrement;
     }
     
     public void printStates() {
         System.out.println("speed: " + speed
             + " gear: " + gear);
     }
     
 }
 
 class Main
 {    
     public static void main (String[] args) 
     {
     
         // Instance of Bicycle(Object)
         Bicycle bicycle = new Bicycle();
         
         bicycle.changeGear(2);
         bicycle.speedUp(3);
         bicycle.applyBrakes(1);
         
         System.out.print("Bicycle present state : ");
         bicycle.printStates();
         
         // Instance of Bike (Object)
         Bike bike = new Bike();
         bike.changeGear(1);
         bike.speedUp(4);
         bike.applyBrakes(3);
         
         System.out.print("Bike present state : ");
         bike.printStates();
     }
 }
