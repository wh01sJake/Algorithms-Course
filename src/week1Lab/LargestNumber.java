package week1Lab;

import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] num = new int[10];

        for (int i = 0; i < 10; i++) {
            num[i] = sc.nextInt();
        }
        long currentTime = System.nanoTime();
        System.out.println(getLargestNumber(num));
        long endTime = System.nanoTime();
        System.out.println(endTime - currentTime);

        long currentTime2 = System.nanoTime();
        System.out.println(getLargestNumber2(num));
        long endTime2 = System.nanoTime();
        System.out.println(endTime2 - currentTime2);


    }

    public static int getLargestNumber(int[] num){
        int max = num[0];
        for (int i = 1; i < num.length; i++) {
            if(num[i] > max){
                max = num[i];
            }
        }
        return max;
    }

    public static int getLargestNumber2(int[] num){
        return Math.max(num[0], num[9]);
    }

}
