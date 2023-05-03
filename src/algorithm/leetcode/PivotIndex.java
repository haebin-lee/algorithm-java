package algorithm.leetcode;

import java.util.Arrays;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6}; // 3
        System.out.println("result: " + pivotIndex(nums));

        int[] nums1 = {1,2,3};
        System.out.println("result: " + pivotIndex(nums1));

    }

    public static int pivotIndex(int[] nums) {
        int size = nums.length;
        int[] sum = new int[size];
        int[] reverse = new int[size];

        int lastIdx = size -1;
        sum[0] = nums[0];
        reverse[size -1] = nums[size- 1];
        for (int i = 1 ; i < nums.length ; i++) {
            sum[i] = sum[i-1] + nums[i];
            reverse[lastIdx - i] = reverse[lastIdx - i + 1] + nums[lastIdx - i];
        }

        for (int i = 0 ; i < size; i ++) {
            if (sum[i] == reverse[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(m -> System.out.print(m + " "));
        System.out.println();
    }
}
