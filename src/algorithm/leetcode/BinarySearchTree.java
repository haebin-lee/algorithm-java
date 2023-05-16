package algorithm.leetcode;

public class BinarySearchTree {

    private TreeNode root;

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(1);
        tree.insert(7);
        tree.insert(4);
        tree.insert(3);
        tree.insert(9);
        tree.insert(5);
        tree.insert(8);
        tree.insert(2);

        tree.printInOrder();
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int val) {
        root = insertNode(root, val);
    }

    public TreeNode insertNode(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insertNode(node.left, val);
        } else if (val > node.val) {
            node.right = insertNode(node.right, val);
        }
        return node;
    }

    public void printInOrder() {
        printInOrderTraversal(root);
    }

    public void printInOrderTraversal(TreeNode node) {
        if (node != null) {
            printInOrderTraversal(node.left);
            System.out.print(node.val + " ");
            printInOrderTraversal(node.right);
        }
    }

}
