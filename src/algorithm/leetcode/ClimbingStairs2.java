package algorithm.leetcode;

public class ClimbingStairs2 {

    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // 1 + 1 // 2
        System.out.println(climbStairs(3)); // 1 + 1, 2+ 1, 1 + 2 //3
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] ways = new int[n + 1];
        ways[0] = 0;
        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3 ; i <= n ; i ++) {
            ways[i] = ways[i - 2] + ways[i - 1];
        }
        return ways[n];
    }
}
