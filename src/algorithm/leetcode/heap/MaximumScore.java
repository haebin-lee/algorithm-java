package algorithm.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumScore {
    public static void main(String[] args) {
        MaximumScore p = new MaximumScore();
        System.out.println(p.maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3));
    }

    record Pair(int a, int b) {};
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }
        Arrays.sort(pairs, (x, y) -> Integer.compare(y.b, x.b));
        System.out.println(Arrays.toString(pairs));
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1); // what does k + 1 mean:

        long res = 0, sum = 0;
        for (Pair pair: pairs) {
            sum += pair.a;
            pq.add(pair.a);
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            if (pq.size() == k) {
                res = Math.max(res, sum * pair.b);
                System.out.println("res: " + res);
            }
        }
        return res;
    }

}
