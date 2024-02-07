package algorithm.leetcode.dp;

public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit p = new MaxProfit();
        System.out.println(p.maxProfit(new int[]{1,3,2,8,4,9}, 2)); // 8
//        System.out.println(p.maxProfit(new int[]{1,3,7,5,10,3}, 3)); // 6
    }
    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for (int price : prices) {
            buy = Math.min(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }

        return sell;
    }
}
