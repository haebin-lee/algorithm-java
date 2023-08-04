package algorithm.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// it's HELL!!
public class BasicCalculator {

    public static void main(String[] args) {
//        System.out.println(calculate("1 + 1")); // 2
//        System.out.println(calculate(" 2-1 + 2 ")); // 3
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)")); //25
    }

    public static List<String> divide(String s) {
        String regex = "([+\\-()])|\\d+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s.trim());

        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(matcher.group());
        }

        Collections.reverse(result);
        return result;
    }

    public static int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        List<String> result = divide(s);

        Stack<String> stack = new Stack<>();
        for (String c: result) {
            if (isDigit(c) || "+".equals(c)|| "-".equals(c) || ")".equals(c))
                stack.push(c);
            else if ("(".equals(c)) {
                int value = 0;
                String operator = null;
                while (!")".equals(stack.peek())) {
                    String pop = stack.pop();
                    if (isDigit(pop)) {
                        int operand = Integer.parseInt(pop);
                        if (operator == null) {
                            value = operand;
                        } else  {
                            if ("+".equals(operator)) {
                                value += operand;
                            } else if ("-".equals(operator)) {
                                value -= operand;
                            } else {
                                System.err.println("error");
                            }
                        }
                    } else { // operator
                        operator = pop;
                    }
                }
                stack.pop(); // it should be )
                stack.push(String.valueOf(value));
            }
        }

        int sum = 0;
        String operator = null;
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (isDigit(pop)) {
                int operand = Integer.parseInt(pop);
                if (operator == null) {
                    sum = operand;
                } else {
                    if ("+".equals(operator)) {
                        sum += operand;
                    } else if ("-".equals(operator)) {
                        sum -= operand;
                    }
                }
            } else {
                operator = pop;
            }
        }
        return sum;

    }

    public static boolean isDigit(String s) {
        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

}
