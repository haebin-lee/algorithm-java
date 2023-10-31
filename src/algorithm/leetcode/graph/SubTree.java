package algorithm.leetcode.graph;

import algorithm.leetcode.TreeNode;

public class SubTree {

    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root0 = new TreeNode(0);
        root3.left = root4;
        root3.right = root5;
        root4.left = root1;
        root4.right = root2;
        root2.left = root0;

        TreeNode subRoot4 = new TreeNode(4);
        TreeNode subRoot1 = new TreeNode(1);
        TreeNode subRoot2 = new TreeNode(2);
        subRoot4.left = subRoot1;
        subRoot4.right = subRoot2;

        SubTree t = new SubTree();
        System.out.println(t.isSubtree(root3, subRoot4));;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return findSameRoot(root, subRoot);
    }
    public boolean findSameRoot(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (root.val == subRoot.val) {
            TreeNode pointer = subRoot;
            return traverse(pointer, root);
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean traverse(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot != null) return false;
        if (root != null && subRoot == null) return false ;
        if (root == null && subRoot == null) return true;

        if (root.val == subRoot.val) {
            return traverse(root.left, subRoot.left) && traverse(root.right, subRoot.right);
        }
        return false;
    }
}
