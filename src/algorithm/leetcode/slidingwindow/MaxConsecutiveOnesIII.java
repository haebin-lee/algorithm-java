package algorithm.leetcode.slidingwindow;

import java.util.Arrays;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2)); // 6
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3)); // 10
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int ans = 0, max = 0;
        int i = 0;

        while(i < nums.length){
            if (nums[i] == 1) {
                ans++;
                i++;
            }
            else {
                if (k > 0) { //
                    k--;
                    ans++;
                    i++;
                } else {
                    while (k == 0) {
                        if (nums[left++] != 1) {
                            k++;
                        }
                        ans --;
                    }
                }

            }
            max = Math.max(ans, max);
        }

        return max;
    }
}
