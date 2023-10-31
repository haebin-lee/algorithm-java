package algorithm.leetcode.array;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class PathSum {

    public static void main(String[] args) {
        PathSum p = new PathSum();
        System.out.println(p.pathSum(new int[]{113,215,221}));
        //System.out.println(p.pathSum(new int[]{113,221}));
    }

    int ans = 0;
    Map<Integer, Integer> values;

    public int pathSum2(int[] nums) {
        values = new HashMap<>();
        for(int num: nums) {
            values.put(num/10, num%10); // wow
        }
        dfs(nums[0] / 10, 0);
        return sum;
    }

    private void dfs(int node, int sum) {
        if (!values.containsKey(node)) return;
        sum += values.get(node);

        int depth = node/10, pos = node % 10;
        int left = (depth + 1) * 10 + 2 * pos - 1;
        int right = left + 1;

        if (!values.containsKey(left) && !values.containsKey(right)){
            ans += sum;
        } else{
            dfs(left, sum);
            dfs(right, sum);
        }
    }


    // 거의 다된거 같은데..
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int temp = nums[nums.length - 1];
        int a = temp / 100 + 1, b = 9;
        int[][] matrix = new int[a][b];
        for (int num: nums) {
            int i = num / 100;
            int j = (num % 100) / 10;
            matrix[i][j] = num % 100 % 10;
        }

        for (int j = 0; j < b; j++) {
            traverse(matrix, a - 1, j);
        }
        return sum;
    }
    int sum = 0;
    public void traverse(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0) return;
        if (matrix[i][j] == 0) return;

        sum += matrix[i][j];

        traverse(matrix, i - 1, (j + 1)/ 2);
    }
}
