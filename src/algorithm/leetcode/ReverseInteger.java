package algorithm.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x)); // 321

        int y = -123;
        System.out.println(reverse(y)); // -321

        int z = 120;
        System.out.println(reverse(z)); // 12

        int k = 1534236469;
        System.out.println(reverse(k)); // 0

        int m = -2147483648;
        System.out.println(reverse(k)); // 0

    }

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int last = x % 10;
            result += last;
            result *= 10;
            x /= 10;
        }
        result = result / 10;
        if(result > Integer.MAX_VALUE || result<Integer.MIN_VALUE) {
            result = 0;
        }
        if (x < 0) {
            result *= -1;
        }
        return (int) result;
    }

    public static int reverseUpgrade(int x) {
        long finalNum = 0;
        while(x != 0){
            int lastDig = x % 10;
            finalNum += lastDig;
            finalNum = finalNum * 10;
            x = x / 10;
            System.out.println(lastDig +", " + finalNum + " , " + x);
        }
        finalNum = finalNum / 10;
        if(finalNum > Integer.MAX_VALUE || finalNum<Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            return (int)(-1*finalNum);
        }
        return (int) finalNum;
    }
}
