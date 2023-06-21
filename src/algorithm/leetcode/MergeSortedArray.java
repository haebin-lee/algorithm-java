package algorithm.leetcode;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3, n = 3;
        int[] nums2 = {2, 5, 6};

        int[] result = merge2(nums1, m, nums2, n);
        printArr(result);
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < nums1.length; i ++) {
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
        return nums1;
    }

    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        int [] result = new int[m + n];
        int x = 0, y = 0;
        for (int i = 0; i < result.length ; i ++) {
            if (x == m) {
                result[i] = nums2[y++];
            } else if (y == n) {
                result[i] = nums1[x++];
            } else if (nums1[x] < nums2[y]) {
                result[i] = nums1[x++];
            } else {
                result[i] = nums2[y++];
            }
        }

        System.arraycopy(result, 0, nums1, 0, result.length);
        return nums1;
    }

    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(m -> System.out.print(m + " "));
        System.out.println();
    }
}
