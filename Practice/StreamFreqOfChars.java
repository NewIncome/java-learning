/*
 * Find the frequency of chars in a String
 * 
 * steps:
 * ○ separate string into array
 * ○ create/start stream
 * ○ count char and add it to a Map
 * ○ return Map
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFreqOfChars {

  public static void main(String[] args) {

    String str = "Surya Namaskar";

    /* List.of(str.split("")).stream();
    Stream.of(str).getClass() map(System.out::println); */
    //Stream.of(str).getClass(); //class java.util.stream.ReferencePipeline$Head
    Stream<Integer> stream1 = Stream.of(1, 2, 3);
    stream1.forEach(System.out::println); System.out.println();
    
    /* It has to be converted to a collection to use the println lambda,
     * becuase int[] isn't a Collection so it doesn't have a toString() method */
    int[] arr = {2, 3, 4};
    //Stream.of(arr)  would create a tream<int[]> of only 1 element
    Arrays.stream(arr).forEach(System.out::println); System.out.println();

    //Pattern.compile("\\s+").splitAsStream(str);//separate into words
    Pattern.compile("").splitAsStream(str).forEach(System.out::println);
    System.out.println();
    //Here somewhere the chars are getting sorted
    Pattern.compile("").splitAsStream("hello").collect(Collectors.toSet()).forEach(System.out::println);
    System.out.println();

    //--- Method1: Count char repetitions in string --- 
    HashMap<String, Integer> count01 = new HashMap<>();
    Arrays.asList(str.split("")).stream().forEach(e -> count01.put(e, count01.containsKey(e) ? count01.get(e) + 1 : 1));
    System.out.println(count01); System.out.println();
    //Arrays.asList(str.split("")).stream().forEach(System.out::println);
    //Works as well as the above
    //Arrays.asList(str.toCharArray()).stream().forEach(e -> count01.put(e, count01.containsKey(e) ? count01.get(e) + 1 : 1));

    /* //Does the same as above
    Pattern.compile("").splitAsStream(str).collect(Collectors.toSet()). forEach(e -> count01.put(e, count01.containsKey(e) ? count01.get(e) + 1 : 1));
    //Pattern.compile("").splitAsStream(str).collect(Collectors.toSet()).forEach(System.out::println);
    System.out.println(count01); */

    //--- Method2: Count char repetitions in string --- 

    String input = "Basant";
    Map<String, Long> countMap = Arrays.stream(input.split(""))
      .collect(
        Collectors.groupingBy(Function.identity(), Collectors.counting())
      );
    System.out.println(countMap);
  }

}
/*
 * List.of(str.split(""));  //Java 9+ : Factory method (Immutable)
 * 
 * Create Streams : ReferencePipeline
 * 1. <AnyCollectionObj>.stream()  
 *     from any CollectionObj .stream() class method,
 *     inherited from Collection class 'default Stream<E> stream()' method
 * 2. Arrays.stream(array)
 *     from .stream() class method
 * 3. Stream<Integer> stream3 = Stream.of
 *     from Stream.of()
 * 
 * Intermediate Operations
 * .filter(n -> n > 10)   // keep > 10
 * .map(n -> n * 2)       // double them
 * .distinct()            // remove duplicates
 * .sorted()              // sort ascending
 * .skip()
 * 
 * EndOperations
 * A) .collect(Collectors.toSet());
 *      converts a stream into any collection type .toList, .toSet, .toArray, .toCollection
 * B) .count()
 * C) .anyMatch() / .allMatch() / .noneMatch()
 * D) .findFirst() / .findAny()
 * E) .forEach()
 * F) .reduce() ,  //ie.: concatenate names:
 *       names.stream().reduce("", (a, b) -> a + b + " ");
 * 
 * * Stream.of(str).getClass(); //class java.util.stream.ReferencePipeline$Head
 * * 
 */