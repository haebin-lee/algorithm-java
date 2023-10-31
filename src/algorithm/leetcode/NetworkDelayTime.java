package algorithm.leetcode;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(times, 4, 2));
    }

    record Destination(int end, int distance) {}

    public static int networkDelayTime(int[][] times, int n, int k) {
        if (times == null || times.length == 0)
            return -1;
        // how times[][] looks like.
        // how do we find a source node?

        // 1:
        // 2: (2, 1, 1) (2, 3, 1)
        // 3: (3, 4, 1)
        // 4:
        Map<Integer, List<Destination>> map = new HashMap<>();
        for (int[] time: times) {
            map.computeIfAbsent(time[0], m -> new ArrayList<>());
            map.get(time[0]).add(new Destination(time[1], time[2]));
        }

        // just starts from the first index of times
        int min = 0;
        Queue<Integer> pq =  new LinkedList<>();
        pq.offer(times[0][0]);
        while (k > 0 && !pq.isEmpty()) {
            int v = pq.poll();
            List<Destination> dest = map.get(v);
            for (Destination d : dest) {
                pq.offer(d.end);
                min += d.distance;
                k--;
            }
        }
        return k > 0 ? -1 : min;
    }
}
