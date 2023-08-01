package algorithm.leetcode;

import algorithm.util.ArrayUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));

        coins = new int[]{2};
        amount = 3;
        System.out.println(coinChange(coins, amount));

        coins = new int[]{1};
        amount = 0;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins){
            for (int i = coin; i <= amount; i ++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
