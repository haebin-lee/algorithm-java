package algorithm.leetcode.bfs;

import algorithm.leetcode.TreeNode;

public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        n1.left = n3;
        n1.right = n2;
        n3.left = n5;

        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        t2.left = t1;
        t1.right = t4;
        t2.right = t3;
        t3.right = t7;

        TreeNode treeNode = mergeTrees(n1, t2);

        System.exit(1);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode newbie = null;
        if (root1 != null && root2 != null){
            newbie = new TreeNode(root1.val + root2.val);
        } else if (root1 != null) {
            newbie = new TreeNode(root1.val);
        } else if (root2 != null) {
            newbie = new TreeNode(root2.val);
        }

        if (newbie != null) {
            newbie.left = mergeTrees(root1 != null? root1.left : null, root2 != null? root2.left : null);
            newbie.right = mergeTrees(root1 != null? root1.right : null, root2 != null? root2.right : null);
        }
        return newbie;
    }

    public static TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root2.left, root2.right);
        return root1;
    }
}
