package algorithm.leetcode.slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacter {
    public static void main(String[] args) {
        LongestRepeatingCharacter c = new LongestRepeatingCharacter();
        System.out.println(c.characterReplacement("AABABBA", 1)); // 4;
    }

    public int characterReplacement(String s, int k) {
        int max = 0;
        int[] letter = new int[28];

        char[] chrs = s.toCharArray();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            letter[chrs[j] - 'A']++;
            int l = largest(letter);
            if (j - i + 1 - l <= k) {
                max = Math.max(j - i + 1, max);
            } else {
                while (j - i + 1 - l > k) {
                    letter[chrs[i] - 'A']--;
                    l = largest(letter);
                    i++;
                }
            }
        }

        return max;
    }
    public int largest(int[] letter) {
        int max = 0;
        for (int i = 0; i < letter.length; i++) {
            max = Math.max(max, letter[i]);
        }
        return max;
    }
}
