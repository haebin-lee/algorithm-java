package algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BoatToSavePeople {

    public static void main(String[] args) {
//        System.out.println(numRescueBoats(new int[]{1,2}, 3)); //1
//        System.out.println(numRescueBoats(new int[]{3,2,2,1}, 3)); // 3
//        System.out.println(numRescueBoats(new int[]{3,5,3,4}, 5)); // 4
//        System.out.println(numRescueBoats(new int[]{2, 2}, 6)); // 1
        System.out.println(numRescueBoats(new int[]{3,2,3,2,2}, 6)); // 3
        System.out.println(numRescueBoats(new int[]{21,40,16,24,30}, 50)); // 3
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;

        while (i <= j) {
            ans ++;
            if (people[i] + people[j] <= limit) {
                i ++;
            }
            j--;
        }
        return ans;
    }
}
