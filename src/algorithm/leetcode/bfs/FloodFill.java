package algorithm.leetcode.bfs;

public class FloodFill {

    public static void main(String[] args) {
        int[][] nums = {{1,1,1}, {1,1,0}, {1,0,1}};
        int[][] result = floodFill(nums, 1, 1, 2);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int original = image[sr][sc];
        floodFillMaker(image, visited, sr, sc, original, color);
        return image;
    }

    public static void floodFillMaker(int[][] image, boolean[][] visited, int sr, int sc, int original, int color) {
        if (sr < 0 || sr > image.length - 1 ) return;
        if (sc < 0 || sc > image[sr].length - 1) return;
        if (visited[sr][sc]) return;

        if(image[sr][sc] == original) {
            image[sr][sc] = color;
            visited[sr][sc] = true;

            floodFillMaker(image, visited,sr-1, sc, original, color);
            floodFillMaker(image, visited, sr+1, sc, original, color);
            floodFillMaker(image, visited, sr, sc-1, original, color);
            floodFillMaker(image, visited, sr, sc+1, original, color);
        }
    }

}
