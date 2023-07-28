package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructFromInNPost {

    public static void main(String[] args) {
//        Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//        Output: [3,9,20,null,null,15,7]
        int[] in = {9, 3, 15, 20, 7};
        int[] post = {9, 15, 7, 20, 3};
        TreeNode result = buildTree(in, post);
        System.out.println(result.val);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length ; i ++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }

    public static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd) return null;

        int val = postorder[postEnd];
        TreeNode node = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(val);
        int left = inRoot - inStart;
        node.left = buildTree(inorder, inStart, inStart + left - 1, postorder, postStart, postStart + left - 1, inMap);
        node.right = buildTree(inorder, inStart + left + 1, inEnd, postorder, postStart + left, postEnd - 1, inMap);
        return node;
    }
}
