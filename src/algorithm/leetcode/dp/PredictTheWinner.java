package algorithm.leetcode.dp;

import java.util.Arrays;

public class PredictTheWinner {

    public static void main(String[] args) {
        System.out.println(dp(new int[]{1, 5, 2}));
//        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7}));
    }
    public static boolean predictTheWinner(int[] nums) {
        int size = nums.length;
        int turn = size % 2 == 0? size / 2 : size / 2 + 1;


        // scoreDiff >=0 : p1 is win, p2 is lost
        int p1 = maxSelection(nums, 0, nums.length - 1, 0, turn);
        return p1 >= 0;
    }

    public static int maxSelection(int[] nums, int start, int end, int scoreDiff, int turn) {
        return 9;
    }

    // bruteforce - 이걸 내가 생각해낼수가 있을까....
    public static boolean bruteforce(int[] nums) {
        return maxDiff(nums, 0, nums.length - 1) >= 0;
    }
    public static int maxDiff(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        System.out.println("range: "+left + "~" + right);
        int scoreByLeft = nums[left] - maxDiff(nums, left + 1, right); // 왼쪽끝을 선택했을 때 상대는 남은 것 중 가장 큰걸 고르겠지?
        int scoreByRight = nums[right] - maxDiff(nums, left, right -1); // 오른쪽 끝을 선택햇을 때 상대는 남은 것 중 가장 큰걸 고르겠지?
        return Math.max(scoreByLeft, scoreByRight);
    }

    static int[][]memo;
    // dp
    public static boolean dp(int[] nums) {
        int n = nums.length;
        memo = new int[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return maxDiff2(nums, 0, n -1) >= 0;
    }

    public static int maxDiff2(int[] nums, int left, int right) {
        if (memo[left][right] != -1) return memo[left][right];
        if (left == right)
            return nums[left];

        int scoreByLeft = nums[left] - maxDiff2(nums, left +1, right);
        int scoreByRight = nums[right] - maxDiff2(nums, left, right - 1);
        memo[left][right] = Math.max(scoreByLeft, scoreByRight);

        System.out.println("current: " + left + " " + right);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(memo[i]));
        }
        return memo[left][right];
    }
}
