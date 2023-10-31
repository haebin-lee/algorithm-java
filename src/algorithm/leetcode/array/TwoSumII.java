package algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumII {

    public static void main(String[] args) {
        TwoSumII p = new TwoSumII();
        System.out.println(Arrays.toString(p.twoSum(new int[]{2,7,11,15}, 9)));
    }
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> left = new HashMap<>(); // left - prev_idx
        for (int i = 0; i < numbers.length; i++) {
            if (left.containsKey(target - numbers[i])) {
                return new int[]{left.get(target - numbers[i]) + 1, i + 1};
            }
            left.put(numbers[i], i);
        }
        return new int[]{};
    }
}
