package algorithm.leetcode;

public class FlattenBT {

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        node.left = node2;
//        node.right = node5;
//        node2.left = node3;
//        node2.right = node4;
//        node5.right = node6;
//
//        flatten(node);

        TreeNode nnode = new TreeNode(1);
        TreeNode nnode2 = new TreeNode(2);
        TreeNode nnode3 = new TreeNode(3);
        nnode.right = nnode2;
        nnode2.left = nnode3;
        flatten(nnode);

        System.exit(0);

    }

    public static void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        makeFlat(root);
    }

    public static TreeNode makeFlat(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        TreeNode left = makeFlat(root.left);
        TreeNode right = makeFlat(root.right);
       if (left != null) {
            TreeNode last = findLast(left);
            last.right = right;
            root.right = left;
        } else {
           root.right = right;
       }
        root.left = null;
        return root;
    }

    public static TreeNode findLast(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return findLast(node.right);
    }
}
