package algorithm.leetcode;

public class SortList {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        node4.next = node2;
        node2.next = node1;
        node1.next = node3;
        ListNode r = sortList(node4);
        System.exit(2);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMedian(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public static ListNode findMedian(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = midPrev == null? head: midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public static ListNode merge(ListNode a, ListNode b) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (a != null && b != null) {
            if (a.val < b.val) {
                current.next = a;
                a = a.next;
                current = current.next;
            } else {
                current.next = b;
                b = b.next;
                current = current.next;
            }
        }
        current.next = (a != null) ? a : b;
        return result.next;
    }
}
