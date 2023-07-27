package algorithm.leetcode;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println(isSymmetric2(root));

//        TreeNode root2 = new TreeNode(1);
//        TreeNode node2_1 = new TreeNode(2);
//        TreeNode node2_2 = new TreeNode(2);
//        TreeNode node2_3 = new TreeNode(3);
//        TreeNode node2_4 = new TreeNode(3);
//        root2.left = node2_1;
//        root2.right = node2_2;
//        node1.right = node2_3;
//        node2.right = node2_4;
//        System.out.println(isSymmetric2(root2));
//
//
//        TreeNode root3 = new TreeNode(2);
//        TreeNode node3_1 = new TreeNode(3);
//        TreeNode node3_2 = new TreeNode(3);
//        TreeNode node3_3 = new TreeNode(4);
//        TreeNode node3_4 = new TreeNode(5);
//        TreeNode node3_5 = new TreeNode(4);
//        root3.left = node3_1;
//        root3.right = node3_2;
//        node3_1.left = node3_3;
//        node3_1.right = node3_4;
//        node3_2.right = node3_5;
//        System.out.println(isSymmetric2(root3));


    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        if (root.right != null) invertNode(root.right);
        return isSymmetric(root.left, root.right);
    }

    public static void invertNode(TreeNode node) {
        if (node == null)
            return ;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertNode(node.left);
        invertNode(node.right);
    }

    public static boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }

        boolean current = node1.val == node2.val;
        return current &&
                isSymmetric(node1.left, node2.left) &&
                isSymmetric(node1.right, node2.right);
    }

    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        return isSymmetric2(root.left, root.right);
    }

    public static boolean isSymmetric2(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null ) {
            return false;
        }
        return node1.val == node2.val && isSymmetric2(node1.left, node2.right) && isSymmetric2(node1.right, node2.left);
    }
}
