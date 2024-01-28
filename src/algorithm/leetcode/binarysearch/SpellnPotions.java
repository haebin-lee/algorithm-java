package algorithm.leetcode.binarysearch;

import java.util.Arrays;

public class SpellnPotions {

    public static void main(String[] args) {
        SpellnPotions p = new SpellnPotions();
//        System.out.println(Arrays.toString(p.successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7))); //Output: [4,0,3]
        System.out.println(Arrays.toString(p.successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16))); // [2,0,2]

    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int start = 0, end = potions.length - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                long value  = potions[mid] * spells[i];
                System.out.println("value: " + value);
                if (value == success) {
                    break;
                } else if (value < success) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            ans[i] = n - start;
        }
        return ans;
    }
}
