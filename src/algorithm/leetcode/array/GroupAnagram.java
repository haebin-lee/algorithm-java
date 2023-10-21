package algorithm.leetcode.array;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            groups.computeIfAbsent(String.valueOf(chars), m -> new ArrayList<>());
            groups.get(String.valueOf(chars)).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}
