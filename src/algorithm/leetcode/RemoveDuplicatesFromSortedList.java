package algorithm.leetcode;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = deleteDuplicates(node1);
        System.exit(0);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode prev = head;
        ListNode current = prev.next;

        while (current != null) {
            if (prev.val == current.val) {
                prev.next = current.next;
                current = prev;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val)  {
                current.next = current.next.next;
            } else{
                current = current.next;
            }
        }
        return head;
    }
}
