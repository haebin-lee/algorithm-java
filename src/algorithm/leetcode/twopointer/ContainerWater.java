package algorithm.leetcode.twopointer;

public class ContainerWater {

    public static void main(String[] args) {
        ContainerWater p = new ContainerWater();
        System.out.println(p.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int max = 0;
        while (start < end) {
            int h = Math.min(height[start], height[end]);
            max = Math.max(max, h * (end - start));
            if (height[start] < height[start + 1]) start++;
            else end--;
        }

        return max;
    }
}
