package algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

    public static void main(String[] args) {
        LetterCombination p = new LetterCombination();
        System.out.println(p.letterCombinations("23"));
    }

    String[] keypad = {"0", "1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        StringBuilder helper = new StringBuilder();
        if(digits.length() == 0) return combinations;
        calculate(digits, 0, helper, combinations);
        return combinations;
    }

    public void calculate(String digits, int index, StringBuilder helper, List<String> combinations) {
        if(index == digits.length()) {
            combinations.add(helper.toString());
            return;
        }
        int key = digits.charAt(index) - '0';
        for(int i = 0;i<keypad[key].length();i++){
            helper.append(keypad[key].charAt(i));
            calculate(digits, index+1, helper, combinations);
            helper.deleteCharAt(helper.length()-1);
        }
    }
}
