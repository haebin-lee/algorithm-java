package algorithm.leetcode.string;

public class EuclidAlgorithm {

    public static void main(String[] args) {
        EuclidAlgorithm p = new EuclidAlgorithm();
        System.out.println(p.gcd(20, 30));
    }

    public int gcd(int x, int y) {
        return y == 0? x : gcd(y, x % y);
    }
}
