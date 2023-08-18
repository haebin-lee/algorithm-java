package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInteger2("III"));
        System.out.println(romanToInteger2("LVIII"));
        System.out.println(romanToInteger2("MCMXCIV"));
    }

    public static int romanToInt(String s) {
//        I             1
//        V             5 IV
//        X             10  IX
//        L             50 XL
//        C             100 XC
//        D             500 CD
//        M             1000 CM

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int total = 0, sub = 0;
        for (int i = 0; i < s.length(); i++) {

            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                total -= map.get(s.charAt(i));
            } else {
                total += map.get(s.charAt(i));
            }
        }
        return total + sub;
    }

    public static int romanToInteger2(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int currentSum = 0, i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String doubleSymbol = s.substring(i, i + 2);
                if (map.containsKey(doubleSymbol)) {
                    currentSum += map.get(doubleSymbol);
                    i += 2;
                    continue;
                }
            }

            String singleSymbol = s.substring(i, i + 1);
            currentSum += map.get(singleSymbol);
            i += 1;
        }
        return currentSum;
    }
}
