package algorithm.leetcode.binarysearch;

public class FindMinimumInRotatedArray {

    public static void main(String[] args) {
        FindMinimumInRotatedArray p = new FindMinimumInRotatedArray();
        System.out.println(p.findMin(new int[]{3,4,5,1,2}));
        System.out.println(p.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(p.findMin(new int[]{11,13,15,17}));
    }

    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            System.out.println("start: " + start + " end: " + end);
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return nums[start];
    }
}
