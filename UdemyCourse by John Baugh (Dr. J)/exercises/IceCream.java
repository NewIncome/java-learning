/**
 * IceCream class
 * to store the name, cost, scoops, and toppings
 *
 * UML
 * 
 * IceCream
 * --------
 * - name : String
 * - cost : int
 * - numScoops : int
 * - toppings : ArrayList<String>
 * ------------------------------
 * + IceCream(name : String, cost : int, numScoops : int)
 * + addTopping(topping : String) : void
 * + getName() : String
 * + getCost() : int
 * + getNumScoops() : int
 * + printToppings : void
 */
import java.util.ArrayList;

class IceCream {
  private String name;
  private int cost;
  private int numScoops;
  private ArrayList<String> toppings;

  public IceCream(String name, int cost, int numScoops) {
    toppings = new ArrayList<>();
    this.name = name;
    this.cost = cost;
    this.numScoops = numScoops;
  }//end param ctor

  public void addTopping(String topping) {
    toppings.add(topping);
  }//end addTopping

  public String getName() {
    return name;
  }//end getName

  public int getCost() {
    return cost;
  }//end getCost

  public int getNumScoops() {
    return numScoops;
  }//end getNumScoops

  public void printToppings() {
    System.out.println(name);
    System.out.println("Cost: $" + cost);
    System.out.println("Topped with: ");
    for(String topping : toppings) {
      System.out.println("\t" + topping);
    }//end for
    System.out.println();
  }//end printToppings
}//end class
