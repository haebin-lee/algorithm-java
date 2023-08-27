package algorithm.leetcode.array;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // fl
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public static String longestCommonPrefix(String[] strs) { // str의 사이즈는? what's the size of this input str?
        Arrays.sort(strs);
        String str = strs[0];
        String str2 = strs[strs.length - 1];

        int i = 0;
        while ( i < str.length() && i < str2.length()) {
            if (str.charAt(i) != str2.charAt(i))
                break;
            i++;
        }

        return str.substring(0, i);
    }
}
