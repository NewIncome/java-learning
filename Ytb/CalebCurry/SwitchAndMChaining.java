package Ytb.CalebCurry;

import java.util.Scanner;

public class SwitchAndMChaining {
  public static void main(String[] args) {
    //Switch statment exercise
    System.out.println("What's your name?: ");

    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();

    switch(name) {
      case "Caleb":
        System.out.println("Welcome my man");
        break;
      case "Clare":
        System.out.println("Pretty girls, ofcourse");
        break;
      case "Jorel":
      case "Kalel":
        System.out.println("No cheating with superpowers");
        break;
      default:
        System.out.println("Try again later");
        break;
    }
  }
}
