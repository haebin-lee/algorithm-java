package algorithm.leetcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ReducingDishes {

    public static void main(String[] args) {
        int[] a = {-1, -8, 0, 5, -9};
        System.out.println(maxSatisfactionImproved(a)); // 14

        int[] b = {4, 3, 2};
        System.out.println(maxSatisfactionImproved(b)); // 20

        int[] c = {-1, -4, -5};
        System.out.println(maxSatisfactionImproved(c)); //0

    }

    public static int maxSatisfactionImproved(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int size = satisfaction.length;

        int presum = 0, res = 0;
        for (int i = size -1 ; i >= 0 ; i --) {
            presum += satisfaction[i];
            if (presum < 0) {
                break;
            }
            res += presum;
        }

        return res;
    }

    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int size = satisfaction.length;
        int max = 0;

        while(size > 0) {
            int sum = 0;
            int largest = size;
            for (int i = satisfaction.length - 1 ; largest > 0 ; i--) {
                sum += satisfaction[i] * largest--;
            }
            max = Math.max(sum, max);
            size--;
        }

        return max;
    }

}
