package algorithm.leetcode;

import java.util.*;

public class BinaryTreeZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node.left = node2;
        node.right = node3;
        node3.left = node4;
        node3.right = node5;
        print(zigzagLevelOrder(node)); //[[3],[20,9],[15,7]]

//        TreeNode node = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        node.left = node2;
//        node.right = node3;
//        node2.left = node4;
//        node3.right = node5;
//        print(zigzagLevelOrder(node)); //[1 ],[3 2 ],[4 5 ],
    }

    // left to right : 1 right to left: -1
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int turn = -1; // 1: left to right -1: right to left
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> level = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                stack.push(node);
            }
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (turn > 0) {
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                } else {
                    if (node.right != null) queue.offer(node.right);
                    if (node.left != null) queue.offer(node.left);
                }
            }

            turn *= -1;
            result.add(level);
        }
        return result;
    }

    public static void print(List<List<Integer>> list) {
        for (List<Integer> integers : list) {
            System.out.print("[");
            integers.forEach(m -> System.out.print(m + " "));
            System.out.print("],");
        }
        System.out.println();
    }
}
