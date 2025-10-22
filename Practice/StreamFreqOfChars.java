/*
 * Find the frequency of chars in a String
 * 
 * steps:
 * ○ separate string into array
 * ○ create/start stream
 * ○ count char and add it to a Map
 * ○ return Map
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamFreqOfChars {

  public static void main(String[] args) {

    String str = "Surya Namaskar";

    /* List.of(str.split("")).stream();
    Stream.of(str).getClass() map(System.out::println); */
    //Stream.of(str).getClass(); //class java.util.stream.ReferencePipeline$Head
    Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
    stream3.forEach(System.out::println);
    //System.out.println(stream3.getClass()); 
    Pattern.compile("\\s+").splitAsStream(str);//separate into words
    Pattern.compile("").splitAsStream(str).forEach(System.out::println);
    Pattern.compile("").splitAsStream("hello").collect(Collection.to) .forEach(System.out::println);
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