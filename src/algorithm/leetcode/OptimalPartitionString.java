package algorithm.leetcode;

public class OptimalPartitionString {

    public static void main(String[] args) {

        System.out.println(partitionStringBitMask("abacaba"));
        System.out.println(partitionStringBitMask("ssssss"));

    }

    public static int partitionStringBitMask(String s) {
        int mask = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            int index = c - 'a';

            if ((mask & (1 << index)) != 0) {
                count++;
                mask = 0;
            }
            mask |= (1 << index);
        }

        return count +1;
    }
    public static int partitionString(String s) {
        int start = 0;
        int current = 1;
        int split = 0;
        while(true) {
            if (start >= s.length() || current >= s.length()) {
                split++;
                break;
            }

            if (s.substring(start, current).indexOf(s.charAt(current)) == -1) {
                current ++;
            } else {
                split ++;
                start = current;
                current ++;
            }
        }
        return split;
    }
}
