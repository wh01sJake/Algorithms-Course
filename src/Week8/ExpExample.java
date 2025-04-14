package Week8;

import java.io.FileInputStream;

public class ExpExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int c = average(a, b);
        System.out.println(c);



    }


    public static int average (int sum, int count){
        try {
            return sum/count;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
