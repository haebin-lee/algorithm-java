package algorithm.leetcode.slidingwindow;

public class LongestNiceWindow {

    public static void main(String[] args) {
        String s = "YazaAay";
        String s2 = "Bb";
        String s3 = "cChH";
//        System.out.println(longestNiceSubstring(s));
//        System.out.println(longestNiceSubstring(s2));
        System.out.println(longestNiceSubstring(s3));
    }

    public static String longestNiceSubstring(String s) {
        int i = 0, j = 0;
        int leftbound = 0, start = 0, end = 0;
        boolean same = false;
        while (j < s.length() - 1) {
            j++;
            int value = Math.abs(s.charAt(i) - s.charAt(j));
            if (value != 0 && value != 32) {
                i++;
            } else {
                leftbound = i;

                if (j - leftbound > end - start) {
                    start = leftbound;
                    end = j;
                }
            }

        }
        return start != end ? s.substring(start, end + 1): "";
    }
}
