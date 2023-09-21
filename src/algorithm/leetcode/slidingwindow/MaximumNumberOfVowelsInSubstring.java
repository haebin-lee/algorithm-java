package algorithm.leetcode.slidingwindow;

public class MaximumNumberOfVowelsInSubstring {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
        System.out.println(maxVowels("leetcode", 3));
    }

    public static int maxVowels(String s, int k) {
        int max = 0;
        int i = 0, j = 0, cnt = 0;
        for (; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                cnt++;
            }
            max = Math.max(cnt, max);
        }

        for( ; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                cnt++;
            }
            if (isVowel(s.charAt(i - k))) {
                cnt--;
            }
            max = Math.max(cnt, max);
        }
        return max;
    }

    public static boolean isVowel(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }
}
