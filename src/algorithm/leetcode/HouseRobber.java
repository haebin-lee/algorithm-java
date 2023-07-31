package algorithm.leetcode;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob2(nums)); // 4

        int[] nums2 = {2,7,9,3,1};
        System.out.println(rob2(nums2)); // 12
    }
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (max[i - 2] + nums[i] > max[i - 1])
                max[i] = max[i-2] + nums[i];
            else
                max[i] = max[i - 1];
        }
        return max[nums.length - 1];
    }

    public static int rob2(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;

        for (int num : nums) {
            int dp = Math.max(prev2 + num, prev1);
            prev2 = prev1;
            prev1 = dp;
        }

        return prev1;
    }

}
