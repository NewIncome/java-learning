import java.util.Random;
import java.util.Scanner;

/**
 * Program to roll a dice 'n' number of times
 */

public class DiceRoller {

  public static void main(String[] args) {
    // JAVA Dice Roller Program
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int numOfDice;
    int total = 0;

    System.out.print("Enter the # of dice to roll: ");
    numOfDice = scanner.nextInt();

    // Check if # of dice > 0
    // Roll all the dice
    // Display Ascii of Dice
    // Get the total
    if(numOfDice > 0) {
      for (int i = 0; i < numOfDice; i++) {
        int roll = random.nextInt(1, 7);  // number between 1-6
        printDie(roll);
        System.out.println("You rolled: " + roll);
        total += roll;
      }
      System.out.println("Total: " + total);
    }
    else {
      System.out.println("# of dice must be greater than 0");
    }

    scanner.close();
  }

  static void printDie(int roll) {
    // Multiline string
    String dice1 = """  
         -------
        |       |
        |   ●   |
        |       |
         -------
        """;
    
    String dice2 = """  
         -------
        | ●     |
        |       |
        |     ● |
         -------
        """;
    String dice3 = """  
         -------
        | ●     |
        |   ●   |
        |     ● |
         -------
        """;
    String dice4 = """  
         -------
        | ●   ● |
        |       |
        | ●   ● |
         -------
        """;
    String dice5 = """  
         -------
        | ●   ● |
        |   ●   |
        | ●   ● |
         -------
        """;
    String dice6 = """  
         -------
        | ●   ● |
        | ●   ● |
        | ●   ● |
         -------
        """;
    
    switch(roll) {
      case 1 -> System.out.println(dice1);
      case 2 -> System.out.println(dice2);
      case 3 -> System.out.println(dice3);
      case 4 -> System.out.println(dice4);
      case 5 -> System.out.println(dice5);
      case 6 -> System.out.println(dice6);
      default -> System.out.println("Invalid roll");
    }
  }

}
