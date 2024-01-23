package algorithm.leetcode.string;

public class ReversedWord {

    public static void main(String[] args) {
        ReversedWord p = new ReversedWord();
        System.out.println(p.reverseWords("  hello world  "));
        System.out.println(p.reverseWords("a good   example"));
    }


    public String reverseWords(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end && s.charAt(start) == ' ') start++;
        while (start < end && s.charAt(end) == ' ') end--;
        String[] strs = s.substring(start, end + 1).split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = strs.length - 1; i >= 0; i--) {
            if ("".equals(strs[i])) continue;
            sb.append(strs[i]);
            if (i > 0) sb.append(" ");
        }

        return sb.toString();
    }
}
