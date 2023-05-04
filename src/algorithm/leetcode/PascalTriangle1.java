package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle1 {
    public static void main(String[] args) {
        System.out.println(generate2(1));
        System.out.println(generate2(2));
        System.out.println(generate2(3));
        System.out.println(generate2(4));


    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 1) {
            result.add(Arrays.asList(1));
        } else if (numRows == 2) {
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1, 1));
        } else {
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1, 1));
            int start = 2;
            while (start < numRows) {
                List<Integer> upstairs = result.get(start - 1);
                List<Integer> current = new ArrayList<>();
                for (int i = 0 ; i <= start; i ++) {
                    if (i == 0 || i == start) {
                        current.add(1);
                    } else {
                        current.add(upstairs.get(i-1) + upstairs.get(i));
                    }
                }
                start ++;
                result.add(current);
            }

        }

        return result;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if (numRows <= 0)
            return output;
        ArrayList<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
        output.add(prev);

        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(1);    //first
            for (int j = 0; j < prev.size() - 1; j++) {
                curr.add(prev.get(j) + prev.get(j + 1));    //middle
            }
            curr.add(1);    //last
            output.add(curr);
            prev = curr;
        }
        return output;      // Return the output list of pascal values...
    }
}
