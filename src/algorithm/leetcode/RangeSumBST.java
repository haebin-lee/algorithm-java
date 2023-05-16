package algorithm.leetcode;

import java.util.Stack;

public class RangeSumBST {

    public int sum = 0;

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

        TreeNode node = tree.getRoot();

        RangeSumBST sumBST = new RangeSumBST();
        System.out.println(sumBST.rangeSumBST(node, 2, 3));

    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.val > low) {
            rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            rangeSumBST(root.right, low, high);
        }
        return sum;
    }

}
