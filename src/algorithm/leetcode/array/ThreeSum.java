package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum p = new ThreeSum();
        System.out.println(p.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)  {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            int a = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r)  {
                int threeSum = a + nums[l] + nums[r];
                if (threeSum < 0) {
                    l++;
                } else if (threeSum > 0) {
                    r--;
                } else {
                    result.add(List.of(a, nums[l], nums[r]));
                    l += 1;
                    if (nums[l] == nums[l + 1] && l < r) {
                        l += 1;
                    }
                }
            }
        }
        return result;
    }
}
