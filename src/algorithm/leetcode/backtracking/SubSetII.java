package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }

    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<>());
        return result;
    }

    public static void backtracking(int[] nums, int i, List<Integer> cur) {
        if (i == nums.length) {
            result.add(List.copyOf(cur));
            return;
        }

        cur.add(nums[i]);
        backtracking(nums, i + 1, cur);

        while (i + 1 < nums.length  && nums[i] == nums[i + 1])
            i += 1;

        cur.remove(cur.size() - 1);
        backtracking(nums, i + 1, cur);
    }
}
