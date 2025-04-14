package Week6;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {3,4,1,5,0,2,3};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }




    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);      // 递归左半部分
            mergeSort(arr, mid + 1, right); // 递归右半部分
            merge(arr, left, mid, right);    // 合并
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        // 比较并合并
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        // 复制剩余元素
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        // 将临时数组复制回原数组
        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}