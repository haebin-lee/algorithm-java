package algorithm.leetcode.interval;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class NonOverlappingInterval {

    public static void main(String[] args) {
        NonOverlappingInterval p = new NonOverlappingInterval();
        System.out.println(p.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}})); //1
        System.out.println(p.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}})); // 2
        System.out.println(p.eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));// 0
        System.out.println(p.eraseOverlapIntervals(new int[][]{{1,100},{11,22},{1,11},{2,12}})); // 2

    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Double.compare(a[1] - a[0], b[1] - b[0]));
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }

        int overlapped = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            boolean contains = false;
            for (int m: IntStream.range(intervals[i][0], intervals[i][1]).toArray()) {
                if (set.contains(m)) {
                    contains = true;
                    break;
                }
            }
            if (contains) overlapped++;
            else {
                for (int m: IntStream.range(intervals[i][0], intervals[i][1]).toArray()) {
                    set.add(m);
                }
            }

            System.out.println(set);

        }
        return overlapped;

    }
}
