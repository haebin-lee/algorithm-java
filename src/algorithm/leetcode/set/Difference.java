package algorithm.leetcode.set;

import algorithm.leetcode.binarysearch.SearchInRotatedArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Difference {

    public static void main(String[] args) {
        Difference p = new Difference();
        System.out.println(p.findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        for (Integer num: s1) {
            if (!s2.contains(num)) r1.add(num);
        }
        ans.add(r1);
        List<Integer> r2 = new ArrayList<>();
        for (Integer num : nums2) {
            if (!s1.contains(num)) r2.add(num);
        }
        ans.add(r2);

        return ans;
    }
}
