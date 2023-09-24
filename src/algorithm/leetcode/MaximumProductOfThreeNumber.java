package algorithm.leetcode;

import java.util.Arrays;

public class MaximumProductOfThreeNumber {

    public static void main(String[] args) {
    }

    public static int maximumProduct(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        // - - +
        // + + +
        int a = nums[0] * nums[1] * nums[size - 1];
        int b = nums[size - 1] * nums[size - 2] * nums[size - 3];
        return Math.max(a, b);
    }
}
