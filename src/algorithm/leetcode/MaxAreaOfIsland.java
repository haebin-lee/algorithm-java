package algorithm.leetcode;

import algorithm.dijkstra.DijkstraAlgorithms;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));

        int[][] grid2 = new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(grid2));


    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int max = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                int area = visitIsland(grid, visited, i, j);
                max = Math.max(area, max);

            }
        }
        return max;
    }

    public static int visitIsland(int[][] grid, boolean[][]visited, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length &&  grid[i][j] == 1 && !visited[i][j]){
            visited[i][j] = true;
            int a = visitIsland(grid, visited, i - 1, j);
            int b = visitIsland(grid, visited, i + 1, j);
            int c = visitIsland(grid, visited, i, j - 1);
            int d = visitIsland(grid, visited, i, j + 1);
            return 1 + a + b + c + d;
        }
        return 0;
    }
}
