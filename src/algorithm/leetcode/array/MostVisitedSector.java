package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MostVisitedSector {

    public static void main(String[] args) {
        MostVisitedSector s = new MostVisitedSector();
        System.out.println(s.mostVisited(4, new int[]{1,3,1,2}));
        System.out.println(s.mostVisited(3, new int[]{3,2,1,2,1,3,2,1,2,1,3,2,3,1}));
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        // 1 3 1 2 -> 1 < 2 : 1, 2
        // 3 4.2 1 -> 3 4 0 1
        // 3 4 0 1 2 3 4 0 1
        int a = rounds[0];
        int b = rounds[rounds.length - 1];

        List<Integer> result = new ArrayList<>();
        if (a <= b) {
            helper(a, b, result);
        } else {
            helper(1, b, result);
            helper(a, n, result);
        }
        return result;
    }

    public List<Integer> helper(int a, int b, List<Integer> result) {
        for (int i = a; i <= b; i++) {
            result.add(i);
        }
        return result;
    }

}
