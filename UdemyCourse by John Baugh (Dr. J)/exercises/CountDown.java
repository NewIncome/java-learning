public class CountDown {
    public static void main(String[] args) {
        //countDownFrom(10);
        countDownFrom(10);
    }x

    public static void countDownFrom(int num) {
        if(num >= 0) {
            System.out.println(num);
            countDownFrom(num - 1);
        }
    }

    public static void countUpTo(int num) {
        if(num <= num) {
            System.out.println(num);
            countUpTo(num + 1);
        }
    }
}