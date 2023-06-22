package algorithm.leetcode;

import javax.print.event.PrintEvent;
import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        rotate2(nums, 3);
        int[] nums2 = {-1, -100, 3, 99};
        rotate2(nums2, 2);
    }

    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            result[(i+k) % nums.length] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, result.length);
    }

    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        if (k < 0) {
            k += nums.length;
        }

        reverse(nums, 0, nums.length - k - 1);
        System.out.print("1: "); printArr(nums);
        reverse(nums, nums.length - k, nums.length - 1);
        System.out.print("2: "); printArr(nums);
        reverse(nums, 0, nums.length - 1);
        System.out.print("3: "); printArr(nums);

        System.out.println();
    }

    public static void reverse(int nums[], int i , int j) {
        int l = i;
        int r = j;

        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            l++;
            r--;
        }
    }

    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(m -> System.out.print(m + " "));
        System.out.println();
    }
}
