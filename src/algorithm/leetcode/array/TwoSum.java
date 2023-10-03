package algorithm.leetcode.array;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] r = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(r));

        int[] r2 = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(r2));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // num:idx
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
