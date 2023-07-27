package algorithm.leetcode;

public class SameTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node1_1 = new TreeNode(2);
        TreeNode node1_2 = new TreeNode(3);
        root1.left = node1_1;
        root1.right = node1_2;

        TreeNode root2 = new TreeNode(1);
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node2_2 = new TreeNode(3);
        root2.left = node2_1;
        root2.right = node2_2;

        System.out.println(isSameTree(root1, root2));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        boolean current = false;
        boolean left = true, right = true;
        if (p != null && q != null && p.val == q.val) {
            current = true;
            left = isSameTree(p.left, q.left);
            right = isSameTree(p.right, q.right);
        }
        return current && left && right;
    }
}
