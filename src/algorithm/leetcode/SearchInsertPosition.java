package algorithm.leetcode;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 5)); // 2

        System.out.println(searchInsert(nums, 2)); // 1

        System.out.println(searchInsert(nums, 7)); // 4

    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
}
