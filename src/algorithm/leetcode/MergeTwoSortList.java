package algorithm.leetcode;

import java.util.ListResourceBundle;
import java.util.PriorityQueue;

public class MergeTwoSortList {

    public static void main(String[] args) {
        // Input: list1 = [1,2,4], list2 = [1,3,4]
        // Output: [1,1,2,3,4,4]
        ListNodeHelper list1 = new ListNodeHelper();
        list1.add(1);
        list1.add(2);
        list1.add(4);

        ListNodeHelper list2 = new ListNodeHelper();
        list2.add(1);
        list2.add(3);
        list2.add(4);
        ListNode result1 = mergeTwoLists2(list1.getHead(), list2.getHead());
        ListNodeHelper.print(result1);


        // Input: list1 = [], list2 = [0]
        // Output: [0]
        ListNodeHelper list3 = new ListNodeHelper();
        ListNodeHelper list4 = new ListNodeHelper();
        list4.add(0);
        ListNode result2 = mergeTwoLists2(list3.getHead(), list4.getHead());
        ListNodeHelper.print(result2);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        ListNode node1 = list1;
        while(node1 != null) {
            pq.add(node1.val);
            node1 = node1.next;
        }

        ListNode node2 = list2;
        while(node2 != null) {
            pq.add(node2.val);
            node2 = node2.next;
        }

        ListNode result = new ListNode(0);
        ListNode node = result;
        while (!pq.isEmpty()) {
            node.next = new ListNode(pq.poll());
            node = node.next;
        }

        return result.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pointer.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                pointer.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            pointer = pointer.next;
        }

        if (list1 != null) {
            pointer.next = list1;
        }

        if (list2 != null) {
            pointer.next = list2;
        }

        return result.next;
    }
}
