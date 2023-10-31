package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {

    public static void main(String[] args) {

    }

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 1 ; i++) {
            int left = Math.min(lower, nums[i]);
            int right = Math.min(upper, nums[i+1]);

            if (left + 1 < right) {
                List<Integer> sub = new ArrayList<>();
                sub.add(nums[i] + 1);
                sub.add(nums[i+1] - 1);
                result.add(sub);
            }
        }
        return result;
    }
}
