package algorithm.leetcode;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 12, 16, 21, 26, 29, 40, 45, 47, 48, 50};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 5));
    }

    public static boolean binarySearch(int[] arr, int start, int end, int target) {
        int mid = start + (end - start) / 2;
        if (start > end) return false;
        if (arr[mid] == target) return true;
        else if (arr[mid] > target)
            return binarySearch(arr, start, mid - 1, target);
        else
            return binarySearch(arr, mid + 1, end, target);

    }
}
