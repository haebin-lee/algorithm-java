package algorithm.leetcode.backtracking;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {

    public static void main(String[] args) {
        subsets(new int[]{1, 2});
    }

    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> subset = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return result;
    }

    public static void dfs(int[] nums, int i) {
        if (i >= nums.length) {
            System.out.println(subset);
            result.add(List.copyOf(subset));
            return;
        }

        // decision to include i
        subset.add(nums[i]);
        dfs(nums, i + 1);

        // decision not to include i
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1);
    }
}
