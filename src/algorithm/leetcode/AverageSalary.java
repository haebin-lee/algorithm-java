package algorithm.leetcode;

public class AverageSalary {
    public static void main(String[] args) {
        int[] salary = {4000, 3000, 1000, 2000};
        System.out.println(average(salary));
        int[] salary1 = {1000, 2000, 3000};
        System.out.println(average(salary1));
    }

    public static double average(int[] salary) {
        int sum = 0, max = 0, min = 0;
        if (salary[0] > salary[1]) {
            max = salary[0];
            min = salary[1];
        } else {
            min = salary[0];
            max = salary[1];
        }
        for (int i = 2; i < salary.length ; i ++) {
            if (max < salary[i]) {
                sum += max;
                max = salary[i];
            } else if (min > salary[i]) {
                sum += min;
                min = salary[i];
            } else {
                sum += salary[i];
            };
        }

        return (double) sum / (salary.length - 2);
    }
}
