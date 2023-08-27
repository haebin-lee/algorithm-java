package algorithm.leetcode.array;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World")); // 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(lengthOfLastWord("luffy is still joyboy")); // 6
    }

    public static int lengthOfLastWord(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == ' ') {
                if (result > 0) {
                    break;
                }
            } else {
                result ++;
            }
        }
        return result;
    }

}
