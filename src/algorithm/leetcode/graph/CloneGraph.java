package algorithm.leetcode.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CloneGraph {

    public static void main(String[] args) {

    }

    static Map<Node, Node> oldToKnew;
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        oldToKnew = new HashMap<>();
        return clone(node);
    }

    static Node clone(Node old) {
        if (old == null) return null;
        if (oldToKnew.containsKey(old)) return oldToKnew.get(old);

        Node copy = new Node(old.val);
        oldToKnew.put(old, copy);

        for (Node nei: old.neighbors) {
            copy.neighbors.add(clone(nei));
        }
        return copy;
    }


    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
