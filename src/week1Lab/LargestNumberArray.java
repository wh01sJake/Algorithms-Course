package week1Lab;

import java.util.Arrays;
import java.util.Random;

public class LargestNumberArray {

    public static void main(String[] args) {
        Random r = new Random();
        int [] nums = r.ints(10000,0,8000).toArray();
        long currentTime = System.nanoTime();
        System.out.println(getLargestNumber(nums));
        long endTime = System.nanoTime();
        System.out.println(endTime - currentTime);

        long currentTime2 = System.nanoTime();
        System.out.println(getLargestNumber2(nums));
        long endTime2 = System.nanoTime();
        System.out.println(endTime2 - currentTime2);

        long currentTime3 = System.nanoTime();
        System.out.println(getLargestNumber3(nums));
        long endTime3 = System.nanoTime();
        System.out.println(endTime3 - currentTime3);
    }

    public static int getLargestNumber(int[] nums) {
        int max = nums[0];
        for (int num : nums){
            max = Math.max(max, num);
            }
        return max;
        }

    public static int getLargestNumber2(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }

    public static int getLargestNumber3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }
}

