package algorithm.leetcode.heap;

public class SmallestInfiniteSet {
    boolean[] empty = new boolean[1001];
    int idx = 1;

    public static void main(String[] args) {
        SmallestInfiniteSet p = new SmallestInfiniteSet();
        p.addBack(2);
        System.out.println();
        System.out.println(p.popSmallest());
        System.out.println(p.popSmallest());
        System.out.println(p.popSmallest());
        p.addBack(1);
        System.out.println();
        System.out.println(p.popSmallest());
        System.out.println(p.popSmallest());
        System.out.println(p.popSmallest());

    }
    public SmallestInfiniteSet() {
    }

    public int popSmallest() {
        int smallest = idx;
        empty[smallest] = true;
        while(idx <= 1000 && empty[idx]) {
            idx++;
        }
        return smallest;
    }

    public void addBack(int num) {
        if (empty[num]) {
            empty[num] = false;
            idx = Math.min(idx, num);
        }
    }
}
