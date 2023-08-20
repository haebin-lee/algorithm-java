package algorithm.leetcode;


import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3}; // 10
        System.out.println(result(arr));
    }

    public static int result(int [] heights) {
        int max = 0;
        int n = heights.length;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || heights[i] < heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }

        return max;
    }
}
