package algorithm.leetcode.dfs;

import algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        List<Integer> leaf1 = new ArrayList<>();
        dfs(root1, leaf1);

        List<Integer> leaf2 = new ArrayList<>();
        dfs(root2, leaf2);

        if (leaf1.size() != leaf2.size()) return false;
        for (int i = 0; i < leaf1.size(); i++) {
            if (leaf1.get(i) != leaf2.get(i)) return false;
        }
        return true;
    }
    public void dfs(TreeNode node, List<Integer> leaf) {
        if (node == null) return;
        if (node.left == null && node.right == null)
            leaf.add(node.val);
        dfs(node.left, leaf);
        dfs(node.right, leaf);
    }
}
