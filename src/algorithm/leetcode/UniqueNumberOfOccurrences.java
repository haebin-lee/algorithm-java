package algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));

        arr = new int[]{1, 2};
        System.out.println(uniqueOccurrences(arr));

        arr = new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = map.getOrDefault(arr[i], 0);
            value += 1;
            map.put(arr[i], value);
        }

        HashSet<Integer> existed = new HashSet<>();
        for(Integer item: map.values()) {
            if(existed.contains(item)) {
                return false;
            }
            existed.add(item);
        }
        return true;
    }
}
