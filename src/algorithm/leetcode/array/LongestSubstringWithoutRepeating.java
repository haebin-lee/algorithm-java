package algorithm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating c = new LongestSubstringWithoutRepeating();
        System.out.println(c.lengthOfLongestSubstring("aabaab!bb"));//3
        System.out.println(c.lengthOfLongestSubstring("dvdf"));//3
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        Set<Character> set = new HashSet<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (true){
                    set.remove(s.charAt(start));
                    start++;
                    if (s.charAt(start - 1) == s.charAt(i))
                        break;
                }
            }
            set.add(s.charAt(i));
            max = Math.max(max, set.size());
        }
        return max;
    }
}
