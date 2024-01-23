package algorithm.leetcode.string;

import java.util.Arrays;

public class ReverseVowels {

    public static void main(String[] args) {
        ReverseVowels p = new ReverseVowels();
        System.out.println(p.reverseVowels("a."));; // leotcede

    }

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < s.length() - 1 && !isVowel(arr[left]) ) {
                left++;
            }
            while (right < s.length() -1 && !isVowel(arr[right])) {
                right--;
            }
            if (left < right && isVowel(arr[left]) && isVowel(arr[right])) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            left++;
            right--;
        }

        return new String(arr);
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
