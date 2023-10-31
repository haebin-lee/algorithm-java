package algorithm.leetcode.greedy;

import java.util.*;

public class VideoStitching {

    public static void main(String[] args) {

        VideoStitching vs = new VideoStitching();
//        int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
//        System.out.println(vs.videoStitching(clips, 10));

        int[][] clips = {{0, 1}, {1, 2}};
        System.out.println(vs.videoStitching(clips, 5));
    }

    public int videoStitching(int[][] clips, int time) {

        // (end, (start, start, start));
        Map<Integer, TreeSet<Integer>> timeframe = new HashMap<>();
        for (int i = 0; i <= time; i++) {
            timeframe.put(i, new TreeSet<>(Integer::compare));
        }
        for (int[] clip: clips) {
            timeframe.get(clip[1]).add(clip[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        if (timeframe.get(time).isEmpty()) {
            return -1;
        }
        queue.offer(time);

        int start = time;
        int end = time;
        int count = 0;
        int prev = time;
        while(!queue.isEmpty()) {
            end = queue.poll();
            while (timeframe.get(end).isEmpty()) {
                end += 1;
                if (prev == end)
                    return -1;
            }
            if (end > 0) {
                start = timeframe.get(end).first();
                prev = end;
                count ++;
                if (start == 0)
                    break;
                queue.offer(start);
            }
        }

        return start != 0? -1 : count;
    }
}
