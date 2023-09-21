package algorithm.leetcode.dijkstra;

import java.util.*;

public class MinimumCostToReachCityWithDiscount {

    // the point is add the information of destination, minimum cost, and remaining discount.
    // Visited node can be traversed again depending on getting discount or not.
    public static void main(String[] args) {
        System.out.println(minimumCost(5, new int[][]{{0,1,4},{2,1,3},{1,4,11},{3,2,3},{3,4,2}}, 1));
    }

    public static int minimumCost(int n, int[][] highways, int discounts) {
        boolean[][] visited = new boolean[n][discounts + 1];

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] highway : highways){
            adj.get(highway[0]).add(new int[]{highway[1], highway[2]});
            adj.get(highway[1]).add(new int[]{highway[0], highway[2]});
        }

        // pq or q?
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // initialize
        int[] start = new int[]{0, 0, discounts};
        pq.offer(start);

        // getting minimum cost
        while (!pq.isEmpty()) {
            int[] source = pq.poll();
            if (visited[source[0]][source[2]]) continue;
            visited[source[0]][source[2]] = true;

            if (source[0] == n - 1) {
                for (int i = 0; i < visited.length ; i++) {
                    for (int j = 0; j < visited[i].length; j++) {
                        System.out.print(visited[i][j] + " ");
                    }
                    System.out.println();
                }
                return source[1];
            }

            List<int[]> neighbors = adj.get(source[0]);
            for (int[] neighbor: neighbors) {

                pq.offer(new int[] {neighbor[0], source[1] + neighbor[1], source[2]});
                if (source[2] > 0) {
                    pq.offer(new int[] {neighbor[0], source[1] + neighbor[1] / 2, source[2] - 1});
                }
            }
        }


        return -1;
    }
}
