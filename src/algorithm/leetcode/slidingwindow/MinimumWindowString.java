package algorithm.leetcode.slidingwindow;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinimumWindowString {

    public static void main(String[] args) {
        List<Integer> list = IntStream.range(0, 1).boxed().toList();
        MinimumWindowString s = new MinimumWindowString();
        System.out.println(s.minWindow2("ADOBECODEBANC", "ABC"));
    }
    public String minWindow2(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, min = Integer.MAX_VALUE, startIndex = 0;
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();
        while (end < s.length()) {
            if (map[chS[end++]] -- > 0) {
                count --;
            }
            while (count == 0) {
                if (end - start < min) {
                    startIndex = start;
                    min = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count ++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, min);

    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return new String();
        }

        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, min = Integer.MAX_VALUE, startIndex = 0;
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        char[] chS = s.toCharArray();
        while (end < s.length()) {
            if (map[chS[end++]]-- > 0) {
                count --;
            }

            while (count == 0) {
                if (end - start < min) {
                    startIndex = start;
                    min = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count ++;
                }
            }
        }

        return min == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, min);
    }
}
