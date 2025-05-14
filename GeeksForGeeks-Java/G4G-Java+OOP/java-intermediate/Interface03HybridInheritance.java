// Define an interface
interface Flyable {
    void fly();
}

// Define an abstract class
abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void eat(); // Abstract method
}

// Define a concrete class that extends Animal and implements Flyable
class Bird extends Animal implements Flyable {
    private String color;

    public Bird(String name, String color) {
        super(name); // Call the Animal constructor
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating seeds.");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying.");
    }
}

// Define another class that extends Animal but does not implement Flyable
class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating dog food.");
    }
}

// Example usage
public class Interface03HybridInheritance {
    public static void main(String[] args) {
        Bird myBird = new Bird("Tweety", "Yellow");
        Dog myDog = new Dog("Buddy");

        myBird.eat();
        myBird.fly();
        System.out.println("Bird color: " + myBird.getColor());

        myDog.eat();
    }
}
