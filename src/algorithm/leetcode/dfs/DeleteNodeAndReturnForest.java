package algorithm.leetcode.dfs;


import algorithm.leetcode.TreeNode;

import java.util.*;

public class DeleteNodeAndReturnForest {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6= new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        DeleteNodeAndReturnForest f = new DeleteNodeAndReturnForest();
        List<TreeNode> result = f.delNodes(node, new int[]{3, 5});


        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n4;
        n2.right = n3;

        DeleteNodeAndReturnForest f1 = new DeleteNodeAndReturnForest();
        List<TreeNode> result2 = f1.delNodes(n1, new int[]{3});

        System.exit(0);
    }
    public List<TreeNode> values = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        if (!toDeleteSet.contains(root.val)) {
            result.add(root);
        }

        dfs(root, toDeleteSet, result);

        return result;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> result) {
        if (node == null) {
            return null;
        }

        node.left = dfs(node.left, toDeleteSet, result);
        node.right = dfs(node.right, toDeleteSet, result);

        if (toDeleteSet.contains(node.val)) {
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
            }
            return null;
        }

        return node;
    }
}
