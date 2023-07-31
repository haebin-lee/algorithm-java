package algorithm.leetcode;

public class SumRootToLeafNode {

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        node.left = node2;
//        node.right = node3;
//        System.out.println(sumNumbers(node)); // 25

        TreeNode node = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(sumNumbers(node));

    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbers(root, 0, 0);
    }

    public static int sumNumbers(TreeNode root, int current, int total) {
        if (root == null) return total;
        current = current * 10 + root.val;
        if (root.left == null && root.right == null) {
            total += current;
            return total;
        }
        return sumNumbers(root.left, current, total) + sumNumbers(root.right, current, total);
    }
}
