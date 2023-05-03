package algorithm.leetcode;

import java.util.*;

public class LengthOfLongestSubString {
    public static void main(String[] args) {
//        System.out.println("result: " + lengthOfLongestSubstring("bwf")); // 3
//
//        System.out.println("result: " + lengthOfLongestSubstring("abcabcbb")); // 3
//        System.out.println("result: " + lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println("result: " + lengthOfLongestSubStringWithOptimizedSlidingWindow("pwwkew")); // 3
    }

    // Time Complexity: O(n^3) Space Complexity: O(n)
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s == null || "".equals(s)) {
            return max;
        }
        int size = s.length();
        boolean [] stop = new boolean[size];
        List<Set<Character>> hash = new ArrayList<>();

        for (int i = 0 ; i < size ; i++) {
            hash.add(new HashSet<>());
            for (int j = 0; j <= i ; j++) {
                if (!stop[j]) {
                    Set<Character> current = hash.get(j);
                    if (current.contains(s.charAt(i))) {
                        // 있다.
                        stop[j] = true;
                    } else {
                        // 없다.
                        current.add(s.charAt(i));
                        max = Math.max(max, current.size());
//                        System.out.print("sub" + s.charAt(j) + ": " + current.size() +" ");
                    }
                }
            }
//            System.out.print("max: " + max);
//            System.out.println();
        }

        return max;
    }

    // TimeLimitExceed - Time Complexity : O(n^3) Space Complexity:
    public static int lengthOfLongestSubStringWithBF(String s) {
        int res = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = 0; j < s.length() ; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public static boolean checkRepetition(String s, int start, int end) {
        Set<Character> hash = new HashSet<>();

        for (int i = start; i <= end; i++) {
            Character c = s.charAt(i);
            if (hash.contains(c)) {
                return false;
            }
            hash.add(c);
        }
        return true;
    }

    public static int lengthOfLongestSubstringWithSlidingWindow(String s) {
        Map<Character, Integer> chars = new HashMap<>();

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            System.out.println("left: " + left + ", right:" + right +" ");
            char r = s.charAt(right);
            chars.put(r, chars.getOrDefault(r,0) + 1);

            while (chars.get(r) > 1) {
                char l = s.charAt(left);
                chars.put(l, chars.get(l) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    public static int lengthOfLongestSubStringWithOptimizedSlidingWindow(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
