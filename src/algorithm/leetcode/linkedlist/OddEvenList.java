package algorithm.leetcode.linkedlist;

import algorithm.leetcode.ListNode;
import algorithm.leetcode.ListNodeHelper;

import java.util.ArrayList;
import java.util.List;

public class OddEvenList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        OddEvenList p = new OddEvenList();
        ListNodeHelper.print(p.oddEvenList(n1));
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode pointer = head;
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        boolean turn = true;
        while (pointer != null) {
            if (turn)
                odd.add(pointer.val);
            else
                even.add(pointer.val);
            turn = !turn;
            pointer = pointer.next;
        }

        int i = 0, j = 0;
        pointer = head;
        while (pointer != null) {
            if (i < odd.size()) pointer.val = odd.get(i++);
            else pointer.val = even.get(j++);
            pointer = pointer.next;
        }
        return head;

    }
}
