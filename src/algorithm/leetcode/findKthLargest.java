package algorithm.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class findKthLargest {

    public static void main(String[] args) {
        System.out.println(findKthLargestWithCountingSort(new int[]{3,2,1,5,6,4}, 2));
    }
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

    public static int findKthLargestWithCountingSort(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            int j = 0;
            while (j < count[i]) {
                nums[idx++] = i;
                j++;
            }

        }
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }
}
