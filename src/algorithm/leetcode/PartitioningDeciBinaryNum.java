package algorithm.leetcode;

public class PartitioningDeciBinaryNum {

    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
        System.out.println(minPartitions("82734"));
        System.out.println(minPartitions("27346209830709182346"));
    }

    public static int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length() ; i++) {
            if (n.charAt(i) - '0' == '9') {
                return 9;
            }
            max = Math.max(max, n.charAt(i) - '0');
        }
        return max;
    }
}
