package Week10;

import week3.ComparisonSortFunctions;

import java.util.Arrays;

/**
 * ClassName: Alogrithms
 * Description:
 * <p>
 * Datetime: 2025/4/9 0:39
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Algorithms {

    public static void main(String[] args) {
        int[] arr = {5,1,24,43,675,3,32,2,53,78,76};

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }






    public static void insertionSort(int[] arr) {
          int n = arr.length;

          for (int i = 0; i < n-1; i++) {
              int minIndex = i;

              for (int j = i+1; j < n; j++) {
                  if(arr[minIndex] > arr[j]) {
                      minIndex = j;
                  }
              }

              int temp = arr[i];
              arr[i] = arr[minIndex];
              arr[minIndex] = temp;

          }

    }
}
