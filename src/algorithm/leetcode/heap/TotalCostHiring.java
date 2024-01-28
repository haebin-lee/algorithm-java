package algorithm.leetcode.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TotalCostHiring {

    public static void main(String[] args) {
        TotalCostHiring p = new TotalCostHiring();
        System.out.println(p.totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4)); // 11
        System.out.println(p.totalCost(new int[]{1,2,4,1}, 3, 3)); // 4
    }

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> front = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>();
        int i = 0, j = costs.length - 1;
        long ans = 0;

        while (k-- >0) {
            while (front.size() < candidates && i <=j) {
                front.offer(costs[i++]);
            }
            while (end.size() < candidates && i <= j) {
                end.offer(costs[j--]);
            }

            int t1 = !front.isEmpty() ? front.peek() : Integer.MAX_VALUE;
            int t2 = !end.isEmpty() ? end.peek() : Integer.MAX_VALUE;
            if (t1 <= t2) {
                ans += t1;
                front.poll();
            } else {
                ans += t2;
                end.poll();
            }
        }
        return ans;
    }
}
