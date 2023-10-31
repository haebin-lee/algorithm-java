package algorithm.leetcode.dp;

import java.util.Arrays;

public class ClosestDesertCost {

    public static void main(String[] args) {
        ClosestDesertCost d = new ClosestDesertCost();
        System.out.println(d.closestCost(new int[]{10}, new int[]{1}, 10));
    }
    int result = 0;
    int min = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int baseCost: baseCosts) {
            dfs(toppingCosts, 0, baseCost, target);
        }
        return result;
    }

    private void dfs(int[] toppingCosts, int i, int cost, int target) {
        if (cost == target) {
            result = cost;
            min = 0;
            return;
        }
        if (i == toppingCosts.length) {
            if (cost <= target && Math.abs(target - cost) < min) {
                result = cost;
                min = Math.abs(target - cost);
            }
            return;
        }

        dfs(toppingCosts, i + 1, cost, target);
        dfs(toppingCosts, i + 1, cost + toppingCosts[i], target);
        dfs(toppingCosts, i + 1, cost + toppingCosts[i] * 2, target);
    }


}


