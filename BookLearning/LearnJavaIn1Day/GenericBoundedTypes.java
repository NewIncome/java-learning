import java.util.List;

class GenericBoundedTypes {

    // 👆 Upper bound: accepts only Number or its subclasses (e.g., Integer, Double)
    public <T extends Number> void printUpperBound(T value) {
        System.out.println("Upper bounded value: " + value);
    }

    // 👇 Lower bound: accepts Number or any superclass (e.g., Object)
    public void printLowerBound(List<? super Number> list) {
        list.forEach(item -> System.out.println("Lower bounded value: " + item));
    }

    // 🌐 Unbounded wildcard: accepts any type
    public void printUnbounded(List<?> list) {
        list.forEach(item -> System.out.println("Unbounded value: " + item));
    }

    public static void main(String[] args) {
        GenericBoundedTypes example = new GenericBoundedTypes();

        // Testing upper bound
        example.printUpperBound(42);              // Integer
        example.printUpperBound(3.14);            // Double

        // Testing lower bound
        List<Object> objectList = List.of("Hello", 123, true);
        example.printLowerBound(objectList);

        // Testing unbounded
        List<String> stringList = List.of("A", "B", "C");
        example.printUnbounded(stringList);
    }
}

/*
 * -Results in-
 * Upper bounded value: 42
 * Upper bounded value: 3.14
 * Lower bounded value: Hello
 * Lower bounded value: 123
 * Lower bounded value: true
 * Unbounded value: A
 * Unbounded value: B
 * Unbounded value: C
 */