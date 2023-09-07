package algorithm.leetcode.palindrome;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome2(121));
        System.out.println(isPalindrome2(-121));
        System.out.println(isPalindrome2(10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        String str = String.valueOf(x);
        String reverse = new StringBuilder(str).reverse().toString();
        return str.equals(reverse);
    }

    // without converting the integer to string
    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;

            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

}
