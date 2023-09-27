package algorithm.leetcode.graph;

import javafx.util.Pair;

import java.util.*;

public class NumberOfIsland {

    public static int numIslands(char[][] grid) {
        if (grid == null) return 0;

        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;

                }
            }
        }
        return count;
    }


    private static void bfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        bfs(grid, i - 1, j);
        bfs(grid, i + 1, j);
        bfs(grid, i, j - 1);
        bfs(grid, i, j + 1);
    }
}
