package algorithm.leetcode.heap;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class SmallestInfiniteSet2 {

    public static void main(String[] args) {
        SmallestInfiniteSet2 p = new SmallestInfiniteSet2();

    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public SmallestInfiniteSet2() {
        IntStream.range(1, 1001).forEach(m -> {
            pq.offer(m);
        });

    }

    public int popSmallest() {
        return pq.poll();
    }

    public void addBack(int num) {
        if (!pq.contains(num))
            pq.offer(num);
    }
}
