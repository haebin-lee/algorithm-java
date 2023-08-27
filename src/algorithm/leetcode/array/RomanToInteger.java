package algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        // input(String) output(int)
        System.out.println(romanToInt2("III")); // 3
        System.out.println(romanToInt2("LVIII")); // 58
        System.out.println(romanToInt2("MCMXCIV")); // 1994
    }

    public static int romanToInt2(String s) {
        Map<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);

        int result = 0;

        for (int i = 0; i < s.length() ; i++) {
            if (i < s.length() -1 && roman.get(s.substring(i, i+1)) < roman.get(s.substring(i+1, i+2))) {
                result -= roman.get(s.substring(i, i+1));
            } else {
                result += roman.get(s.substring(i, i+1));
            }

        }
        return result;
    }

    public static int romanToInt(String s) {
        Map<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);
        roman.put("IV", 4);
        roman.put("IX", 9);
        roman.put("XL", 40);
        roman.put("XC", 90);
        roman.put("CD", 400);
        roman.put("CM", 900);


        int result = 0;
        for(int i = 0; i < s.length(); ) {

            if (i < s.length() - 1) {
                String doubleSymbol = s.substring(i, i + 2);
                if (roman.containsKey(doubleSymbol)) {
                    int value = roman.get(doubleSymbol);
                    result += value;
                    i += 2;
                    continue;
                }
            }
            String singleSymbol = s.substring(i, i + 1);
            result += roman.get(singleSymbol);

            i += 1;
        }

        return result;
    }

}
