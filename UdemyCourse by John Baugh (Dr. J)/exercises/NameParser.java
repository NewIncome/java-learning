import java.util.Scanner;

public class NameParser {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String wholeName;
        String firstName;
        String lastName;
        int spaceIndex;

        System.out.println("Please write your first and last name:\t");
        wholeName = keyboard.nextLine();

        //separate first n last names
        spaceIndex = wholeName.indexOf(" ");
        firstName = wholeName.substring(0, spaceIndex);
        lastName = wholeName.substring(spaceIndex + 1);

        System.out.println(firstName.toUpperCase());
        System.out.println(lastName.toLowerCase());

        System.out.println(lastName.hashCode());
        System.out.println(System.identityHashCode(lastName));
        lastName = lastName.toLowerCase(); // Gets a unique value for the memory allocation address
        /* The String variable was changed so the reference will be different, thus immutability */
        System.out.println(lastName.hashCode()); // both methods are not the same
        System.out.println(System.identityHashCode(lastName)); // This method is more precise

    }//end main
}