package algorithm.leetcode;


import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;

        char[] parenthesis = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (Character c : parenthesis) {
            if ('{' == c || '(' == c || '[' == c) {
                stack.push(c);
            } else if ('}' == c || ')' == c || ']' == c) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if ((c == '}' && pop != '{') || (c == ')' && pop != '(') || (c == ']' && pop != '[')) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
