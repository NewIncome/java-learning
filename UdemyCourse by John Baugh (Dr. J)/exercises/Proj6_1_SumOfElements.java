import java.util.Random;
import java.util.ArrayList;

public class Proj6_1_SumOfElements {
  public static void main(String[] args) {
    Random rand = new Random();
    ArrayList<Integer> myArray = new ArrayList<>();
    int n = rand.nextInt(9) + 1; //number of integers to use

    for(int i = 0; i < n; i++) {
      myArray.add(rand.nextInt(10));
    }//end for

    System.out.println("My Array: " + myArray + " , n = " + myArray.size());
    System.out.println("The sum of my array is: " + sumElements(myArray));
  }//end main

  public static int sumElements(ArrayList<Integer> list) {
    int sum = 0;
    for(int n : list) {
      sum += n;
    }
    return sum;
  }//end sumElements
}
