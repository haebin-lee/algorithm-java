package algorithm.leetcode;

import com.sun.xml.internal.fastinfoset.algorithm.IntEncodingAlgorithm;
import javafx.util.Pair;

import java.util.*;

public class VerticalOrder {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        List<List<Integer>> result2 = verticalOrder(node1);

        System.out.println();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        List<List<Integer>> result = verticalOrder(n1);
        System.exit(0);


    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pop = queue.poll();
                TreeNode key = pop.getKey();
                Integer col = pop.getValue();

                List<Integer> values = map.getOrDefault(col, new ArrayList<>());
                values.add(key.val);
                map.put(col, values);

                if (pop.getKey().left != null) queue.offer(new Pair<>(pop.getKey().left, col - 1));
                if (pop.getKey().right != null) queue.offer(new Pair<>(pop.getKey().right, col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
