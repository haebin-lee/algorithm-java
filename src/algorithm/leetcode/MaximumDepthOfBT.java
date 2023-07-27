package algorithm.leetcode;

public class MaximumDepthOfBT {

    public static void main(String[] args) {
        // ans: 3
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(maxDepth(root));

    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
