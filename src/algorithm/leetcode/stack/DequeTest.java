package algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.add(2); // addLast
        deque.addLast(3);
        System.out.println(deque.toString());
        System.out.println(deque.poll()); // pollFirst
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());

    }
}
