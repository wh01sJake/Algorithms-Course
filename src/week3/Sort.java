package week3;

import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int length = sc.nextInt();
        int[] arr = new int[length];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }

     }

     public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
     }


}
