package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }
    public static List<List<Integer>> result;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), 0);
        return result;
    }

    public static void dfs(int[] candidate, int i, int target, List<Integer> cur, int sum) {
        if (sum == target) {
            result.add(List.copyOf(cur));
            return;
        }
        if (i >= candidate.length || sum > target) {
            return;
        }

        cur.add(candidate[i]);
        dfs(candidate, i, target, cur, sum + candidate[i]);

        cur.remove(cur.size() - 1);
        dfs(candidate, i + 1, target, cur, sum);
    }
}
