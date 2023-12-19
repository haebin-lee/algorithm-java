package algorithm.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    record Value(int value, int min){};

    List<Value> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        min = Math.min(val, min);
        stack.add(new Value(val, min));
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1).value;
    }

    public int getMin() {
        return stack.get(stack.size() - 1).min;
    }
}
