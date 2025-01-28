public class MethodOverloading {
    public static void main(String[] args) {
        int result = getResult(5);
        System.out.println(result);

        result = getResult(5, 4);
        System.out.println(result);

        result = getResult(5, "12");
        System.out.println(result);

        result = getResult("11", 5);
        System.out.println(result);
    }//end main

    public static int getResult(int num) {
        return num * 2;
    }//end getResult

    public static int getResult(int num1, int num2) {
        return num1 * num2;
    }//end getResult

    public static int getResult(int num1, String value) {
        return num1 * Integer.parseInt(value);
    }//end getResult

    public static int getResult(String value, int num1) {
        return Integer.parseInt(value) * num1 * 2;
    }//end getResult
}