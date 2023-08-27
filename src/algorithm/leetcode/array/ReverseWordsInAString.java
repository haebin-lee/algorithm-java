package algorithm.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords2("the sky is blue"));
        System.out.println(reverseWords2("  hello world  "));
        System.out.println(reverseWords2("a good   example"));
    }

    // 8 ms / 42.5MB
    public static String reverseWords2(String s) {
        String[] strs = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(strs));
        return String.join(" ", strs);
    }

    // 12ms / 44.7MB
    public static String reverseWords(String s) {
        Pattern pattern = Pattern.compile("([a-zA-Z0-9])+");
        Matcher matcher = pattern.matcher(s);

        String result = "";
        while (matcher.find()) {
            result = matcher.group() + " " + result;
        }

        return result.substring(0, result.length() - 1);
    }
}
