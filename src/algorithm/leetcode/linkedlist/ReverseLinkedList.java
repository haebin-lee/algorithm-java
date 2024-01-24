package algorithm.leetcode.linkedlist;

import algorithm.leetcode.ListNode;
import algorithm.leetcode.ListNodeHelper;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ReverseLinkedList p = new ReverseLinkedList();
        ListNodeHelper.print(p.reverseList(n1));

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev;
        ListNode current = head;
        ListNode next = head.next;
        boolean tail = false;
        while (next != null) {
            prev = current;
            current = next;
            next = next.next;
            current.next = prev;
            if(!tail) {
                prev.next = null;
                tail = true;
            }
        }
        return current;
    }
}
