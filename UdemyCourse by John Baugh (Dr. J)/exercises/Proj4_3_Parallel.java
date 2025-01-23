/*
 * Project 4.3: Ask user for ages and names of 5 people and store the values in 2 separate arrays
 * Steps:
 * + import Scanner and ArrayList
 * + Declare 5 variables(maybe just 3 for short), for userInputName, uInAge, Ages Arr, Names ArrL
 * + for loop to get the 5 names and ages
 * + for loop to print out the names with each age
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Proj4_3_Parallel {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        int[] ages = new int[5];
        String name;
        int age;

        for(int i = 0; i < ages.length; i++) {
            System.out.print("Give me a name:\t");
            name = keyboard.nextLine();
            names.add(name);

            System.out.print("Now an age:\t");
            age = keyboard.nextInt(); //must be in accordance with variable type!
            //consume newline
            keyboard.nextLine();
            // To consume The New Line Character, when reading a string after an int
            ages[i] = age;

            System.out.println();
        }//end for

        System.out.print("The people and ages are:\n");
        for(int i = 0; i < ages.length; i++) {
            System.out.println(names.get(i) + " is " + ages[i] + " years old");
        }//end for

    }//end main
}