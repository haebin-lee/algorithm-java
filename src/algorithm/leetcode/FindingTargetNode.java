package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FindingTargetNode {

    public static void main(String[] args) {

    }

    TreeNode answer;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return  null;
        if (original == target) {
            answer = cloned;
        }
        getTargetCopy(original.left, cloned.left, target);
        getTargetCopy(original.right, cloned.right, target);

        return answer;
    }

    public static Queue<TreeNode> originalQ = new LinkedList<>();
    public static Queue<TreeNode> clonedQ = new LinkedList<>();
    public final TreeNode getTargetCopy2(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || cloned == null || target == null)
            return null;

        originalQ.add(original);
        clonedQ.add(cloned);

        while (!originalQ.isEmpty()) {
            TreeNode org = originalQ.poll();
            TreeNode clo = clonedQ.poll();
            if (org == target) {
                return clo;
            }

            if (org.left != null) {
                originalQ.add(org.left);
                clonedQ.add(clo.left);
            }

            if(org.right != null) {
                originalQ.add(org.right);
                clonedQ.add(clo.right);
            }
        }
        return null;
    }

}
