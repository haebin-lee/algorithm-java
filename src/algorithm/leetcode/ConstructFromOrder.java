package algorithm.leetcode;

import algorithm.util.ArrayUtil;
import apple.laf.JRSUIUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ConstructFromOrder {

    public static void main(String[] args) {
        // Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        // Output: [3,9,20,null,null,15,7]
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode result = buildTree(preorder, inorder);
        System.out.println(result.val);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);

    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        int val = preorder[preStart];
        int inRoot = inMap.get(val);
        int inLeft = inRoot - inStart;

        TreeNode root = new TreeNode(val);
        root.left = buildTree(preorder, preStart + 1, preStart + inLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + inLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }

}
