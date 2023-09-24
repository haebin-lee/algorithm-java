package algorithm.leetcode;

import java.rmi.UnexpectedException;

public class RemoveDuplicatesFromSortedList2 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode result = deleteDuplicates(node1);
        System.exit(0);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null && current.next != null)  {
            if (current.val == current.next.val) {
                ListNode check = current;
                while (check != null && current.val == check.val) {
                    check = check.next;
                }
                if (prev == null) head = check;
                else prev.next = check;
                current = check;
            } else {
                prev = current;
                current = current.next;
            }

        }
        return head;
    }

}
