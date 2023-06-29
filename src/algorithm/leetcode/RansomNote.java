package algorithm.leetcode;

import algorithm.util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(canConstructImproved("aab", "baa")); // true
        System.out.println(canConstructImproved("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (map.get(c) == null || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    public static boolean canConstructImproved(String ransomNote, String magazine) {
        int[] arr = new int[128];
        for (char c: magazine.toCharArray()) {
            ++arr[c];
        }
        for (char c: ransomNote.toCharArray()) {
            if (--arr[c] < 0)
                return false;
        }

        return true;
    }
}
