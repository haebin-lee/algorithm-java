package algorithm.leetcode;

public class ClimbingStairs {
    public static void main(String[] args) {

        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n ; i ++) {
            arr[i] = arr[i -2] + arr[i -1];
        }
        return arr[n-1];
    }
}
