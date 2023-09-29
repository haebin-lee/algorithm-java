package algorithm.leetcode.graph;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        int[][] courses = {{0,1}, {0,2}, {1,3}, {1,4}, {3,4}};
        System.out.println(canFinish(5, courses));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            preMap.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visited = new HashSet<>();
        for (Integer pre : preMap.keySet()) {
            if (!dfs(preMap, visited, pre)) return false;
        }
        return true;
    }

    private static boolean dfs(Map<Integer, List<Integer>> preMap, Set<Integer> visited, Integer pre) {
        if (visited.contains(pre)) return false; // loop!
        if (preMap.get(pre).isEmpty()) return true; // completed

        visited.add(pre);
        for (Integer p : preMap.get(pre)) {
            if (!dfs(preMap, visited, p)) return false;
        }
        preMap.get(pre).clear();
        visited.remove(pre);
        return true;
    }


}
