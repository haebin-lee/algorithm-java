package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopKMostFrequent {

    public static void main(String[] args) {
        TopKMostFrequent p = new TopKMostFrequent();
//        int[] arr = new int[]{1,1,1,2,2,3};
//        System.out.println(Arrays.toString(p.topKFrequent(arr, 2)));
//        int[] arr2 = new int[]{1};
//        System.out.println(Arrays.toString(p.topKFrequent(arr2, 1)));
        int[] arr3 = new int[]{1, 2};
        System.out.println(Arrays.toString(p.topKFrequent(arr3, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        int count = 0;
        int prev = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (!result.isEmpty() && result.get(result.size() - 1) == nums[i])
                continue;

            if (prev == nums[i]) {
                count ++;
            } else {
                count = 1;
                prev = nums[i];
            }

            if (count >= k) {
                result.add(prev);
            }
        }


        return result.stream().mapToInt(m -> m).toArray();
    }
}
