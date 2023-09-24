package algorithm.leetcode.dp;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1})); // 4
        System.out.println(rob(new int[]{2, 7, 9, 3, 1})); // 12
    }
    // Goal: maximize the sum of money while two adjacent were not taken.
    // Def OPT[i]: the maximum sum of value under given i house(1...i)
    // equation:
        // OPT[0] = nums[0] if i == 0
        // OPT[1] = Math.max(nums[0], nums[1]) if i == 1
        // OPT[1] = Math.max(OPT[i-1], OPT[i-2] + nums[i])
    public static int rob(int[] nums) {
        int[] opt = new int[nums.length];
        opt[0]= nums[0];
        for (int i = 1; i< nums.length; i++) {
            opt[i] = Math.max(opt[i-1], i - 2 < 0 ? nums[i] : opt[i-2] + nums[i]);
        }
        return opt[nums.length - 1];
    }
}
