package algorithm.leetcode;

public class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
        System.out.println(minSubArrayLen2(7, nums));


        int[] nums2 = {1, 4, 4};
        System.out.println(minSubArrayLen(1, nums2));
        System.out.println(minSubArrayLen2(1, nums2));

        int[] nums3 = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(11, nums3));
        System.out.println(minSubArrayLen2(11, nums3));

        int[] nums4 = {1,2,3,4,5};
        System.out.println(minSubArrayLen(11, nums4));
        System.out.println(minSubArrayLen2(11, nums4));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;
        int left = 0, sum = 0;

        for (int right = 0; right < nums.length ; right++) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left++];
            }
        }

        return min == nums.length + 1 ? 0 : min;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        int low = 1, high = nums.length, mn = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (findWindow(mid, nums, target)) {
                high = mid - 1;
                mn = mid;
            } else {
                low = mid + 1;
            }

        }

        return mn;
    }

    public static boolean findWindow(int size, int[] nums, int target) {
        int sum = 0, i = 0, j = 0, max = Integer.MIN_VALUE, n = nums.length;

        while (j < n) {
            sum += nums[j];
            if (j - i + 1 == size) {
                max = Math.max(sum, max);
                sum -= nums[i];
                i++;
            }
            j++;

        }
        return max >= target;
    }


}
