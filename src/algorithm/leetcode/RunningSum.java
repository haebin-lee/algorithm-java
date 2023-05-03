package algorithm.leetcode;

import java.util.Arrays;

public class RunningSum {

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        printArr(runningSumWithReusedInput(a));

        int[] b = {1,1,1,1};
        printArr(runningSumWithReusedInput(b));
    }

    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1 ; i < nums.length ; i ++) {
            result[i] = result[i -1] + nums[i];
        }

        return result;
    }

    public static int[] runningSumWithReusedInput(int[] nums) {
        for (int i = 1; i < nums.length ; i ++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }

    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(m -> System.out.print(m +" "));
        System.out.println();
    }
}
