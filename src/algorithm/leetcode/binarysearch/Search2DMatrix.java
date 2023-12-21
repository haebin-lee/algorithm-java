package algorithm.leetcode.binarysearch;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        Search2DMatrix p = new Search2DMatrix();
        System.out.println(p.searchMatrix(matrix, 3)); // true
        System.out.println(p.searchMatrix(matrix, 13)); // false
        System.out.println(p.searchMatrix(matrix, 61)); // false
        int[][] matrix2 = {{1}};
        System.out.println(p.searchMatrix(matrix2, 1)); // true

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] <= target &&  target <= matrix[mid][n - 1]){
                left = mid;
                break;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("row: " + left + " " + right);

        int row = left;
        left = 0; right = n - 1;
        while (left + 1 <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return matrix[row][left] == target;
    }


}
