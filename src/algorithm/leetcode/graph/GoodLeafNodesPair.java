package algorithm.leetcode.graph;

import algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodLeafNodesPair {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node.left = node2;
        node.right = node3;
        node2.right = node4;
        System.out.println(countPairs(node, 3));

//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//
//        System.out.println(countPairs(node1, 3));
    }

    static int count = 0;

    public static int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        count = 0;

        dfs(root, distance);
        return count;
    }
    private static List<Integer> dfs(TreeNode root, int distance) {
        if (root == null)
            return new ArrayList<>();
        if (root.left == null && root.right == null) {
            return List.of(1);
        }

        List<Integer> left = dfs(root.left, distance);
        List<Integer> right = dfs(root.right, distance);
        for (Integer l : left) {
            for (Integer r : right) {
                if (l + r <= distance)
                    count ++;
            }
        }
        List<Integer> merged = new ArrayList<>();
        left.forEach(m -> {
            if (m + 1 < distance)
                merged.add(m + 1);
        });
        right.forEach(m -> {
            if (m + 1 <distance)
                merged.add(m + 1);
        });
        return merged;
    }
}
