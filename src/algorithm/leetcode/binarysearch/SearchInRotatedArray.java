package algorithm.leetcode.binarysearch;

import java.util.Arrays;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        SearchInRotatedArray p = new SearchInRotatedArray();
//        System.out.println(p.search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
//        System.out.println(p.search(new int[]{4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(p.search(new int[]{3, 1}, 4)); // -1
    }

    public int search2(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        // find min
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end])
                end = mid;
            else
                start = mid + 1;
        }
        int minIdx = start;
        System.out.println("minIdx: " + minIdx);

        if (target <= nums[nums.length - 1]) {
            int r = Arrays.binarySearch(Arrays.copyOfRange(nums, minIdx, nums.length), target);
            if (r >= 0) return minIdx + r;
            return -1;
        }
        int r =  Arrays.binarySearch(Arrays.copyOfRange(nums, 0, minIdx), target);
        if (r >= 0) return r;
        return -1;
//        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, minIdx)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, minIdx, nums.length)));
//        return -1;
    }

}
