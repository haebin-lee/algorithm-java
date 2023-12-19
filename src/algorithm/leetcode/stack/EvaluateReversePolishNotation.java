package algorithm.leetcode.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] str = new String[]{"2","1","+","3","*"};
//        str = new String[]{"4","13","5","/","+"};
//        str = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        EvaluateReversePolishNotation p = new EvaluateReversePolishNotation();
        System.out.println(p.evalRPN(str));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            if ("+".equals(c)) {
                Integer val2 = stack.pop();
                Integer val1 = stack.pop();
                stack.push(val1 + val2);
            } else if ("-".equals(c)) {
                Integer val2 = stack.pop();
                Integer val1 = stack.pop();
                stack.push(val1 - val2);
            } else if ("*".equals(c)) {
                Integer val2 = stack.pop();
                Integer val1 = stack.pop();
                stack.push(val1 * val2);
            } else if ("/".equals(c)) {
                Integer val2 = stack.pop();
                Integer val1 = stack.pop();
                stack.push(val1 / val2);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }

    public boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
