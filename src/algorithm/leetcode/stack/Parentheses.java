package algorithm.leetcode.stack;

import java.util.Stack;

public class Parentheses {

    public static void main(String[] args) {
        String s = "()";
//        s = "()[]{}";
//        s = "(([]{}))";
//        s = "]";

        Parentheses p = new Parentheses();
        System.out.println(p.isValid2(s));
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        String[] strs = s.split("");
        Stack<String> stack = new Stack<>();
        for (String str : strs) {
            switch (str) {
                case "(" :
                case "{" :
                case "[" :
                    stack.push(str);
                    break;
                case ")":
                case "}":
                case "]":
                    stack.push(str);
                    String close = stack.isEmpty()? "" : stack.pop();
                    String open = stack.isEmpty()? "" : stack.pop();
                    if ("(".equals(open) && ")".equals(close)) continue;
                    if ("{".equals(open) && "}".equals(close)) continue;
                    if ("[".equals(open) && "]".equals(close)) continue;
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
