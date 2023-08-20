package algorithm.util;

import java.util.Arrays;

public class ArrayUtil {

    public static void print(int[] arr) {
        Arrays.stream(arr).forEach(m -> System.out.print(m + " "));
        System.out.println();
    }

    public static void print(long[] arr) {
        Arrays.stream(arr).forEach(m -> System.out.print(m + " "));
        System.out.println();
    }


    public static void print(int[] arr, int start, int end) {
        for (int i = start ; i <= end ; i ++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

}
