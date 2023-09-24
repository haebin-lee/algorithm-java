package algorithm.leetcode;

import java.util.Arrays;

public class SquareSortedArray {

    public static void main(String[] args) {
        int[] result = sortedSquares(new int[]{-7,-3,2,3,11});
        System.out.println(Arrays.toString(result));
    }
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int[] result = new int[nums.length];
        divide(nums, 0, nums.length);
        return nums;
    }
    public static void divide(int[] nums, int start, int end) {
        if (end - start < 2) return ;
        int mid = (start + end) / 2;
        divide(nums, start, mid);
        divide(nums, mid, end);
        merge(nums, start, mid, end);
    }
    public static void merge(int[] nums, int start, int mid, int end) {
        int i = start, j = mid;
        int[] merged = new int[end - start];
        int idx = 0;
        while (i < mid && j < end) {
            if (nums[i] <= nums[j]) {
                merged[idx++] = nums[i++];
            } else {
                merged[idx++] = nums[j++];
            }
        }
        while (i < mid) {
            merged[idx++] = nums[i++];
        }
        while (j < end) {
            merged[idx++] = nums[j++];
        }

        idx = 0;
        for (int k = start; k < end; k++) {
            nums[k] = merged[idx++];
        }
    }
}
