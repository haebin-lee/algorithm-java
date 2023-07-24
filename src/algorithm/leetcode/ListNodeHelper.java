package algorithm.leetcode;

public class ListNodeHelper {

    private ListNode head;

    public ListNode getHead() {
        return head;
    }

    public void add(int val) {
        if (head == null) {
            head = new ListNode(val);
            return;
        }
        ListNode node = head;
        while(node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(val);
    }

    public void print() {
        ListNode node = this.head;

        while (node != null) {
            System.out.print(node.val + " - ");
            node = node.next;
        }
        System.out.println();
    }
    public static void print(ListNode head) {
        ListNode node = head;

        while(node != null) {
            System.out.print(node.val+ " - ");
            node = node.next;
        }
        System.out.println();
    }
}
