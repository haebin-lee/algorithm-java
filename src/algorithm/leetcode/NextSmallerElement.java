package algorithm.leetcode;

import algorithm.util.ArrayUtil;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 10, 8};
        ArrayUtil.print(result(arr));

    }

    public static int[] result(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int prevIndex = stack.pop();
                result[prevIndex] = nums[i];
            }
            stack.push(i);
        }

        return result;
    }
}
