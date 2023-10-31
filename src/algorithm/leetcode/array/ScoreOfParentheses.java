package algorithm.leetcode.array;

import java.util.Stack;

public class ScoreOfParentheses {

    public static void main(String[] args) {
        ScoreOfParentheses p = new ScoreOfParentheses();
        System.out.println(p.scoreOfParentheses2("(()(()))"));
//        System.out.println(p.scoreOfParentheses2("((()))"));
    }

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
//            System.out.println(s.charAt(i));
            if (ch == '(') {
                stack.push(score);
                score = 0;
            } else {
                int pop = stack.pop();
                score = pop + Math.max(2 * score, 1);
            }

            System.out.print("score: " + score + " || ");
            stack.forEach(m -> System.out.print(m + " "));
            System.out.println();
        }
        return score;
    }

    public int scoreOfParentheses2(String s) {
        int depth = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                depth++;
            if (s.charAt(i) == ')')
                depth--;
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                ans += (int) Math.pow(2, depth);
            }
        }
        return ans;
    }
}
