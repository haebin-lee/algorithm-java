package algorithm.leetcode;

import java.util.*;

public class TopKFrequentElement {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent2(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent2(new int[]{1}, 1)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num: nums) {
            frequency.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequency::get));
        for (int num: frequency.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }


        int[] result = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            result[i] = minHeap.poll();
        }
        return result;
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        List<Integer>[] items = new ArrayList[nums.length + 1];
        for (int i = 0 ; i < items.length; i++) {
            items[i] = new ArrayList<>();
        }

        for (Integer key : frequency.keySet()) {
            items[frequency.get(key)].add(key);
        }

        List<Integer> flattened = new ArrayList<>();
        for (int i = items.length - 1; i >= 0; i--) {
            flattened.addAll(items[i]);
        }

        int[] result = new int[k];
        for (int i = 0; i < k ; i++) {
            result[i] = flattened.get(i);
        }
        return result;
    }
}
