package algorithm.leetcode;

import algorithm.util.ArrayUtil;

public class ReverseNodeInKGroup {

    public static void main(String[] args) {
//        Input: head = [1,2,3,4,5], k = 2
//        Output: [2,1,4,3,5]
        ListNodeHelper head = new ListNodeHelper();
        head.add(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        ListNode result = reverseKGroupImproved(head.getHead(), 2);
        ListNodeHelper.print(result);

//        Input: head = [1,2,3,4,5], k = 3
//        Output: [3,2,1,4,5]
        ListNodeHelper head2 = new ListNodeHelper();
        head2.add(1); head2.add(2); head2.add(3); head2.add(4); head2.add(5);
        ListNode result2 = reverseKGroupImproved(head2.getHead(), 3);
        ListNodeHelper.print(result2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int[] arr = new int[5000];
        int idx = 0, size = 0;

        ListNode pointer = head;
        while (pointer != null) {
            arr[idx++] = pointer.val;
            size++;
            pointer = pointer.next;
        }

        for (int pos = 0, i = 0; pos + k - 1 < size; pos = (++i) * k) {
            int left = pos, right = pos + k - 1;

            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        ListNode result = new ListNode(0);
        pointer = result;
        for (int i = 0; i < size; i++) {
            pointer.next = new ListNode(arr[i]);
            pointer = pointer.next;
        }

        return result.next;
    }

    public static int size(ListNode head) {
        if (head == null)
            return 0;
        if (head.next == null)
            return 1;
        else {
            int size = 0;
            ListNode current = head;

            while(current != null) {
                size ++;
                current = current.next;
            }
            return size;
        }
    }

    public static ListNode reverseKGroupImproved(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count ++;
        }

        if (next != null && size(head) >= k) {
            head.next = reverseKGroupImproved(next, k);
        } else {
            head.next = next;
        }

        return prev;
    }
}