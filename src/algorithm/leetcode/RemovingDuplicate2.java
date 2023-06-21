package algorithm.leetcode;

import java.io.FilterOutputStream;
import java.util.Arrays;

public class RemovingDuplicate2 {

    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,1,2,3,3};
//        int[] nums = {1, 1, 1, 2, 2, 3};
        int [] nums = {1, 1, 1, 2, 2, 2, 3, 3};

        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums){
        int[] result = new int[nums.length];
        int k = 0, count = 0, cur = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0 || cur != nums[i]) {
                result[k] = nums[i];
                cur = result[k];
                count = 1;
                k++;
            } else {
                if (count < 2) {
                    result[k] = nums[i];
                    k++;
                    count++;
                }
            }

        }
        printArr(result);
        System.arraycopy(result, 0, nums, 0, result.length);
        return k;
    }

    public static int removeDuplicates2(int[] nums){
        int[] result = new int[nums.length];
        int k = 0, count = 0, cur = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0 || cur != nums[i]) {
                result[k] = nums[i];
                cur = result[k];
                count = 1;
                k++;
            } else {
                if (count < 2) {
                    result[k] = nums[i];
                    k++;
                    count++;
                }
            }

        }
        printArr(result);
        System.arraycopy(result, 0, nums, 0, result.length);
        return k;
    }


    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(m -> System.out.print(m + " "));
        System.out.println();
    }
}
