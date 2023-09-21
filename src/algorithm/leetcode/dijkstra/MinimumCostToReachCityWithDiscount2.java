package algorithm.leetcode.dijkstra;

import java.util.*;

public class MinimumCostToReachCityWithDiscount2 {

    public static void main(String[] args) {
        System.out.println(minimumCost(5, new int[][]{{0,1,4},{2,1,3},{1,4,11},{3,2,3},{3,4,2}}, 1));

    }
    record Cell(int i, int w, int k) {}
    public static int minimumCost(int n, int[][] edges, int k) {
        List<Node>[] g = createGraph(n, edges, new List[n]);

        int[][] visited = new int[n][k+1];
        Queue<Cell> q = new PriorityQueue<>((a, b) -> a.w - b.w);
        q.offer(new Cell(0, 0, k));

        for (var _a: visited) Arrays.fill(_a, Integer.MAX_VALUE);
//        for (var _a: visited) System.out.println(Arrays.toString(_a));
        while(!q.isEmpty()) {
            var cur = q.poll();
            if (cur.i == n - 1) return cur.w;

            if (cur.k > 0) {
                int k2 = cur.k -1;
                for (var nei : g[cur.i]) {
                    int w2 = nei.w / 2 + cur.w;
                    if (w2 < visited[nei.i][k2]) {
                        visited[nei.i][k2] = w2;
                        q.offer(new Cell(nei.i, w2, k2));
                    }
                }
            }

            for (var nei : g[cur.i]) {
                int w2 = nei.w + cur.w;
                if (w2 < visited[nei.i][cur.k]) {
                    visited[nei.i][cur.k] = w2;
                    q.offer(new Cell(nei.i, w2, cur.k));
                }
            }
        }
        return -1;
    }
    record Node(int i, int w) {}
    private static List<Node>[] createGraph(int n, int[][] edges, List<Node>[] g) {
        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();

        for (var e: edges) {
            g[e[0]].add(new Node(e[1], e[2]));
            g[e[0]].add(new Node(e[0], e[2]));
        }
        return g;
    }
}
