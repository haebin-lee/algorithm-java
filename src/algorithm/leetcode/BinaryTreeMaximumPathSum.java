package algorithm.leetcode;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        node.left = node2;
//        node.right = node3;
//        BinaryTreeMaximumPathSum p1 = new BinaryTreeMaximumPathSum();
//        System.out.println(p1.maxPathSum(node));

//        TreeNode node = new TreeNode(-10);
//        TreeNode node2 = new TreeNode(9);
//        TreeNode node3 = new TreeNode(20);
//        TreeNode node4 = new TreeNode(15);
//        TreeNode node5 = new TreeNode(7);
//        node.left = node2;
//        node.right = node3;
//        node3.left = node4;
//        node3.right = node5;
//        BinaryTreeMaximumPathSum p2 = new BinaryTreeMaximumPathSum();
//        System.out.println(p2.maxPathSum(node));

        TreeNode node = new TreeNode(9);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(-6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(-6);
        TreeNode node8 = new TreeNode(-6);
        TreeNode node9 = new TreeNode(-6);
        node.left = node2;
        node.right = node3;
        node3.left = node4;
        node3.right = node5;
        node5.left = node6;
        node6.left = node7;
        node6.right = node8;
        node7.left = node9;
        BinaryTreeMaximumPathSum p3 = new BinaryTreeMaximumPathSum();
        System.out.println(p3.maxPathSum(node));

    }

    public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int val = root.val;
        int leftmost = helper(root.left);
        int rightmost = helper(root.right);

        int sum = root.val + Math.max(leftmost, 0) + Math.max(rightmost, 0);
        if (this.max < sum)
            this.max = sum;
        root.val = Math.max(val, Math.max(leftmost + val, rightmost + val));
        System.out.println("currentNode: " + val + " -> " + root.val);
        return root.val;
    }

}
