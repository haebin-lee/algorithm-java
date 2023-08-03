package algorithm.leetcode;

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));// 3
        System.out.println(lengthOfLongestSubstring("au"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int i = 0, max = 1;
        char[] str = s.toCharArray();

        for (int j = 1; j < s.length(); ) {
            if (s.substring(i, j).indexOf(str[j]) == -1) {
                j++;
            } else {
                i++;
            }

            max = Math.max(max, j - i);
        }

        return max;
    }
}
