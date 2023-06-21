package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement2(nums));
    }

    public static int majorityElement(int[] nums) {
        int majorityCnt = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            int num = nums[i];
            int cnt = map.getOrDefault(num, 0);

            if (majorityCnt <= cnt + 1) {
                return num;
            }
            map.put(num, cnt + 1);
        }

        return 0;
    }

    public static int majorityElement2(int[] nums) {
        int count = 1;
        int element = nums[0];

        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == element) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                element = nums[i];
                count = 1;
            }
        }
        return element;
    }
}
