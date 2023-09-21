package algorithm.leetcode.dp;

import java.util.Arrays;

public class NthFibonacciNumber {

    public static void main(String[] args) {
        System.out.println(tribonacci(4));//4
        System.out.println(tribonacci(25)); // 25
    }

    public static int tribonacci(int n) { // 4
        if (n == 0 || n == 1) return n;
        if (n == 2) return 1;

        n = n + 1;

        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        fibonacci[2] = 1;
        for (int i = 3; i < n; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2] + fibonacci[i-3];
        }
        System.out.println(Arrays.toString(fibonacci));
        return fibonacci[n-1];

    }

}
