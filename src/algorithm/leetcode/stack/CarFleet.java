package algorithm.leetcode.stack;

import java.util.Arrays;

public class CarFleet {

    public static void main(String[] args) {
        // target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
        CarFleet p = new CarFleet();
        System.out.println(p.carFleet2(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
//        System.out.println(p.carFleet2(100, new int[]{0,2,4}, new int[]{4,2,1}));
    }
    // calculate time taken for a car to reach target with current speed
    // if the time taken is greater than previous car
    // it means the previous car will reach before the present car
    // and all the cars following will only come after the present car reaches the target.

    public int carFleet2(int target, int[] position, int[] speed) {
        int len = position.length;
        int[][] cars = new int[len][2];
        for(int i = 0 ; i < len ; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars , (a,b) -> b[0] - a[0]);
        for (int i = 0; i < cars.length; i++) {
            System.out.println(Arrays.toString(cars[i]));
        }
        // sort array in descending order as we want to
        // reach to target as fast as possible
        float prevMinTime= 0;
        int fleets = 0;
        // count fleets
        for(int[]  car : cars){
            float distanceToTarget = target - car[0];
            // remaining distance to reach the ttarget
            float timeTakenToRTarget = distanceToTarget / car[1];
            // time taken to reach target with present speed
            if(timeTakenToRTarget > prevMinTime){
                // best we can go is the min in road
                //    1     3   1     4    2
                //    0 - - 3 - 5 - - 8 - 10 - -
                //    12    3   7     1    1  time to each with present speed
                // here car 8 can go only after 10 which will take 2 hours
                // and car 3 can only go after car 5 so we start a new fleet
                // if we encounter previous cars time taken to target is greater than present car
                // as all the other cars have to go after the larget time
                fleets++;
                prevMinTime = timeTakenToRTarget;
            }
        }
        return fleets;
    }

    public int carFleet(int target, int[] position, int[] speed) {
        float[] time = new float[target + 1];
        float max = 0;

        for (int i = 0; i < position.length; i++) {
            time[i] = (float) (target - position[i]) / speed[i];
        }
        System.out.println(Arrays.toString(time));

        int count = 0;
        for (int i = target; i >= 0; i--) {
            if (time[i] > max) {
                max = time[i];
                count++;
            }
        }

        return count;
    }
}
