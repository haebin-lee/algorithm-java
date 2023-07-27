package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeHelper {

    public static void main(String[] args) {
        TreeNode root2 = new TreeNode(3);
        TreeNode node2_1 = new TreeNode(9);
        TreeNode node2_2 = new TreeNode(20);
        TreeNode node2_3 = new TreeNode(15);
        TreeNode node2_4 = new TreeNode(7);
        root2.left = node2_1;
        root2.right = node2_2;
        node2_2.left = node2_3;
        node2_2.right = node2_4;
        printPreOrder(root2);
        printInOrder(root2);
    }

    public static void printBST(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0 ; i < level ; i++) {
                TreeNode node = queue.poll();
                if (node != null)
                    System.out.print(node.val + " ");

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            System.out.println();
        }
    }

    public static void printPreOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        System.out.print("pre-order: ");
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        System.out.println();
    }

    public static void printInOrder(TreeNode root) {
        System.out.print("in-order: ");
        inOrder(root);
        System.out.println();
    }

    public static void inOrder(TreeNode root) {
        if (root.left != null) inOrder(root.left);
        System.out.print(root.val + " ");
        if (root.right != null) inOrder(root.right);
    }

}
