package algorithm.leetcode;

public class FindPeakElement {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        FindPeakElement p1 = new FindPeakElement();
        System.out.println(p1.findPeakElement(nums));

        int[] nums2 = {1,2,1,3,5,6,4};
        FindPeakElement p2 = new FindPeakElement();
        System.out.println(p2.findPeakElement(nums2));

        int[] nums3 = {3,2,1};
        FindPeakElement p3 = new FindPeakElement();
        System.out.println(p3.findPeakElement(nums3)); // 0
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n-2] < nums[n-1]) return n-1;

        int l = 1, r = n-2;
        while (l <= r) {
            int m = l + (r - l ) / 2;
            if (nums[m] > nums[m-1] && nums[m] > nums[m+1]) return m;
            if (nums[m] > nums[m-1])
                l = m + 1;
            else
                r = m - 1;

        }
        return -1;
    }
}
