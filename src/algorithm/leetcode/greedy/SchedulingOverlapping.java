package algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class SchedulingOverlapping {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 3}, {2, 4}, {3, 5}, {5, 7}
        };
        System.out.println(maximum(arr));
    }

    public static int maximum(int[][] arr){
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        int maxCount = 1;
        int[]current = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (current[0] > arr[i][1]) {
                maxCount++;
                current = arr[1];
            }
        }
        return maxCount;
    }
}
