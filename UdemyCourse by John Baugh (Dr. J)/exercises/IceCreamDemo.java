public class IceCreamDemo {
  public static void main(String[] args) {
    IceCream cone1 = new IceCream("Chocolate", 3, 2);
    IceCream cone2 = new IceCream("Strawberry", 2, 1);

    cone1.addTopping("nuts");
    cone1.addTopping("cherries");
    cone1.printToppings();

    cone2.addTopping("sprinkles");
    cone2.printToppings();
  }//end main
}//end IceCreamDemo
