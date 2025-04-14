package week1Lab;

import java.util.Scanner;



public class LargerNumberNano {
    public static long getLargeNumberNano(int num1, int num2) {
        if( num1 > num2){
            return num1;
        }
        else {
            return num2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        long startTime = System.nanoTime();
        System.out.println(getLargeNumberNano(num1, num2));
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

    }
}
