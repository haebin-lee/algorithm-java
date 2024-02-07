package algorithm.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {

    public static void main(String[] args) {
        Maze p = new Maze();
        char[][] maze = new char[][]{{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        System.out.println(p.nearestExit(maze, new int[]{1, 2}));
    }

    public int nearestExit(char[][] maze, int[] entrance) {

        int[][]directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = maze.length, n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;

            for (int k = 0; k < size; k ++) {

                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];
                for (int[] direction: directions) {
                    int a = x + direction[0], b = y + direction[1];
                    if (a < 0 || a >= m || b < 0 || b >= n) continue;
                    if (maze[a][b] == '+') continue;
                    if (a == 0 || a == m - 1 || b == 0 || b == n - 1) return step;
                    maze[a][b] = '+';
                    queue.offer(new int[]{a, b});

                }
            }

        }
        return -1;
    }


}
