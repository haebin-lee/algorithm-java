package algorithm.leetcode.greedy;


import java.util.Stack;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7}; // 49
        System.out.println(maxArea(arr));

        arr = new int[]{1, 1}; // ₩
        System.out.println(maxArea(arr));

        arr = new int[]{1, 2, 4, 3}; // ₩
        System.out.println(maxArea(arr));

    }

    public static int maxArea(int[] height) {
        int maxArea = 0, j = 0, n = height.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(h * w, maxArea);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
