import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String name;
        String city;
        int age;
        double dubInput;

        System.out.println("What is your name?");
        name = keyboard.nextLine();
        //the nextLine method will read everything you type until you hit the ENTER key

        System.out.println("What's your age?");
        age = keyboard.nextInt();
        keyboard.nextLine(); //to consume the newline created that the nextInt doesn't consume

        System.out.println("What's your real number?");
        dubInput = keyboard.nextDouble();
        keyboard.nextLine();
        dubInput *= 2;

        System.out.println("What city do you live in?");
        city = keyboard.nextLine();

        System.out.println("\nHello, " + name);
        System.out.println("Your age is " + age);
        System.out.println("Your city is " + city);
        System.out.println("Twice your number is " + dubInput);
    }//end main
}