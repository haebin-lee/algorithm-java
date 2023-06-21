package algorithm.leetcode;

import java.util.Arrays;

public class RemovingDuplicate {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int cur = result[0], k = 1;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] != cur) {
                result[k] = nums[i];
                cur = nums[i];
                k++;
            }
        }

        System.arraycopy(result, 0, nums, 0, result.length);
        return k;
    }

    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(m -> System.out.print(m + " "));
        System.out.println();
    }
}
