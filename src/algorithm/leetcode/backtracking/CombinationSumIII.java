package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args) {
        CombinationSumIII p = new CombinationSumIII();
        System.out.println(p.combinationSum3(3, 7)); // [[1,2,4]]
        System.out.println(p.combinationSum3(3, 9)); // [[1,2,6],[1,3,5],[2,3,4]]

    }

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        // k: number of itmes / n: sum
        result = new ArrayList<>();
        backtracking(1, new ArrayList<>(), 0, k, n);
        return result;
    }

    public void backtracking(int num, List<Integer> currentList, int currentSum, int k, int n) {
        if (num < 1 || num > 9)
            return;
        if (currentList.size() == k && currentSum == n) {
            result.add(List.copyOf(currentList));
            return;
        }
        if (currentList.size() >= k)
            return;
        if (currentSum >= n)
            return;

        currentList.add(num);
        backtracking(num + 1, currentList, currentSum + num, k, n);

        currentList.remove(currentList.size() - 1);
        backtracking(num + 1, currentList, currentSum, k, n);
    }
}
