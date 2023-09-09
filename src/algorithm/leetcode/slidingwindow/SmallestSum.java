package algorithm.leetcode.slidingwindow;

public class SmallestSum {

    public static int smallestSubarraySum(int[] arr, int targetSum) {
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];

            while (currentSum >= targetSum) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 0, 19};
        int targetSum = 51;
        int result = smallestSubarraySum(arr, targetSum);
        System.out.println("Smallest subarray length: " + result);
    }
}
