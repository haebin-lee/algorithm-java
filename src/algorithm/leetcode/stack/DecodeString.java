package algorithm.leetcode.stack;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        DecodeString p = new DecodeString();
        System.out.println(p.decodeString("3[a]2[bc]")); //aaabcbc
        System.out.println(p.decodeString("3[a2[c]]")); //accaccacc
        System.out.println(p.decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
        System.out.println(p.decodeString("10[a]")); //
//        System.out.println(p.decodeString("100[leetcode]"));

    }

    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        int num = 0;
        Stack<StringBuilder> strs = new Stack<>();
        StringBuilder current = new StringBuilder();
        for (char c: s.toCharArray()) {

            if  (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }else if (c == '[') {
                nums.add(num);
                num = 0;
                strs.push(current);
                current = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp=current;
                current = strs.pop();
                int count = nums.pop();
                while(count-- > 0){
                    current.append(temp);
                }
            } else {
                current.append(c);
            }
        }
        return current.toString();
    }
}
