package algorithm.leetcode.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DesignHitCount {

    private Deque<Hit> q;
    public DesignHitCount() {
        q = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        while (!q.isEmpty() && q.peekFirst().timestamp <= timestamp - 300) {
            q.pollFirst();
        }
        if (!q.isEmpty() && q.peekLast().timestamp == timestamp) {
            q.peekLast().hit += 1;
        } else {
            q.addLast(new Hit(timestamp, 1));
        }
    }

    public int getHits(int timestamp) {
        while (!q.isEmpty() && q.peekFirst().timestamp <= timestamp - 300) {
            q.pollFirst();
        }
        int count = 0;
        for (Hit hit : q) {
            count += hit.hit;
        }

        return count;
    }

    public static class Hit {
        int timestamp;
        int hit;

        public Hit(int timestamp, int hit) {
            this.timestamp = timestamp;
            this.hit = hit;
        }
    }
}
