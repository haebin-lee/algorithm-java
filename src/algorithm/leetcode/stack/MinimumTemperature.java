package algorithm.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class MinimumTemperature {

    public static void main(String[] args) {
        MinimumTemperature p = new MinimumTemperature();

        int[] temp = new int[]{73,74,75,71,69,72,76,73}; // [1,1,4,2,1,1,0,0]
        //temp = new int[]{30,40,50,60}; //[1,1,1,0]
        //temp = new int[]{30,60,90}; // [1,1,0]
        System.out.println(Arrays.toString(p.dailyTemperatures3(temp)));
    }

    public int[] dailyTemperatures3(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        int hottest = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (temperatures[i] >= hottest) {
                hottest = temperatures[i];
                continue;
            }
            int days = 1;
            while (temperatures[i + days] <= temperatures[i]) {
                days += result[i + days];
            }
            result[i] = days;
        }
        return result;

    }

    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >=0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }

    record Value(int idx, int temp) {};
    public int[] dailyTemperatures(int[] temperatures) { // Time limit exceeded.
        int[] result = new int[temperatures.length];
        Stack<Value> stack = new Stack<>();
        Stack<Value> stack2 = new Stack<>();
        for (int i = 0 ; i < temperatures.length; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    Value prev = stack.pop();
                    if (prev.temp < temperatures[i]) {
                        result[prev.idx] = i - prev.idx;
                    } else {
                        stack2.push(prev);
                    }
                }
                stack2.push(new Value(i, temperatures[i]));
            } else if (!stack2.isEmpty()) {
                while (!stack2.isEmpty()) {
                    Value prev = stack2.pop();
                    if (prev.temp < temperatures[i]) {
                        result[prev.idx] = i - prev.idx;
                    } else {
                        stack.push(prev);
                    }
                }
                stack.push(new Value(i, temperatures[i]));
            } else {
                stack.push(new Value(i, temperatures[i]));
            }
        }

        return result;
    }
}
