package algorithm.leetcode.bfs;

import algorithm.leetcode.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TwoSum {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node.left = node3;
        node.right = node6;
        node3.left = node2;
        node3.right = node4;
        node6.right = node7;
        System.out.println(findTarget(node, 9));

    }

    public static boolean findTarget2(TreeNode root, int k) {
        if (root == null) return false;

        Queue<Integer> q = new LinkedList<>();
        q.offer(root.val);
        Set<Integer> nums = new HashSet<>();
        nums.add(root.val);
        nums.add(k - root.val);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0 ; i < size; i++) {
                Integer peek = q.poll();
                if (nums.contains(peek) || nums.contains(k - peek)) return true;
                nums.add(peek);
                nums.add(k - peek);

                q.offer(peek);
            }
        }
        return  true;
    }

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        Set<Integer> remainder = new HashSet<>();
        return findTarget(root, k, remainder);
    }
    public static boolean findTarget(TreeNode node, int k, Set<Integer> remainders) {
        if (node == null) return false;

        int remainder = k - node.val;
        if (remainders.contains(remainder)) {
            return true;
        }
        remainders.add(node.val);
        remainders.add(remainder);
        return findTarget(node.left, k, remainders) || findTarget(node.right, k, remainders);
    }
}
