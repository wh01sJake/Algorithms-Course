package Week5;

public class RecursiveExample {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        printStar(5);

        int [] nums = {1,2,3,4,5};
        System.out.println(sum(nums, 0));
        System.out.println(contains(nums, 0, 3));

        System.out.println("Recursion: " +fibonacci(1111111));
        System.out.println("ForLoop: " +fibonacci2(6));
    }



    private static int factorial(int n) {
        if (n == 0){
            return 1;
        }
        else if (n < 1){
            return -1;
        }
        return n * factorial(n-1);
    }

    private static void printStar(int n) {
        System.out.print("*");
        if (n == 0){
            return;
        }
        else {
             printStar(n-1);
        }

    }
    private static int sum(int[] nums,int index){
        if (index == nums.length){
            return 0;
        }
        else {
            return nums[index] + sum(nums,index+1);
        }
    }

    private static boolean contains(int[] nums,int index, int target){
        if (index == nums.length){
            return false;
    }
        else {
            if (nums[index] == target){
                return true;
            }
        }
        return contains(nums,index+1,target);
    }

    private static int fibonacci(int n) {
        if (n == 1 || n == 2){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    private static int fibonacci2(int n) {
        if (n ==0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int [] nums = new int[n];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < n; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n-1];
    }
}
