package algorithm.leetcode.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, -9)); // false
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9)); // true
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2)); // false
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 12)); // true
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 20)); // false

    }

    // start < end
    public static boolean search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return true;
            else if (target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return false;
    }
}
