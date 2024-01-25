package algorithm.leetcode.heap;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        KthLargest p = new KthLargest();
        System.out.println(p.findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // 5

        System.out.println(p.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4)); // 4
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((p, q) -> Integer.compare(q, p));
        for (int num : nums) {
            pq.offer(num);
        }
        while (k-- > 1) {
            pq.poll();
        }
        return pq.poll();
    }
}
