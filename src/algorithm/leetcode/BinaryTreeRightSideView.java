package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(4);
        node.left = node2;
        node.right = node3;
        node2.right = node4;
        node3.right = node5;
        BinaryTreeRightSideView p1 = new BinaryTreeRightSideView();
        print(p1.rightSideView2(node));
//        print(rightSideView(node));
    }

    // top to bottom
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
        }

        return result;
    }


    public int max = 0;
    public List<Integer> rightSideView2(TreeNode root) {
        return rightSideViewHelper(root, 1, new ArrayList<>());
    }

    public List<Integer> rightSideViewHelper(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return result;
        }

        if (max < level) {
            result.add(root.val);
            max = level;
        }

        rightSideViewHelper(root.right, level + 1, result);
        rightSideViewHelper(root.left, level + 1, result);
        return result;
    }

    public static void print(List<Integer> list) {
        list.forEach(m -> System.out.print(m + " "));
        System.out.println();
    }

}
