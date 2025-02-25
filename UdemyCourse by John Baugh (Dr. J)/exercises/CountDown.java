public class CountDown {
    public static void main(String[] args) {
        //countDownFrom(10);
        countUpTo(3, 12);
    }//end main

    public static void countDownFrom(int num) {
        if(num >= 0) {
            System.out.println(num);
            countDownFrom(num - 1);
        }
    }//end countDownFrom

    public static void countUpTo(int start, int end) {
        if(start <= end) { //inclusive
            System.out.println(start);
            countUpTo(start + 1, end);
        }
    }//end countUpTo
}