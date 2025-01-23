/*
 * Project to use Array Lists (steps):
 * + import Scanner and ArrayList lib
 * + use 2 variables, for the user input and for the ArrayList of any positive values
 * + loop (until) to get the user values
 *   + break the loop if user inputs a negative value
 * + loop to print the values backwards
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Proj4_2_ArrayLists {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Double> myArrList = new ArrayList<>();
        double userVal;

        do {
            System.out.print("Give me a positive value, negative exits:\t");
            userVal = keyboard.nextDouble(); // Careful! has to be in accordance with variable type
            myArrList.add(userVal);
        }
        while(userVal >= 0);

        System.out.println("These are your values:");
        for(int i = myArrList.size() - 1; i >= 0; i--) {
            System.out.println(myArrList.get(i));
            // not like a normal array[]. They're a Generic Entity, remember
        }
    }
}