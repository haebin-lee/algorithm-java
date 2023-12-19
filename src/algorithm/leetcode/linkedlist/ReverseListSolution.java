package algorithm.leetcode.linkedlist;

import algorithm.leetcode.ListNode;

public class ReverseListSolution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;//head of 2nd
        ListNode fast = head;//tail of 2st
        ListNode prev = null;//tail of 1nd
        ListNode l1 = head;//head of 1st

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // separating the list
        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }

    public ListNode reverse(ListNode head){ // reverse 2nd half of list
        ListNode prev = null;
        ListNode current = head;

        while(current != null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;

    }

    public void merge(ListNode l1, ListNode l2){
        while(l1 != null){
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;

            if(l1Next == null){
                break;
            }

            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
    }
}
