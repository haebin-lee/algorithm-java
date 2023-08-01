package algorithm.leetcode;

import algorithm.util.ArrayUtil;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums)); // 4
//
//        nums = new int[]{0,1,0,3,2,3};
//        System.out.println(lengthOfLIS(nums)); // 4
//
//        nums = new int[] {7,7,7,7,7,7,7};
//        System.out.println(lengthOfLIS(nums)); // 1

        nums = new int[] {0};
        System.out.println(lengthOfLIS(nums)); // 1
    }

    public static int lengthOfLIS(int[] nums) {
        int result = -1;
        int[] max = new int[nums.length];
        Arrays.fill(max, 1);
        for (int i = 0 ; i < nums.length; i++) {
            int cnt = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i] && cnt < max[j] + 1)  {
                    cnt = max[j] + 1;
                }
            }
            max[i] = cnt;
            if (result < cnt) {
                result = cnt;
            }
        }
        return result;
    }
}
