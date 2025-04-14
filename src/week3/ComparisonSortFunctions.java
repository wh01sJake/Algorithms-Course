package week3;

import java.util.Random;

public class ComparisonSortFunctions {
    public static void main(String[] args) {
        Random r = new Random();
        int [] nums = r.ints(10,0,8000).toArray();
        int [] nums2 = nums.clone();
        int [] nums3 = nums.clone();
        int [] nums4 = nums.clone();

        // bubbleSort for nums
        long startTime1 = System.nanoTime();
        bubbleSort(nums);
        long endTime1 = System.nanoTime();
        long elapsedTime1 = endTime1 - startTime1;
        System.out.println("BubbleSort took " + elapsedTime1 + " many nanoseconds");

        // bubbleSort2 for nums
        long startTime4 = System.nanoTime();
        bubbleSort2(nums);
        long endTime4 = System.nanoTime();
        long elapsedTime4 = endTime4 - startTime4;
        System.out.println("BubbleSort2 took " + elapsedTime4 + " many nanoseconds");


        // selectionSort
        long startTime2 = System.nanoTime();
        selectionSort(nums2);
        long endTime2 = System.nanoTime();
        long elapsedTime2 = endTime2 - startTime2;
        System.out.println("SelectionSort took " + elapsedTime2 + " many nanoseconds");

        // insertionSort
        long startTime3 = System.nanoTime();
        insertionSort(nums3);
        long endTime3 = System.nanoTime();
        long elapsedTime3 = endTime3 - startTime3;
        System.out.println("InsertionSort took " + elapsedTime3 + " nanoseconds");
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (arr[j] > arr[j+1]){
                   swap(arr, j, j+1);
                }
            }
        }
    }

    public static void bubbleSort2(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            boolean flag = false;
            for (int j = 0; j < n-i-1; j++){
                if (arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void selectionSort(int [] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j =i+1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
               swap(arr, i, min);
            }
        }
    }

    public static void selectionSort2(int [] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            boolean flag = false;
            for (int j =i+1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                    flag = true;
                }
            }
            if (min != i) {
                swap(arr, i, min);
            }
            if (!flag) {
                break;
            }
        }

    }

    public static void insertionSort(int [] arr){
        int sortedIndex = 1;
        while (sortedIndex < arr.length) {
            int key = sortedIndex;
            while (key > 0 && arr[sortedIndex] < arr[sortedIndex - 1]) {
                    int temp = arr[sortedIndex];
                    arr[sortedIndex] = arr[sortedIndex - 1];
                    arr[sortedIndex - 1] = temp;
                    key--;
            }
            sortedIndex++;
        }

    }
}
