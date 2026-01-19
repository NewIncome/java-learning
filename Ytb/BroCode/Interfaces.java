public class Interfaces {

  public static void main(String[] args) {
    // Interace = A blueprint for a class that specifies a set of abstract methods
    //            that implementing classes MUST define.
    //            Supports multiple inheritance-like behaviour.

    Rabbit rabbit = new Rabbit();
    Hawk hawk = new Hawk();
    Fish fish = new Fish();

    rabbit.flee();
    hawk.hunt();
    //rabbit.hunt();  //a rabbit cannot hunt

    fish.flee();
    fish.hunt();  //multiple inheritance example
  }

}


interface Prey {
  void flee();
}

interface Predator {
  void hunt();
}

class Rabbit implements Prey {
  @Override
  public void flee() {
    System.out.println("*The rabbit is runnin away*");
  }
}

class Hawk implements Predator {
  @Override
  public void hunt() {
    System.out.println("*The hawk is hunting*");
  }
}

class Fish implements Prey, Predator {  //you cannot extend 2 abstract classes
  @Override
  public void flee() {
    System.out.println("*The fish is swimmin away*");
  }

  @Override
  public void hunt() {
    System.out.println("*The fish is hunting*");
  }
}
