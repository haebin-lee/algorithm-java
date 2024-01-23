package algorithm.leetcode.string;

import java.util.Arrays;

public class ProductExceptItself {

    public static void main(String[] args) {
        ProductExceptItself p = new ProductExceptItself();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{-1,1,0,-3,0})));
    }

    public int[] productExceptSelf(int[] nums) {
        // check 0
        int zero = 0;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zero++;
            else
                product *= nums[i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zero > 0) {
                if (nums[i] != 0 ||  zero - 1 > 0) {
                    ans[i] = 0;
                } else {
                    ans[i] = product;
                }
            } else {
                ans[i] = product / nums[i];
            }
        }

        return ans;
    }
}
