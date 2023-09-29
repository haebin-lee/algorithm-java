package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {
    int capacity = 0;

    public ListNode head;
    public ListNode tail;

    public Map<Integer, ListNode> dic;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dic = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void add(ListNode node) {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!dic.containsKey(key)) return -1;

        ListNode node = dic.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (dic.containsKey(key)) {
            ListNode old = dic.get(key);
            remove(old);
        }
        ListNode node = new ListNode(key, value);
        dic.put(key, node);
        add(node);

        if (dic.size() > capacity) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            dic.remove(nodeToDelete.key);
        }
    }
    static class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}