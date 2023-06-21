package algorithm.leetcode;

import java.util.*;

public class ValidPath {

    public static void main(String[] args) {
//        int[][] a = {
//                {0, 1}, {1, 2}, {2, 0}
//        };
//        System.out.println(validPathDFS(3, a, 0, 2));

        int[][] b = {
                {0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}
        };
        System.out.println(validPathDFS(6, b, 0, 5));
    }
    private static boolean seen;
    public static boolean validPathDFS(int n, int[][] edges, int source, int destination) {

        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];
        int i, j;

        for (i = 0 ; i < n ; i ++) {
            graph[i] = new HashSet<>();
        }

        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        printHashSet(graph);

        seen = false;
        dfs(graph, visited, source, destination);
        return seen;
    }

    public static void dfs(HashSet<Integer>[] graph, boolean[] visited, int start, int end) {
        if (!visited[start] && !seen) {
            if (start == end) {
                seen = true;
                return;
            }

            visited[start] = true;
            for (Integer neighbor : graph[start]) {
                dfs(graph, visited, neighbor, end);
            }
        }
    }

    public static void printHashSet(HashSet<Integer>[] graph) {
        int i = 0;
        for(HashSet<Integer> node : graph) {
            System.out.print((i++) + ": " );
            node.stream().forEach(m -> System.out.print(m + ", "));
            System.out.println();
        }
    }
}
