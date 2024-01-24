package algorithm.leetcode.binarytree;

import algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSum {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(-3);
        n1.left = n2;
        n1.right = n3;

        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(11);
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;

        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(-2);
        TreeNode n9 = new TreeNode(1);
        n4.left = n7;
        n4.right = n8;
        n5.right = n9;

        PathSum p = new PathSum();
        System.out.println(p.pathSum3(n1, 8));
        System.out.println(p.pathSum(n1, 22));
    }

    // version3
    Map<Long, Integer> map;
    int count;
    public int pathSum3(TreeNode root, int targetSum) {
        map = new HashMap<>();
        count = 0;
        dfs(root, 0, (long) targetSum);
        return count;
    }

    public void dfs(TreeNode root, long preSum, long targetSum) {
        if (root == null) return;
        preSum += root.val;

        count += map.getOrDefault(preSum - targetSum, 0);
        if (targetSum == preSum) count ++;

        map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        dfs(root.left, preSum, targetSum);
        dfs(root.right, preSum, targetSum);

        map.put(preSum, map.get(preSum) - 1);
    }

    /// version2
    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;
        pathSumHelper(root, targetSum, 0);
        pathSum2(root.left, targetSum);
        pathSum2(root.right, targetSum);

        return total;
    }

    void pathSumHelper(TreeNode root, int targetSum, long currentSum) {
        if (root == null) return;
        currentSum += root.val;
        if (currentSum == targetSum) total++;
        pathSumHelper(root.left, targetSum, currentSum);
        pathSumHelper(root.right, targetSum, currentSum);
    }

    // version 1
    public int total = 0;

    public int pathSum(TreeNode root, int targetSum) {
        total = 0;
        dfs (root, targetSum, new ArrayList<>());
        return total;
    }

    public void dfs(TreeNode node, int targetSum, List<Long> sub) {
        if (node == null) return;

        for (int i = 0; i < sub.size(); i++) {
            long value = sub.get(i) + node.val;
            if (value == targetSum) total ++;
            sub.set(i, value);
        }
        if (node.val == targetSum) total++;
        sub.add((long) node.val);
        dfs(node.left, targetSum, new ArrayList<>(sub));
        dfs(node.right, targetSum, new ArrayList<>(sub));
    }
}
