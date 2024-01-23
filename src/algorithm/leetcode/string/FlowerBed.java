package algorithm.leetcode.string;

import java.util.Arrays;

public class FlowerBed {

    public static void main(String[] args) {
        FlowerBed p = new FlowerBed();
        System.out.println(p.canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2));

    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0
                    && (i - 1 < 0 || flowerbed[i-1] == 0)
                    && (i + 1 ==  flowerbed.length || flowerbed[i+1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }
        }
        System.out.println(Arrays.toString(flowerbed));
        return n <= 0;
    }
}
