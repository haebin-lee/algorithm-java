package algorithm.leetcode.linkedlist;

import algorithm.leetcode.ListNode;

public class ReverseList {

    public static void main(String[] args) {
       ListNode node1 = new ListNode(1);
       ListNode node2 = new ListNode(2);
       ListNode node3 = new ListNode(3);
       ListNode node4 = new ListNode(4);
       ListNode node5 = new ListNode(5);
       node1.next = node2;
       node2.next = node3;
       node3.next = node4;
       node4.next = node5;

       ReverseList r = new ReverseList();
       ListNode result = r.reverseList(node1);
       ListNode.display(result);
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode prev = null;
        ListNode next = head;
        while (next != null) {
            temp = new ListNode(next.val);
            temp.next = prev;
            next = next.next;
            prev = temp;
        }
        return temp;
    }
}
