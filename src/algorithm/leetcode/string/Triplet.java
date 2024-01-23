package algorithm.leetcode.string;

public class Triplet {

    public static void main(String[] args) {
        Triplet p = new Triplet();
        System.out.println(p.increasingTriplet(new int[]{5, 2, 4, 1, 5, 2, 2}));
    }

    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num <= min) min = num;
            else if (num < secondMin) secondMin = num;
            else if(num > secondMin) return true;
        }
        return false;
    }
}
