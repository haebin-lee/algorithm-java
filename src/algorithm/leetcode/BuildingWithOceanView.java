package algorithm.leetcode;

import algorithm.util.ArrayUtil;

import java.util.*;

public class BuildingWithOceanView {

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,3,1}; // 0, 2, 3,
        ArrayUtil.print(findBuildings2(arr));

        arr = new int[]{4,3,2,1}; // 0, 1, 2, 3
        ArrayUtil.print(findBuildings2(arr));

        arr = new int[]{1,3,2,4}; // 3
        ArrayUtil.print(findBuildings2(arr));
    }

    public static int[] findBuildings2(int[] heights) {
        List<Integer> oView = new ArrayList<>();
        int height = 0;
        for (int i = heights.length - 1; i >= 0 ; i--) {
            if (height < heights[i]) {
                oView.add(i);
                height = heights[i];
            }
        }

        int[] result = new int[oView.size()];
        for(int i = result.length - 1; i >= 0 ; i--) {
            result[i] = oView.get(result.length - 1 - i);
        }
        return result;
    }

    public static int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1 ; i < heights.length ; i++) {
            while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0 ; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
