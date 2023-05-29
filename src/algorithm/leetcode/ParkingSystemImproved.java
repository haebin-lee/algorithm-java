package algorithm.leetcode;

public class ParkingSystemImproved {

    private int slots[] = new int[3];

    // big: 1, medium: 2, small: 3
    public ParkingSystemImproved(int big, int medium, int small) {
        slots[0] = big;
        slots[1] = medium;
        slots[2] = small;
    }

    public boolean add(int carType) {
        if (slots[carType -1 ] > 0) {
            slots[carType - 1] --;
            return true;
        }
        return false;
    }
}
