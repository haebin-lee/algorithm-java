package algorithm.leetcode.slidingwindow;

import java.util.Arrays;

public class LongestSubArrayOf1sAfterDeletingOneElement {

    public static void main(String[] args) {
//        System.out.println(longestSubarray(new int[]{1, 1, 0, 1})); // 3
//        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1})); // 5
//        System.out.println(longestSubarray(new int[]{1, 1, 1})); // 2
//        System.out.println(longestSubarray(new int[]{1,1,0,0,1,1,1,0,1})); // 4
//        System.out.println(longestSubarray(new int[]{0,0,0})); // 0
        System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 1, 1, })); // 0
    }

    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (n == 2) {
            if (nums[0] == 1 && nums[1] == 1) return 1;
            return 0;
        }
        System.out.println(Arrays.toString(nums));

        // 세개
        int[] sum = new int[n];
        sum[0] = nums[0];
        int count1 = nums[0] == 1 ? 1 : 0;
        for (int i = 1; i < n; i++){
            if (nums[i] == 1) {
                count1++;
                sum[i] = sum[i-1] + nums[i];
            }
        }
        if (count1 == n) return n -1;
        System.out.println(Arrays.toString(sum));
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] != 0 && sum[i+1] != 0) {
                sum[i] = sum[i+1];
            }
        }
        System.out.println(Arrays.toString(sum));

        int ans = 0, max = 0;

        for (int i = 0; i < n; i++) {
            if (sum[i] == 0) {
                if (i - 1 >= 0 && i + 1 < n) {
                    ans = sum[i-1] + sum[i+1];
                } else if (i - 1 < 0) {
                    ans = sum[i+1];
                } else if (i + 1 == n) {
                    ans = sum [i -1];
                }

            }
            max = Math.max(max, ans);
        }

        return max;
    }

    public static int longestSubarray2(int[] nums) {
        int cur = 0, prev = 0;
        int ans = 0;
        for (int i : nums) {
            if (i == 1) cur++;
            else {
                ans = Math.max(ans, cur + prev);
                prev = cur;
                cur = 0;
            }
        }
        ans = Math.max(ans, cur + prev);
        return ans == nums.length ? ans - 1: ans;
    }
}
