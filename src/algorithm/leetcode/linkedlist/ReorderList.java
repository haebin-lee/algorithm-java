package algorithm.leetcode.linkedlist;

import algorithm.leetcode.ListNode;

public class ReorderList {

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

        ReorderList reorder = new ReorderList();
        reorder.reorderList(node1);
        ListNode.display(node1);
    }

    public void reorderList(ListNode head) {
        if (head == null) return;

        // find mid
        ListNode mid = mid(head);
        System.out.print("head: ");
        ListNode.display(head);
        System.out.print("mid: ");
        ListNode.display(mid);
        // reverseList(right)
        ListNode right = reverseList(mid);
        System.out.print("reversed : ");
        ListNode.display(right);
//        // merge
        merge(head, right);
    }

    public ListNode mid(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow == null ? head : slow.next;
            fast = fast.next.next;
        }
        ListNode prev = slow;
        slow = slow.next;
        prev.next = null;
        return slow;
    }

    public ListNode reverseList(ListNode node) {
        ListNode temp = null;
        ListNode prev = null;
        ListNode next = node;
        while (next != null) {
            temp = new ListNode(next.val);
            temp.next = prev;
            next = next.next;
            prev = temp;
        }
        return temp;
    }

    public void merge(ListNode head, ListNode reverse){
        ListNode l1 = head;
        ListNode l2 = reverse;
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
