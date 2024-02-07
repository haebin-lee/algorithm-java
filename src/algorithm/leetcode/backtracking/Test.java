package algorithm.leetcode.backtracking;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        // Implement your solution here
        // map <Integer, String>
        // all values should be 1

        int [] A = new int[]{1, 1, 1, 2, 2, 2};
        Map<Integer, Integer> map = new HashMap<>(); // number - count
        for (int a: A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int total = A.length;
        Map<Integer, List<Integer>> countMap = new HashMap<>(); // count - number;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!countMap.containsKey(entry.getValue())) {
                countMap.put(entry.getValue(), new ArrayList<>());
            }
            countMap.get(entry.getValue()).add(entry.getKey());
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>>  entry : countMap.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> values = entry.getValue();
            if (values.size() == 1) set.add(1);
            else {
                int size = values.size();
                while (size-- > 0 && key >= 0) {
                    if (!set.contains(key))
                        set.add(key);
                    key--;

                }
            }
        }
        int sum = set.stream().mapToInt(m -> m).sum();
        System.out.println(total - sum);
//        return total - sum;
    }
}
