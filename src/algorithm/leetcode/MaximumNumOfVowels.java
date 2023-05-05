package algorithm.leetcode;


import javax.swing.plaf.IconUIResource;
import java.util.*;

public class MaximumNumOfVowels {
    public static void main(String[] args) {
        System.out.println(maxVowelsWithSlidingWindow("abciiidef", 3)); // 3
        System.out.println(maxVowelsWithSlidingWindow("aeiou", 2)); // 2
        System.out.println(maxVowelsWithSlidingWindow("leetcode", 3)); // 2
        System.out.println(maxVowelsWithSlidingWindow("cccccc", 3)); // 0
        System.out.println(maxVowelsWithSlidingWindow("a", 1)); // 1
        System.out.println(maxVowelsWithSlidingWindow("tryhard", 4)); // 1
        System.out.println(maxVowelsWithSlidingWindow("novowels", 1)); // 1

    }

    // O(n) ㅠ
    public static int maxVowels(String s, int k) {
        int[] yn = new int[s.length()];
        int[] sum = new int[s.length()];
        int max = 0;
        for (int i = 0 ; i < s.length() ; i++){
            if (isVowel(s.charAt(i))) {
                yn[i] = 1;
            } else {
                yn[i] = 0;
            }

            if (s.length() == 1) {
                max = yn[i];
                break;
            }
            if (i < k - 1) {
                sum [i] = yn[i];
            } else if ( i == k - 1) {
                for (int j = 0 ; j <= k - 1 ; j ++) {
                    sum[i] += yn[j];
                }
            } else {
                sum[i] = sum[i-1] - yn[i - k] + yn[i];
            }
            max = sum[i] <= k ? Math.max(sum[i], max) : max;
        }

        return max;
    }

    public static int maxVowelsWithSlidingWindow(String s, int k) {
        int i = 0, ans = 0, count = 0, size = s.length();
        for ( ;i < k ; i ++) {
            if (isVowel(s.charAt(i))) {
                count ++;
            }
        }

        for (; i < size ; i ++) {
            if (isVowel(s.charAt(i))) {
                count ++;
            }
            if (isVowel(s.charAt(i - k))) {
                count --;
            }
            ans = Math.max(ans,count);
        }

        return ans;
    }

    public static boolean isVowel(Character c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
