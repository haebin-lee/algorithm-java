package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class EvenValuedGrandParent {

    public static void main(String[] args) {

    }

    // PAST at once, but runtime is quite slow.
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> parents = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode grandParent = queue.poll();
            if (grandParent.val % 2 == 0) {
                if (grandParent.left != null)
                    parents.offer(grandParent.left);
                if (grandParent.right != null)
                    parents.offer(grandParent.right);
            }
            if (grandParent.left != null)
                queue.offer(grandParent.left);
            if (grandParent.right != null)
                queue.offer(grandParent.right);
        }

        int sum = 0;
        while(!parents.isEmpty()) {
            TreeNode parent = parents.poll();
            if (parent.left != null)
                sum += parent.left.val;
            if (parent.right != null)
                sum += parent.right.val;
        }

        return sum;
    }

    public int sumEvenGrandparentImproved(TreeNode root) {
        if (root != null)
            return 0;
        int sum = 0 ;
        if (root.val % 2 == 0) {
            if (root.left != null && root.left.left != null) {
                sum += root.left.left.val;
            }
            if (root.left != null && root.left.right != null) {
                sum += root.left.right.val;
            }
            if (root.right != null && root.right.left != null) {
                sum += root.right.left.val;
            }
            if (root.right != null && root.right.right != null) {
                sum += root.right.right.val;
            }
        }
        sum += sumEvenGrandparentImproved(root.left) + sumEvenGrandparent(root.right);
        return sum;
    }
}
