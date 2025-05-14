// Demonstrate Predicate Interface
import java.util.*;
import java.util.function.Predicate;

class Interface05predicateToFilterStrings {
    public static void main(String args[]) {
      
        // create a list of strings
        List<String> n = Arrays.asList(
            "Geek", "GeeksQuiz", "g1", "QA", "Geek2");

        // declare the predicate type as string and use
        // lambda expression to create object
        Predicate<String> p = (s) -> s.startsWith("G");

        // Iterate through the list
        for (String st : n) {
          
            // call the test method
            if (p.test(st))
                System.out.println(st);
        }
    }
}
