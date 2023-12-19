package algorithm.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram p = new LargestRectangleInHistogram();
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(p.largestRectangleArea3(heights));
    }


    public int largestRectangleArea3(int[] heights) {
        if (heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? 0 : heights[i];
            while (stack.peek() != -1 && cur < heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return maxArea;
    }

    // Two array
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>(); // to store indices.
        int[] nearestSmallerRight = new int[n];
        int[] nearestSmallerLeft = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nearestSmallerRight[i] = n;
            } else {
                nearestSmallerRight[i] = stack.peek();
            }
            stack.push(i);
        }
        System.out.println("right: " + Arrays.toString(nearestSmallerRight));
        stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nearestSmallerLeft[i] = -1;
            } else{
                nearestSmallerLeft[i] = stack.peek();
            }
            stack.push(i);
        }
        System.out.println("left: " + Arrays.toString(nearestSmallerLeft));

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nearestSmallerRight[i] - nearestSmallerLeft[i] - 1));
        }
        return maxArea;
    }

    // brute force
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int j = i;
            int minHeight = heights[i];
            int maxArea = heights[i];
            while (j >= 0 && maxArea <= (i - j + 1) * minHeight) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = (i - j + 1) * minHeight;
                result = Math.max(result, maxArea);
                j--;
            }
        }
        return result;
    }
}
