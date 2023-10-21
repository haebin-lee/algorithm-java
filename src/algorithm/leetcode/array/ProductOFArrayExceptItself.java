package algorithm.leetcode.array;

import java.util.Arrays;

public class ProductOFArrayExceptItself {
    public static void main(String[] args) {
        int[] num = {1,2,3,4};
        ProductOFArrayExceptItself p = new ProductOFArrayExceptItself();
        System.out.println(Arrays.toString(p.productExceptSelfEfficient(num)));
    }

    public int[] productExceptSelfEfficient(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= postfix;
            postfix *= nums[i];
        }

        return output;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] output = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i];
        }
        postfix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = postfix[i + 1] * nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            output[i] = (i - 1 < 0? 1 : prefix[i-1]) * (i + 1 >= nums.length ? 1: postfix[i+1]);
        }

        return output;
    }
    public int[] productExceptSelf(int[] nums) {
        int max = 1;
        int maxWithoutZero = 1;
        int zero = 0;
        for (int num: nums) {
            if (num == 0)
                zero++;
            if (num != 0)
                maxWithoutZero *= num;
            max *= num;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                if (zero == 1)
                    result[i] = maxWithoutZero;
                else
                    result[i] = 0;
            else
                result[i] = max / nums[i];
        }

        return result;
    }
}
