package algorithm.leetcode.twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKPairs {

    public static void main(String[] args) {
        MaxNumberOfKPairs p = new MaxNumberOfKPairs();
        System.out.println(p.maxOperations2(new int[]{1,2,3,4}, 5)); // 2
        System.out.println(p.maxOperations2(new int[]{3,1,3,4,3}, 6)); // 1
    }

    public int maxOperations2(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] == k) {
                ans++;
                i++; j--;
            } else if (nums[i] + nums[j] < k) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }

    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            if (map.containsKey(k - num) && map.get(k - num) > 0) {
                ans++;
                map.compute(k - num, (key, value) -> value - 1);
            } else {
                map.compute(num, (key, value) -> value == null? 1: value + 1);
            }
        }
        return ans;
    }
}
