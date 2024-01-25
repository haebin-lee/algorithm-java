package algorithm.leetcode.heap;

import java.util.PriorityQueue;

public class MaximumSubsequenceScore {

    public static void main(String[] args) {

    }

    record Pack(int num, int idx){};
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // 무조건 nums2에 잇는걸 크건로 뽑아도 될까
        PriorityQueue<Pack> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.num, a.num));
        for (int i = 0; i < nums2.length; i++) {
            pq.offer(new Pack(nums2[i], i));
        }

        long sum = 0;
        long min = Integer.MAX_VALUE;
        while (k-- > 0) {
            Pack pack = pq.poll();
            sum += nums1[pack.idx];
            min = Math.min(min, nums2[pack.idx]);
        }
        return sum * min;
    }
}
