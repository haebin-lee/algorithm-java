package algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};
        int[] result = nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int num = nums[i % nums.length];

            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                int prevIndex = stack.pop();
                result[prevIndex] = num;
            }

            if (i < nums.length) {
                stack.push(i);    
            }
        }
        return result;
    }
}
