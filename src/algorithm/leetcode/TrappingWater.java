package algorithm.leetcode;


import java.util.Stack;

public class TrappingWater {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap3(height)); // 6

        height = new int[]{4,2,0,3,2,5};
        System.out.println(trap3(height)); //9

    }

    public static int trap3(int[] height) {
        int ans = 0, left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0;
        while(left < right) {
            if (height[left] <height[right]) {
                if (height[left] >= left_max)
                    left_max = height[left];
                else
                    ans+= (left_max - height[left]);
                left++;
            }else {
                if (height[right] > right_max)
                    right_max = height[right];
                else
                    ans += (right_max - height[right]);
                right--;
            }

        }
        return ans;
    }
    public static int trap2(int[] height) {
        int ans = 0, current = 0;
        Stack<Integer> stack = new Stack<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
                int pop = stack.pop();
                if(stack.isEmpty())
                    break;

                int distance = current - stack.peek() - 1;
                int boundedWater = Math.min(height[current], height[stack.peek()]) - height[pop];
                ans += distance * boundedWater;
            }
            stack.push(current++);
        }
        return ans;
    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for(int i = 1; i < size ; i++) {
            left_max[i] = Math.max(height[i], left_max[i-1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0 ; i--) {
            right_max[i] = Math.max(height[i], right_max[i+1]);
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return sum;
    }
}
