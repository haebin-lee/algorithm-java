package algorithm.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class MinimumSumSet {

    public static void main(String[] args) {
        int num = 2932; // 52 = 23 + 29
        System.out.println("result: " + minimumSumImproved(num));
        num = 4009; // 13 = 04 + 09
        System.out.println("result: " + minimumSumImproved(num));
    }

    // PASS at once, but runtime, memory is too high,
    // I think Stream costs high.
    public static int minimumSum(int num) {
        int[] arr = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).sorted().toArray();
        String num1 = "", num2 = "";

        num1 = String.valueOf(arr[0]) + String.valueOf(arr[2]);
        num2 = String.valueOf(arr[1]) + String.valueOf(arr[3]);
        return Integer.parseInt(num1) + Integer.parseInt(num2);
    }

    public static int minimumSumImproved(int num) {
        int [] items = new int[4];
        int i = 0;
        while(num > 0) {
            int a = num % 10;
            num = num / 10;
            items[i++] = a;
        }
        Arrays.sort(items);
        return items[0] * 10 + items[2] + items[1] * 10 + items[3];
    }
}
