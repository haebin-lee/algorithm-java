package algorithm.leetcode;

import algorithm.util.ArrayUtil;

import javax.swing.*;
import java.beans.PropertyEditorSupport;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit2(nums));

        int[] nums2 = {7, 6, 4, 1, 3};
        System.out.println(maxProfit2(nums2));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] min = new int[n];
        int[] max = new int[n];

        min[0] = prices[0];
        max[n-1] = prices[n-1];

        for (int i = 1; i < n; i ++) {
            min[i] = Math.min(min[i - 1], prices[i]);
            max[n-i-1] = Math.max(max[n - i], prices[n - i - 1]);
        }
        int result = 0;
        for (int i = 0 ; i < n ; i++){
            result = Math.max(max[i] - min[i], result);
        }
        return result;
    }

    public static int maxProfit2(int[] prices) {
        int least = Integer.MAX_VALUE;
        int optimal = 0;
        int profit = 0;

        for (int i = 0; i < prices.length ; i++) {
            if (prices[i] < least) {
                least = prices[i];
            }

            profit = prices[i] - least;

            if (optimal < profit) {
                optimal = profit;
            }

        }
        return optimal;
    }

}
