package algorithm.leetcode;

import java.util.Stack;

public class RemovingStar {

    public static void main(String[] args) {

    }

    public String removeStars2(String s) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' && !builder.isEmpty()) {
                builder.deleteCharAt(builder.length() - 1);
            } else{
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }

    public String removeStars(String s) {
        char[] chrs = s.toCharArray();
        Stack<Character> stack = new Stack<>();;
        for (char ch: chrs) {
            if (!stack.isEmpty() && '*' == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
}
