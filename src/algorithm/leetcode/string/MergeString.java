package algorithm.leetcode.string;

public class MergeString {

    public static void main(String[] args) {
        MergeString m = new MergeString();
        System.out.println(m.mergeAlternately("abcd", "pq"));
    }

    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0, turn = 0;
        String result = "";
        while (i < word1.length() && j < word2.length()) {
            if (turn % 2 == 0) {
                result += word1.substring(i, i + 1);
                i++;
            } else {
                result += word2.substring(j, j + 1);
                j++;
            }
            turn ++;
        }
        if (i < word1.length()) {
            result += word1.substring(i);
        }

        if (j < word2.length()) {
            result += word2.substring(j);
        }
        return result;
    }
}
