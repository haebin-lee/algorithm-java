package algorithm.leetcode.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecentCounter {

    Deque<Integer> q;
    public static void main(String[] args) {
        RecentCounter p = new RecentCounter();
        System.out.println(p.ping(1));
        System.out.println(p.ping(100));
        System.out.println(p.ping(3001));
        System.out.println(p.ping(3002));
    }
    public RecentCounter() {
        q = new ArrayDeque<>();
    }

    public int ping(int t) {
        while(!q.isEmpty() && t - q.peekFirst() > 3000) {
            q.pollFirst();
        }
        q.addLast(t);
        return q.size();
    }

}
