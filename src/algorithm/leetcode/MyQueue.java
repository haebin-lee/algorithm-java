package algorithm.leetcode;

import java.util.Stack;

public class MyQueue {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop()); // 1
        myQueue.push(4);
        myQueue.push(5);
        System.out.println(myQueue.pop()); // 2
        myQueue.push(6);
        System.out.println(myQueue.pop()); // 3
        System.out.println(myQueue.empty());
    }
    Stack<Integer> stack;
    Stack<Integer> stack2;

    public MyQueue() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x){
        stack.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && stack2.isEmpty();
    }
}
