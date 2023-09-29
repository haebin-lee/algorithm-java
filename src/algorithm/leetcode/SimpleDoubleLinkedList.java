package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SimpleDoubleLinkedList {

    private int capacity;
    private N head; // remove from here
    private N tail; // add to here
    private Map<Long, N> dic;

    public static void main(String[] args) {
        SimpleDoubleLinkedList t = new SimpleDoubleLinkedList(3);
        N node1 = new N(1);
        N node2 = new N(2);
        N node3 = new N(3);
        t.add(node1);
        t.add(node2);
        t.add(node3);
        t.print();
        t.remove();
        t.print();
        N node4 = new N(4);
        t.add(node4);
        t.print();
        N node5 = new N(5);
        t.add(node3, node5);
        t.print();
    }

    public SimpleDoubleLinkedList(int capacity) {
        this.capacity = capacity;
        this.head = new N(-1);
        this.tail = new N(-1);
        this.head.next = tail;
        this.tail.prev = head;
        dic = new HashMap<>();
    }

    public void add(N newbie){
        N prev = tail.prev;
        newbie.prev = prev;
        newbie.next = tail;
        prev.next = newbie;
        tail.prev = newbie;
    }

    public void add(N node, N newbie) {
        // node 뒤에 추가한다.
        newbie.next = node.next;
        newbie.prev = node;
        node.next.prev = newbie;
        node.next = newbie;
    }

    public void remove() {
        if (head.next != tail) {
            N remove = head.next;
            head.next = remove.next;
            remove.prev = head;
        }
    }

    public void print() {
        N cur = head.next;
        while (cur != tail) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static class N {
        public int value;
        public N prev;
        public N next;

        public N(int value) {
            this.value = value;
        }
    }
}
