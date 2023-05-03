package algorithm.leetcode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        printListNode(addTwoNumbers(node1, node4));

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null, current = null;
        int val = 0, carry = 0;
        do {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            val = sum % 10;
            current = new ListNode(val);

            if (head == null) {
                head = current;
                tail = head;
            } else {
                tail.next = current;
                tail = current;
            }
            carry = sum / 10 ;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        } while(l1 != null || l2 != null || carry != 0);

        return head;
    }

    public static void printListNode(ListNode head) {
        ListNode current = head;
        do {
            System.out.print(current.val + " ");
            current = current.next;
        } while (current != null);
        System.out.println();
    }
}
