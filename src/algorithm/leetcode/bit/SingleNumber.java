package algorithm.leetcode.bit;

public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber p = new SingleNumber();
        p.singleNumber(new int[]{1, 2, 3, 4});
    }

    public int singleNumber(int[] nums) {
        System.out.println(1 << 1);
        System.out.println(2 << 1);
        System.out.println(1 & 1);
        System.out.println(2 & 1);
        System.out.println(3 & 1);
        System.out.println(4 & 1);
        System.out.println(5 >> 1);
        return 0;
    }
}
