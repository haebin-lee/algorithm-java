package algorithm.leetcode.dfs;

import algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteNodeAndReturnForest2 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6= new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        DeleteNodeAndReturnForest2 f = new DeleteNodeAndReturnForest2();
        List<TreeNode> result = f.delNodes(node, new int[]{3, 5});


        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n4;
        n2.right = n3;

        DeleteNodeAndReturnForest2 f1 = new DeleteNodeAndReturnForest2();
        List<TreeNode> result2 = f1.delNodes(n1, new int[]{3});

        System.exit(0);
    }
    public List<TreeNode> values = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        TreeNode newRoot = postOrder(root, set);
        if (newRoot != null) values.add(newRoot);

        return values;
    }

    public TreeNode postOrder(TreeNode root, Set<Integer> set) {
        if (root == null) return null;
        root.left = postOrder(root.left, set);
        root.right = postOrder(root.right, set);

        if (set.contains(root.val)) {
            if (root.left != null)
                values.add(root.left);
            if (root.right != null)
                values.add(root.right);
            return null;
        }
        return root;
    }


}
