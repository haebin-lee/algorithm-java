package algorithm.leetcode;

import java.time.Period;

public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}};
        System.out.println(islandPerimeter2(grid)); // 16

        grid = new int[][]{{1}};
        System.out.println(islandPerimeter2(grid)); // 4

        grid = new int[][]{{1, 0}};
        System.out.println(islandPerimeter2(grid)); // 4
    }

    public static int islandPerimeter(int[][] grid) {
        // 최대 세로, 가로길이의 합이군
        int total = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    if (i - 1 >= 0 && grid[i-1][j] == 1)
                        total++;
                    if (i + 1 < grid.length && grid[i+1][j] == 1)
                        total++;
                    if (j - 1 >= 0 && grid[i][j-1] == 1)
                        total++;
                    if (j + 1 < grid[i].length && grid[i][j+1] ==1)
                        total++;
                } else if (grid[i][j] == 1) {
                    if (i - 1 < 0)
                        total++;
                    if (i + 1 == grid.length)
                        total ++;
                    if (j - 1 < 0)
                        total++;
                    if (j + 1 == grid[i].length)
                        total++;
                }
            }
        }
        return total;
    }

    public static int islandPerimeter2(int[][] grid) {
        if (grid == null) return 0;
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0; j <grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return getPerimeter(grid, i, j);
            }
        }
        return 0;
    }

    public static int getPerimeter(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return 1;
        if (grid[i][j] == 0) return 1;
        if (grid[i][j] == -1) return 0;

        int count = 0;
        grid[i][j] = -1;
        count += getPerimeter(grid, i - 1, j);
        count += getPerimeter(grid, i + 1, j);
        count += getPerimeter(grid, i, j - 1);
        count += getPerimeter(grid, i, j + 1);

        return count;
    }
}
