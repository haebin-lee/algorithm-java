package algorithm.leetcode.linkedlist;

import algorithm.leetcode.ListNode;
import algorithm.leetcode.ListNodeHelper;

import java.util.List;

public class DeleteMiddleNode {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        DeleteMiddleNode p = new DeleteMiddleNode();
        ListNodeHelper.print(p.deleteMiddle(n1));

        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(4);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        ListNodeHelper.print(p.deleteMiddle(s1));

        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(1);
        a1.next = a2;
        ListNodeHelper.print(p.deleteMiddle(a1));

        // todo 1개 있을 대는 ?
        ListNode b1 = new ListNode(2);
        ListNodeHelper.print(p.deleteMiddle(b1));

    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
