package algorithm.leetcode;

public class FindIndex {

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 9, 10, 11}; // 6-9 사이 => 4
        int n  = 7; // 6-9 사이 => 2
        System.out.println(findMidIndex(arr, 0, arr.length -1, n));

        n = 3; // 2-6사이 => 1
        System.out.println(findMidIndex(arr, 0, arr.length -1, n));

        n = 12; // 5
        System.out.println(findMidIndex(arr, 0, arr.length -1, n));

        n = 0; // 0
        System.out.println(findMidIndex(arr, 0, arr.length -1, n));
    }

    public static int findMidIndex(int[] arr, int start, int end, int n) {
        if (start == end || start + 1 == end) {
            if (arr[start] < n) {
                return start;
            } else {
                return Math.max(start - 1, 0);
            }

        }
        int mid = (start + end) / 2;
        if (arr[mid] < n) {
            return findMidIndex(arr, mid + 1, end, n);
        } else {
            return findMidIndex(arr, start, mid, n);
        }
    }
}
