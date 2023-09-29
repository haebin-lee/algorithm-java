package algorithm.leetcode.graph;

import javax.naming.InterruptedNamingException;
import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {

        int[][] courses = new int[][]{{1,0}, {2,0}, {3,1}, {3,2}};
        int[] result = findOrder(4, courses);
        System.out.println(Arrays.toString(result));
    }
    static Set<Integer> cycle = new HashSet<>();
    static Set<Integer> visited = new HashSet<>();
    static List<Integer> result = new ArrayList<>();
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        cycle = new HashSet<>();
        visited = new HashSet<>();
        result = new ArrayList<>();

        Map<Integer, List<Integer>> preMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] pre: prerequisites) {
            preMap.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, preMap)) return new int[0];
        }
        Collections.reverse(result);
        return result.stream().mapToInt(m -> m).toArray();
    }


    public static boolean dfs(int course, Map<Integer, List<Integer>> preMap) {
        // base case
        if (cycle.contains(course)) return false;
        if (visited.contains(course)) return true;

        cycle.add(course);
        for (int pre: preMap.get(course)) {
            if (!dfs(pre, preMap))  return false;
        }
        cycle.remove(course);
        visited.add(course);
        result.add(course);
        return true;
    }

}
