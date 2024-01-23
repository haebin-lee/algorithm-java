package algorithm.leetcode.prefix;

public class HighestAltitude {

    public static void main(String[] args) {
        HighestAltitude p = new HighestAltitude();
        System.out.println(p.largestAltitude(new int[]{-5,1,5,0,-7}));
    }

    public int largestAltitude(int[] gain) {
        int[] net = new int[gain.length + 1];
        int idx = 1;
        int max = 0;
        for (int i = 0; i < gain.length; i++) {
            net[idx] = net[idx-1] + gain[i];
            max = Math.max(max, net[idx]);
            idx++;
        }
        return max;
    }
}
