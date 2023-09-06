package algorithm.leetcode.bfs;

import algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllTheLonelyNodes {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node.left = node2;
        node.right = node3;
        node2.right = node4;
        List<Integer> result = getLonelyNodes(node);
        System.out.println(result);

        TreeNode n = new TreeNode(7);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        n.left = n1;
        n.right = n4;
        n1.left = n6;
        n4.left = n5;
        n4.right = n3;
        n3.right = n2;
        List<Integer> result1 = getLonelyNodes(n);
        System.out.println(result1);

        TreeNode t = new TreeNode(11);
        TreeNode t99 = new TreeNode(99);
        TreeNode t88 = new TreeNode(88);
        TreeNode t77 = new TreeNode(77);
        TreeNode t66 = new TreeNode(66);
        TreeNode t55 = new TreeNode(55);
        TreeNode t44 = new TreeNode(44);
        TreeNode t33 = new TreeNode(33);
        TreeNode t22 = new TreeNode(22);
        t.left = t99;
        t99.left = t77;
        t77.left = t55;
        t55.left = t33;
        t.right = t88;
        t88.right = t66;
        t66.right = t44;
        t44.right = t22;
        List<Integer> result2 = getLonelyNodes(t);
        System.out.println(result2);

    }
    public static List<Integer> getLonelyNodes(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        getLonelyNodes(root, result);
        return result;
    }

    public static void getLonelyNodes(TreeNode root, List<Integer> result) {
        if (root.left != null && root.right == null)
            result.add(root.left.val);
        if (root.left == null && root.right != null)
            result.add(root.right.val);

        if (root.left != null) getLonelyNodes(root.left, result);
        if (root.right != null) getLonelyNodes(root.right, result);
    }
}
