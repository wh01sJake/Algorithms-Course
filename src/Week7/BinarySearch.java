package Week7;

public class BinarySearch {
    public static void main(String[] args) {
        int [] nums = {6,9,12,17,23,42,60,80,91};

        System.out.println(binarySearch(nums, 100));

    }





    private static int binarySearch(int[] arr, int key) {

        int low = 0;
        int high = arr.length-1 ;

        while (low <= high) {
            int middle = (high - low) / 2 + low ;
            if (arr[middle] == key) {
                return middle;
            }
            else if (arr[middle] > key) {
                high = middle - 1;
            }
            else {
                low = middle + 1;
            }
        }
        return -1;

    }
}
