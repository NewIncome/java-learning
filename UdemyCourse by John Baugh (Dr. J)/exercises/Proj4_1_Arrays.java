/*
 * Variables -> Input, and Array length 5
 * Loop and Store each value
 * Loop and print each value * 2
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Proj4_1_Arrays {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int[] myArr = new int[5];

        for(int i = 0; i < myArr.length; i++) {
            System.out.print("Give me an integer value:\t");
            myArr[i] = keyboard.nextInt();
        }//end for

        for(int m : myArr) {
            System.out.print("Result is:\t" + (m * 2) + "\n");
            // The parenthesis is to make it clear to see, but operationally not necessary
        }//end for

    }//end main
}