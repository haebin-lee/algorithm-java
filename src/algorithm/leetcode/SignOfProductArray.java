package algorithm.leetcode;

public class SignOfProductArray {

    public static void main(String[] args) {

    }

    public int arraySign(int[] nums) {
        int numOfNegative = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                return 0;
            if (nums[i] < 0) {
                numOfNegative++;
            }
        }

        if (numOfNegative % 2 == 0)
            return 1;
        return -1;
    }

}
