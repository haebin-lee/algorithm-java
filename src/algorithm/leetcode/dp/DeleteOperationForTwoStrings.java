package algorithm.leetcode.dp;

import java.util.Arrays;

public class DeleteOperationForTwoStrings {

    public static void main(String[] args) {
        System.out.println(lcs("ease", "peace"));
        System.out.println(lcs("sea", "eat"));
        System.out.println(lcs("leetcode", "etco"));
    }

    public static int minDistance(String word1, String word2) {
        int lcs = lcs(word1, word2);
        return word1.length() - lcs + word2.length() - lcs;
    }

    public static int lcs(String word1, String word2) {
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
        for (int i = 0; i <= m ; i++)
            System.out.println(Arrays.toString(dp[i]));
        return dp[m][n];
    }
}
