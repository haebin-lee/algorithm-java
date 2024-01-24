package algorithm.leetcode.binarytree;

import algorithm.leetcode.ListNode;
import algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {

    public static void main(String[] args) {
        LeafSimilar p = new LeafSimilar();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(200);
        a1.left = a2;
        a1.right = a3;
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(200);
        b1.left = b2;
        b1.right = b3;
        System.out.println(p.leafSimilar(a1, b1));
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        bfs(root1, r1);
        System.out.println(r1);

        List<Integer> r2 = new ArrayList<>();
        bfs(root2, r2);
        System.out.println(r2);
        System.out.println(r1.size() + " " + r2.size());
        if (r1.size() != r2.size()) return false;
        for (int i = 0; i < r1.size(); i++) {
            if (r1.get(i) != r2.get(i)) {
                System.out.println(r1.get(i) + " " + r2.get(i));
                return false;
            }
        }
        return true;
    }

    public void bfs(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }
        bfs(node.left, result);
        bfs(node.right, result);
    }

}
