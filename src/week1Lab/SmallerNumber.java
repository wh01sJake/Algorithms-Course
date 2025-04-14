package week1Lab;

import java.util.Scanner;

public class SmallerNumber {
    public static int getSmallerNumber(int num1, int num2) {
        if( num1 > num2){
            return num2;
        }
        else {
            return num1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println(getSmallerNumber(num1, num2));


    }
}
