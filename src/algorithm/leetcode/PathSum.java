package algorithm.leetcode;

public class PathSum {

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(5);
//        TreeNode node1 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(8);
//        TreeNode node3 = new TreeNode(11);
//        TreeNode node4 = new TreeNode(13);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(7);
//        TreeNode node7 = new TreeNode(2);
//        TreeNode node8 = new TreeNode(1);
//
//        node.left = node1;
//        node.right = node2;
//        node1.left = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node5.right = node8;
//
//        System.out.println(hasPathSum(node, 22)); // true

//        TreeNode node = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        node.left = node2;
//        node.right = node3;
//        System.out.println(hasPathSum(node, 5));

        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node.left = node2;
        System.out.println(hasPathSum(node, 1)); // false;

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPathSumHelper(root, targetSum, 0);
    }

    public static boolean hasPathSumHelper(TreeNode root, int targetSum, int current) {
        if (root == null)
            return false;
        current += root.val;
        if (root.left == null && root.right == null)
            return current == targetSum;
        return hasPathSumHelper(root.left, targetSum, current) || hasPathSumHelper(root.right, targetSum, current);
    }

}
