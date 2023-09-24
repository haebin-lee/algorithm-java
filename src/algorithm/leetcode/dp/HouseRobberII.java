package algorithm.leetcode.dp;

public class HouseRobberII {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2})); // 3
        System.out.println(rob(new int[]{1, 2, 3, 1})); // 4
    }
    // Goal: maximize the sum of money while two adjacent were not taken.
    // Def: opt[i]: the maximum sum of value given under given i(1..i)
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int a = rob(nums, 0, nums.length - 2);
        int b = rob(nums, 1, nums.length - 1);
        return Math.max(a, b);
    }
    public static int rob(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev = 0;
        for(int i = start; i <= end; i++) {
            int cur = Math.max(prev, prev2 + nums[i]);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
