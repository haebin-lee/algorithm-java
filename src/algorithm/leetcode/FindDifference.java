package algorithm.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class FindDifference {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        set1.removeAll(set2);

        Set<Integer> set3 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set4 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set4.removeAll(set3);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(set1));
        result.add(new ArrayList<>(set4));

        return result;
    }

    public static List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        return Arrays.asList(getElementsOnlyInFirstList(nums1, nums2),
                getElementsOnlyInFirstList(nums2, nums1));
    }

    public static List<Integer> getElementsOnlyInFirstList(int[] nums1, int[] nums2) {
       Set<Integer> only = new HashSet<>();
       Set<Integer> target = new HashSet<>();
       for (int n : nums2) {
           target.add(n);
       }

       for (int n: nums1) {
           if (!target.contains(n)) {
               only.add(n);
           }
       }

       return new ArrayList<>(only);
    }
}
