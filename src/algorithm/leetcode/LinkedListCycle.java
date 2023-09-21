package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {


    public static void main(String[] args) {
        //head = [3,2,0,-4], pos = 1
//        ListNode node1 = new ListNode(3);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(0);
//        ListNode node4 = new ListNode(-4);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node2;
//        System.out.println(hasCycle(node1));

//        ListNode node5 = new ListNode(5);
//        System.out.println(hasCycle(node5));
//
//        ListNode node6 = new ListNode(6);
//        ListNode node7 = new ListNode(7);
//        ListNode node8 = new ListNode(8);
//        node6.next = node7;
//        node7.next = node8;
//        System.out.println(hasCycle(node6));

        ListNode node10 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        node10.next = node11;
        node11.next = node10;
        System.out.println(hasCycle(node10));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }
}
