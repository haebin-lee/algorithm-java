package algorithm.leetcode;

import java.util.Stack;

public class BasicCalculatorImproved {

    public static void main(String[] args) {
        System.out.println(calculate("1+1")); // 2
        System.out.println(calculate("2-1+2")); // 3
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)")); //25
    }
    public static int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;

        int result = 0;
        int sign = 1, num = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(sign);

        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result += sign * num;
                sign = stack.peek() * (c == '+' ? 1 : -1);
                num = 0;
            } else if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                stack.pop();
            }
        }

        result += sign * num;
        return result;

    }

}
