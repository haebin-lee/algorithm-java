package algorithm.leetcode;

import algorithm.util.ArrayUtil;

import java.util.Arrays;

public class ReverseLinkedList2 {

    public static void main(String[] args) {
//        Input: head = [1,2,3,4,5], left = 2, right = 4
//        Output: [1,4,3,2,5]
        ListNodeHelper head = new ListNodeHelper();
        head.add(1); head.add(2); head.add(3); head.add(4); head.add(5);
        ListNode result = reverseBetween(head.getHead(), 2, 4);
        ListNodeHelper.print(result);


//        Input: head = [5], left = 1, right = 1
//        Output: [5]
        ListNodeHelper head2 = new ListNodeHelper();
        head2.add(5);
        ListNode result2 = reverseBetween(head2.getHead(), 1, 1);
        ListNodeHelper.print(result2);

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int [] arr = new int[500];

        ListNode pointer = head;
        int i = 0, size = 0;
        while (pointer != null) {
            arr[i++] = pointer.val;
            pointer = pointer.next;
            size++;
        }

        left -= 1; right -= 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left ++;
            right --;
        }

        ListNode result = new ListNode(0);
        pointer = result;
        for (int idx = 0; idx < size; idx++) {
            pointer.next = new ListNode(arr[idx]);
            pointer = pointer.next;
        }

        return result.next;
    }

}
