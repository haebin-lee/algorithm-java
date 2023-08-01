package algorithm.leetcode;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));

        System.out.println(searchMatrix(matrix, 13));

        int[][] matrix2 = new int[][]{{1}};
        System.out.println(searchMatrix(matrix2, 2));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int first = 0, last = matrix.length - 1, cSize = matrix[0].length - 1;

        while (first + 1 <= last) {
            int mid = first + (last - first) / 2;
            System.out.println(matrix[mid][0] + ", " + matrix[mid][cSize]);
            if (matrix[mid][0] > target) {
                last = mid - 1;
            } else if (matrix[mid][0] <= target && target <= matrix[mid][cSize]) {
                first = mid;
                break;
            } else if (matrix[mid][cSize] < target) {
                first = mid + 1;
            }
        }

        int row = first;
        int left = 0, right = matrix[row].length - 1;
        while (left + 1 <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) return true;
            else if(matrix[row][mid] >  target) right = mid - 1;
            else left = mid + 1;
        }
        return matrix[row][left] == target;
    }
}
