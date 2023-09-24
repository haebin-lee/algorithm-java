package algorithm.leetcode.dp;

public class LCS {
    static int call = 0;
    public static int lcs(String word1, String word2) {
        call++;
        int m = word1.length();
        int n = word2.length();

        if (m == 0 || n == 0) {
            return 0;
        }

        char lastCharWord1 = word1.charAt(m - 1);
        char lastCharWord2 = word2.charAt(n - 1);

        if (lastCharWord1 == lastCharWord2) {
            return lcs(word1.substring(0, m - 1), word2.substring(0, n - 1)) + 1;
        } else {
            // Last characters don't match, so explore both possibilities and choose the longer one
            int lcs1 = lcs(word1, word2.substring(0, n - 1));
            int lcs2 = lcs(word1.substring(0, m - 1), word2);

            return Math.max(lcs1, lcs2);
        }
    }
    public static int lcsDP(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int [][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(lcs("sea", "eat"));
        System.out.println(lcsDP("sea", "eat"));
        System.out.println(lcs("leetcode", "etco"));
        System.out.println(lcsDP("leetcode", "etco"));
        System.out.println(call);
    }
}
