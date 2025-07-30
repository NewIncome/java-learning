package Ytb.CalebCurry;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShortIfMChainListMethods {
  public static void main(String[] args) {
    String name = "Kalel";
    boolean welcome = false;
    //if abreviation, and Method Chaining
    if(name.toLowerCase().equals(name)) welcome = true;
    System.out.println(welcome);

    //How to quickly initialize & print a List|ArrayList
    List<Integer> grades = Arrays.asList(5, 3, 2, 6, 3);
    System.out.println(Arrays.toString(grades.toArray()));

    //To sort a List variable
    Collections.sort(grades);
    Collections.reverse(grades);
  }
}
