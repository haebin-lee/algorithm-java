package algorithm.leetcode;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSumSmaller(new int[]{-2,0,1,3}, 2));
        System.out.println(threeSumSmaller(new int[]{1,1,-2}, 1));
    }

    public static int threeSumSmaller(int[] nums, int target) {
        count = 0;
        backtracking(nums, target, 0, 0, 0);
        return count;
    }

    public static int count = 0;
    public static void backtracking(int[] nums, int target, int i, int cnt, int sum) {
        if (cnt == 3 && sum < target) {
            count ++;
            return;
        }

        if (i >= nums.length || cnt > 3) {
            return;
        }
        System.out.println(String.format("i = %d nums[i] = %d cnt = %d sum = %d", i, nums[i], cnt + 1, sum + nums[i]));
        backtracking(nums, target, i + 1, cnt + 1, sum + nums[i]);
        backtracking(nums, target, i + 1, cnt, sum);

    }
}
