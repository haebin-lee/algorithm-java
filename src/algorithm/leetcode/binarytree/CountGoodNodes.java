package algorithm.leetcode.binarytree;

import algorithm.leetcode.TreeNode;

public class CountGoodNodes {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;

        CountGoodNodes p = new CountGoodNodes();
        System.out.println(p.goodNodes(n1));

    }

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode node, int largest) {
        if (node == null) return 0;
        System.out.println("current: " + node.val);
        if (node.left == null &&  node.right == null) {
            if (largest <= node.val) return 1;
        }
        int left = dfs(node.left, Math.max(largest, node.val));
        int right = dfs(node.right, Math.max(largest, node.val));
        return left + right + (largest <= node.val ? 1 : 0);
    }

}
