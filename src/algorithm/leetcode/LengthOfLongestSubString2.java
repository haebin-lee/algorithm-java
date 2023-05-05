package algorithm.leetcode;

import java.util.*;

public class LengthOfLongestSubString2 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbbbbb"));
        System.out.println(lengthOfLongestSubstring("bwf"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int left = 0 , right = 0; right < s.length() ; right ++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left);
            }
            ans = Math.max(ans, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }

        return ans;
    }

}
