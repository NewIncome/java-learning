import java.util.Scanner;

public class Proj1_AverageOfThree {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double number1;
        double number2;
        double number3;
        double average;
        
        System.out.println("Mr User, please give me three real numbers");
        System.out.println("First number: ");
        number1 = keyboard.nextDouble();

        System.out.println("Second number: ");
        number2 = keyboard.nextDouble();

        System.out.println("Third number: ");
        number3 = keyboard.nextDouble();
        keyboard.nextLine(); //good habit

        average = (number1 + number2 + number3) / 3.0; //could use 3, because the double is above
        System.out.println("These are your numbers: " + number1 + " , " + number2 + " , " + number3);
        System.out.println("This is the average or mean value of your numbers: " + average);
    }// end main
}