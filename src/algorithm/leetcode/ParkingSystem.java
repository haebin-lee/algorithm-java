package algorithm.leetcode;

public class ParkingSystem {
    public int big;
    public int medium;
    public int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (this.big > 0) {
                    this.big --;
                    return true;
                }
                return false;
            case 2:
                if (this.medium > 0) {
                    this.medium --;
                    return true;
                }
                return false;
            case 3:
                if (this.small > 0) {
                    this.small --;
                    return true;
                }
                return false;
            default: throw new IllegalArgumentException();
        }
    }
}
