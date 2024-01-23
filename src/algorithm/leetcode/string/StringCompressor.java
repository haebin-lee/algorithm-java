package algorithm.leetcode.string;

import java.util.Arrays;

public class StringCompressor {
    public static void main(String[] args) {

        StringCompressor p = new StringCompressor();
        System.out.println(p.compress(new char[]{'a','a','b','b','c','c','c'}));
    }


    public int compress(char[] chars) {
        char prev = chars[0];
        int cnt = 1;
        int idx = 0;
        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length || prev != chars[i]) {
                chars[idx++] = prev;
                if (cnt > 1){
                    for (char n : String.valueOf(cnt).toCharArray()) {
                        chars[idx++] = n;
                    }
                }
                if (i < chars.length) {
                    prev = chars[i];
                    cnt = 1;
                }
            } else {
                cnt++;
            }
        }
        System.out.println(Arrays.toString(chars));
        return idx;
    }
}
