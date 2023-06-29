package algorithm.leetcode;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));

        s = "rat"; t = "car";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        // t를 s로 다 만들수 있는가
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i ++) {
            ++ arr[s.charAt(i)];
        }

        for (int i = 0; i < t.length(); i ++) {
            if (--arr[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

}
