package algorithm.leetcode.array;

public class ThreeSumSmaller {

    public static void main(String[] args) {

    }


    public int result = 0;

    // It works, the time limit exceeds.
    public int threeSumSmallerWithBacktracking(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        backtracking(nums, target, 0, 0, 0);
        return result;
        // -2 0 1 1 2
    }

    public void backtracking(int[] nums, int target, int i, int count, int sum) {
        if (count == 3 && sum < target) {
            result++;
            return;
        }
        if (count >= 3 || i >= nums.length) {
            return;
        }

        backtracking(nums, target, i + 1, count + 1, sum + nums[i]);
        backtracking(nums, target, i + 1, count, sum);
    }
}
