public class RelationalFun {
    public static void main(String[] args) {
        System.out.println("---RelationalFun---");
        boolean myBool = true;
        boolean yourBool = false;
        int myAge = 37;
        int yourAge = 20;
        int bobsAge = 20;

        System.out.println("myBool is " + myBool);
        System.out.println("yourBool is " + yourBool);

        //relational operations
        boolean ageComparison = myAge > yourAge;
        System.out.println("myAge > yourAge ?: " + ageComparison);

        ageComparison = yourAge > bobsAge;
        System.out.println("yourAge > bobsAge ?: " + ageComparison);

        ageComparison = (yourAge == bobsAge); //the () are just for readability
        System.out.println("yourAge == bobsAge ?: " + ageComparison);

    }//end main
}