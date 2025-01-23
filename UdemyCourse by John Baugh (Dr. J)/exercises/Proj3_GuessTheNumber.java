/*
 * Project to use input scanner, random, conditionals, and loops
 */
import java.util.Random;
import java.util.Scanner;

public class Proj3_GuessTheNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner keyboard = new Scanner(System.in);

        int computerNum = random.nextInt(100) + 1;
        int userGuess;
        int guesses = 0;

        System.out.println("~~~ Care to guess the computer's number? ~~~");
        do {
            System.out.print("\nPlease enter your integer guess:\t");
            userGuess = keyboard.nextInt();
            if(userGuess > 100 || userGuess < 0) {
                System.out.println("That was a wasted guess! Pick a number between 1 and 100, inclusive!");
            }
            else if(userGuess > computerNum) {
                System.out.println("Your guess was too high");
            }
            else {
                System.out.println("Your guess was too low");
            }
            guesses++;
        }
        while(userGuess != computerNum);

        System.out.println("~~~ Congratulations! You guessed the number in " + guesses + " guesses! Thanks for playing! ~~~");

    }//end main
}