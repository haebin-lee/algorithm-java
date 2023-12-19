package algorithm.leetcode;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void display(ListNode node) {
        ListNode pointer = node;
        while(pointer != null) {
            System.out.print(pointer.val + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }
}
