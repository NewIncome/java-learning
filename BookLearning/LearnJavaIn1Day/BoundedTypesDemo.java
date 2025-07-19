/*
 * We’ll create:
 * A Measurable interface
 * Abstract and concrete shape classes (Shape, Rectangle, Circle)
 * A generic utility class that operates on types using different bounds
 */
/*
 * Highlights:
 * T extends Measurable: ensures the method can access .area() safely.
 * List<? super Shape>: lets you add or retrieve Shapes from a list with flexibility.
 * List<?>: allows processing any list regardless of type—great for logging or debugging.
 */
import java.util.List;

// ✅ Interface for measurable entities
interface Measurable {
    double area();
}

// ✅ Abstract base class
abstract class Shape implements Measurable {
    String name;
    Shape(String name) {
        this.name = name;
    }
}

// ✅ Concrete shape classes
class Rectangle extends Shape {
    double width, height;

    Rectangle(double w, double h) {
        super("Rectangle");
        this.width = w;
        this.height = h;
    }

    @Override
    public double area() {
        return width * height;
    }
}

class Circle extends Shape {
    double radius;

    Circle(double r) {
        super("Circle");
        this.radius = r;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// 🛠️ Generic utility class
class ShapeUtils {

    // 👆 Upper bound: Only Measurable types or its subtypes
    public static <T extends Measurable> void printArea(T item) {
        System.out.println("Area: " + item.area());
    }

    // 👇 Lower bound: Accepts Shape or any superclass (e.g., Object)
    public static void displayShapeNames(List<? super Shape> items) {
        for (Object obj : items) {
            if (obj instanceof Shape) {
                Shape shape = (Shape) obj;
                System.out.println("Shape: " + shape.name);
            }
        }
    }

    // 🌐 Unbounded: Accepts anything
    public static void describeList(List<?> items) {
        for (Object item : items) {
            System.out.println("Item: " + item.toString());
        }
    }
}

// 🎯 Testing it all
public class BoundedTypesDemo {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 3);
        Circle circle = new Circle(4);

        ShapeUtils.printArea(rect);
        ShapeUtils.printArea(circle);

        List<Shape> shapes = List.of(rect, circle);
        ShapeUtils.displayShapeNames(shapes);

        List<String> names = List.of("Circle", "Square", "Triangle");
        ShapeUtils.describeList(names);
    }
}

/*
 * -Results in-
 * Area: 15.0
 * Area: 50.26548245743669
 * Shape: Rectangle
 * Shape: Circle
 * Item: Circle
 * Item: Square
 * Item: Triangle
 */