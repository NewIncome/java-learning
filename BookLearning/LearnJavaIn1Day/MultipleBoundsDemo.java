/*
 * Highlights:
 * T extends Shape & Measurable & Drawable: T must be a subclass of Shape and implement both Measurable and Drawable.
 * This helps enforce that only objects with all these capabilities can be passed in.
 * You get type-safe access to methods from all interfaces without casting.
 */

// ✅ Interface for measurable entities
interface Measurable {
    double area();
}

// ✅ Interface for drawable entities
interface Drawable {
    void draw();
}

// ✅ Base class for shapes
abstract class Shape {
    String name;
    Shape(String name) {
        this.name = name;
    }
}

// ✅ Rectangle: implements Measurable and Drawable
class Rectangle extends Shape implements Measurable, Drawable {
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

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with dimensions " + width + "x" + height);
    }
}

// ✅ Circle: implements Measurable and Drawable
class Circle extends Shape implements Measurable, Drawable {
    double radius;

    Circle(double r) {
        super("Circle");
        this.radius = r;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
}

// 🛠️ Utility class with multiple bounds
class GraphicTools {

    // 🧠 Multiple bounds: T must be a Shape AND Measurable AND Drawable
    public static <T extends Shape & Measurable & Drawable> void renderShape(T shape) {
        System.out.println("Rendering shape: " + shape.name);
        shape.draw();
        System.out.println("Area: " + shape.area());
    }
}

// 🎯 Test it out
public class MultipleBoundsDemo {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(4, 6);
        Circle circle = new Circle(3);

        GraphicTools.renderShape(rect);
        GraphicTools.renderShape(circle);
    }
}

/*
 * -Results in-
 * Rendering shape: Rectangle
 * Drawing a rectangle with dimensions 4.0x6.0
 * Area: 24.0
 * Rendering shape: Circle
 * Drawing a circle with radius 3.0
 * Area: 28.274333882308138
 */