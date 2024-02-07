package algorithm.leetcode.heap;

import java.util.PriorityQueue;

public class TotalWorker {

    public static void main(String[] args) {
        TotalWorker p = new TotalWorker();
        System.out.println(p.totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));
    }
    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> front = new PriorityQueue<>();
        PriorityQueue<Integer> back = new PriorityQueue<>();
        int n = costs.length;
        int i = 0, j = n - 1;
        long total = 0;
        int step = 0;
        while (k-- >0) {
            while (i < n && front.size() < candidates) {
                front.offer(costs[i++]);
            }
            while (j >= 0 && back.size() < candidates) {
                back.offer(costs[j--]);
            }
            System.out.println("step "+ k + " " + front.peek() + " " + back.peek());
            if (front.peek() >= back.peek()) {
                total += front.poll();
            } else {
                total += back.poll();
            }
            step++;
        }
        return total;
    }
}
