package algorithm.leetcode.array;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num / nums[i] > 0) {
                int count = num / nums[i];
                while (count > 0) {
                    result.append(symbols[i]);
                    count --;
                }
                num %= nums[i];
            }
            i ++;
        }
        return result.toString();
    }

}
