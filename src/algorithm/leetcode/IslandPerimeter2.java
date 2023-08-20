package algorithm.leetcode;

public class IslandPerimeter2 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};
        System.out.println(islandPerimeter(grid)); // 16

        grid = new int[][]{{1}};
        System.out.println(islandPerimeter(grid)); // 4

        grid = new int[][]{{1, 0}};
        System.out.println(islandPerimeter(grid)); // 4
    }

    public IslandPerimeter2() {
    }

    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int left =  isWater(grid, i-1, j);
                    int right = isWater(grid, i+1, j);
                    int down = isWater(grid, i, j-1);
                    int up = isWater(grid, i , j+1);
                    perimeter += left + right + down + up;
                }
            }
        }
        return perimeter;
    }

    public static int isWater(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length) {
            return grid[i][j] == 0 ? 1 : 0;
        }
        return 1;
    }
}

