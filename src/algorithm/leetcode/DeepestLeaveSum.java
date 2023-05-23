package algorithm.leetcode;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeaveSum {

    int deepest = 0;
    int sum = 0;

    public static void main(String[] args) {
    }

    public int deepestLeavesSum(TreeNode root) {
        sum = 0; deepest = 0;
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode node, int prevLevel) {
        if (node != null) {
            int curLevel = prevLevel + 1;
            if (node.left == null || node.right == null) { // if node is leave
                if (deepest < curLevel) {
                    sum = node.val;
                    deepest = curLevel;
                } else if (deepest == curLevel) {
                    sum += node.val;
                }
            }
            dfs(node.left, curLevel);
            dfs(node.right, curLevel);
        }
    }

    // Pass, runtime : 15.49%
    public int deepestLeavesSumWithBFS(TreeNode root) {
        sum = 0; deepest = 0;
        Queue<TreeNodeLevel> queue = new LinkedList<>();
        if (root != null)
            queue.offer(new TreeNodeLevel(root, 0));

        while (!queue.isEmpty()) {
            TreeNodeLevel cur = queue.poll();
            TreeNode curNode = cur.node;
            if (cur.level > deepest) {
                deepest = cur.level;
                sum = curNode.val;
            } else if (cur.level == deepest) {
                sum += curNode.val;
            }
            if (curNode.left!= null)
                queue.offer(new TreeNodeLevel(curNode.left, cur.level + 1));
            if (curNode.right != null)
                queue.offer(new TreeNodeLevel(curNode.right, cur.level + 1));
        }
        return sum;
    }

    public static class TreeNodeLevel {
        public TreeNode node;
        public int level;

        public TreeNodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

    }

    public int deepestLeavesSumWithBFSBetter(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;

        while(!queue.isEmpty()) {
            int size  = queue.size();
            sum = 0;
            for (int i = 0 ; i < size ; i ++) {
                TreeNode cur = queue.poll();
                sum += cur.val;

                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }
        return sum;
    }
}