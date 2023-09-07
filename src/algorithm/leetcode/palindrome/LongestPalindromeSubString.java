package algorithm.leetcode.palindrome;

public class LongestPalindromeSubString {

    public static void main(String[] args) {
//        System.out.println(longestPalindromeRevision("aacabdkacaa"));
//        System.out.println(longestPalindromeRevision("babad"));
        System.out.println(longestPalindromeRevision("cbb"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 1) return s;

        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            int start = i, end = i + 1;
            String subPalindrome = "";
            while (start >= 0 && end < s.length()) {
                if (s.charAt(start) != s.charAt(end))
                    break;
                subPalindrome = s.substring(start, end + 1);// cost a lot
                start--; end++;
            }
            longest = longest.length() < subPalindrome.length() ? subPalindrome : longest;

            start = i - 1;
            end = i + 1;
            while (start >= 0 && end < s.length()) {
                if (s.charAt(start) != s.charAt(end))
                    break;
                subPalindrome = s.substring(start, end + 1);
                start--; end++;
            }
            longest = longest.length() < subPalindrome.length() ? subPalindrome : longest;
        }
        return "".equals(longest) ? s.substring(0, 1) : longest;
    }

    static int start = 0;
    static int end = 0;

    public static String longestPalindromeRevision(String s) {
        start = 0; end = 0;
        if (s == null || s.length() == 1) return s;

        for (int i = 0; i < s.length() - 1; i++) {
            check(s, i, i+1);

            check(s, i - 1, i + 1);
        }
        return s.substring(start, end + 1);
    }


    public static void check(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j))
                break;
            if (end - start < j - i){
                start = i;
                end = j;
            }
            i--; j++;
        }

    }


    // brute-force O(n^3)
    public static String bruteforce(String s) {
        for (int len = s.length(); len > 0 ; len--) {
            for (int start = 0; start <= s.length() - len; start++) {
                if (check(start, start + len, s)){
                    return s.substring(start, start +len);
                }
            }
        }
        return "";
    }

    public static boolean check(int start, int end, String s) {
        System.out.println(s.substring(start, end));
        int i = start;
        int j = end - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static String dp(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[]{0, 0};

        for (int i = 0; i < n;i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = true;
                ans[0] = i;
                ans[1] = i+1;
            }
        }

        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                System.out.println(i + " " + j);
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }
}
