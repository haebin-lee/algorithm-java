package algorithm.leetcode.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SuggestionSystem {

    public static void main(String[] args) {
        // Input: products = ["mobile","mouse","moneypot","monitor","mousepad"],
        // searchWord = "mouse"
        // Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]

        SuggestionSystem p = new SuggestionSystem();
        System.out.println(p.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        int idx = 0;
        List<String> current = Arrays.stream(products).sorted().collect(Collectors.toList());
        for (Character c: searchWord.toCharArray()) {
            List<String> sub = new ArrayList<>();
            for (int i = 0; i < current.size(); i++) {
                if (current.get(i).charAt(idx) == c) {
                    sub.add(current.get(i));
                }
            }
            idx++;
            if (sub.size() > 3) {
                result.add(sub.stream().limit(3).collect(Collectors.toList()));
            } else {
                result.add(sub);
            }
            current = sub;
        }

        return result;
    }
}
