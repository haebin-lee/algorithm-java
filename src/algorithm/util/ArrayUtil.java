package algorithm.util;

import java.util.Arrays;

public class ArrayUtil {

    public static void printArr(int[] arr) {
        Arrays.stream(arr).forEach(m -> System.out.print(m + " "));
        System.out.println();
    }
}
