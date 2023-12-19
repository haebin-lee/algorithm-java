package algorithm.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(3));
    }

    public static List<String> result;
    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        backtracking(n, 1, 0, "(");
        return result;
    }

    public static void backtracking(int num, int open, int close, String cur) {
        if (num * 2 == open + close){
            result.add(cur);
            return;
        }

        if (open < num)
            backtracking(num, open + 1, close, cur + "(");
        if (open > close) {
            backtracking(num, open, close + 1, cur + ")");
        }

    }
}
