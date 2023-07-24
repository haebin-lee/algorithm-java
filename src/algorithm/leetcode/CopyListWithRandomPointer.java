package algorithm.leetcode;

import javafx.geometry.NodeOrientation;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {
//        Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//        Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;

        Node result = copyRandomList(node0);
    }

    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Map<Node, Node> pair = new HashMap<>();

        Node originPointer = head;
        while(originPointer != null) {
            pair.put(originPointer, new Node(originPointer.val));
            originPointer = originPointer.next;
        }

        originPointer = head;
        while(originPointer != null) {
            Node copied = pair.get(originPointer);

            // next
            copied.next = pair.get(originPointer.next);

            // random
            copied.random= pair.get(originPointer.random);

            originPointer = originPointer.next;
        }

        return pair.get(head);
    }
}
