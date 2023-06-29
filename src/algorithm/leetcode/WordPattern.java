package algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));

        pattern = "abba"; s = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));

        pattern = "aaaa"; s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] patternStr = pattern.split("");
        String[] str = s.split(" ");

        if (patternStr.length != str.length)
            return false;

        Map<String, String> pMatch = new HashMap<>();
        Map<String, String> sMatch = new HashMap<>();

        for (int i = 0; i < patternStr.length ; i++) {
            String pi = pMatch.get(patternStr[i]);
            String si = sMatch.get(str[i]);

            if (pi == null && si == null) {
                pMatch.put(patternStr[i], str[i]);
                sMatch.put(str[i], patternStr[i]);
            } else if (!str[i].equals(pi) || !patternStr[i].equals(si)) {
                return false;
            }
        }
        return true;
    }
}
