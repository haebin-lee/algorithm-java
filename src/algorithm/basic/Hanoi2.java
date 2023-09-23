package algorithm.basic;

import java.util.Arrays;

public class Hanoi2 {
    private int[][][] memo; // Memoization table

    public Hanoi2(int n) {
        memo = new int[n + 1][4][4]; // Initialize the memoization table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
    }

    public void move(int n, int start, int destination) {
        System.out.printf("%d번 원반을 %d에서 %d로 이동%n", n, start, destination);
    }

    public int hanoi(int n, int start, int destination, int via) {
        if (n <= 1) {
            move(1, start, destination);
            return 1;
        }

        if (memo[n][start][destination] != -1) {
            return memo[n][start][destination];
        }

        int count = 0;
        // 원반 n-1 개를 시작 기둥에서 보조기둥으로 옮김
        count += hanoi(n - 1, start, via, destination);

        // 가장 큰 원반을 시작 기둥에서 도착 기둥으로 이동
        count += 1;
        move(n, start, destination);

        // 원반 n-1개를 보조 기둥에서 도착 기둥으로 이동
        count += hanoi(n - 1, via, destination, start);

        memo[n][start][destination] = count;
        return count;
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        Hanoi2 hanoiSolver = new Hanoi2(n);
        int count = hanoiSolver.hanoi(n, 1, 3, 2);
        System.out.println("Total moves: " + count);
    }
}
