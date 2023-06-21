package algorithm.leetcode;

import javax.tools.Diagnostic;
import java.util.Arrays;

public class RemovingElement {

    public static void main(String[] args) {
        int[] num = {0,1,2,2,3,0,4,2};
        int val = 2;
        removeElement2(num, val);
    }

    public static int removeElement(int[] nums, int val) {
        int[] result = new int[nums.length];
        int k = 0;
        for (int i = 0; i < nums.length ; i ++) {
            if (nums[i] != val) {
                result[k] = nums[i];
                k++;
            }
        }
        System.arraycopy(result, 0, nums, 0, result.length);
        return k;
    }

    public static int removeElement2(int[] nums, int val) {
        int i = 0, j = 0;

        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        printArr(nums);

        return i;
    }

    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(m -> System.out.print(m + " "));
        System.out.println();
    }
}
