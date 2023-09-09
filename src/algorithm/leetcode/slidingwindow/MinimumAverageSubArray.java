package algorithm.leetcode.slidingwindow;

public class MinimumAverageSubArray {

    public static void main(String[] args) {
//        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
//        System.out.println(findMaxAverage(new int[]{5},1));
        System.out.println(findMaxAverage(new int[]{-1},1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (; i < k; i++) {
            sum += nums[i];
        }
        ans = Math.max(ans, sum);

        for (; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i-k];
            ans = Math.max(ans, sum);
        }

        return (double) ans / k;
    }

}
