package algorithm.basic;

public class Hanoi {

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
//        System.out.println(hanoi.hanoi(2, 1, 3, 2));
        System.out.println(hanoi.hanoi(3, 1, 3, 2));
    }

    public void move(int n, int start, int destination) {
        System.out.printf("%d번 원반을 %d에서 %d로 이동%n", n, start, destination);
    }
    public int hanoi(int n, int start, int destination, int via) {
        if (n <= 1) {
            move(1, start, destination);
            return 1;
        }

        int count = 0;
        // 원반 n-1 개를 시작 기둥에서 보조기둥으로 옮김
        count += hanoi(n-1, start, via, destination);

        // 가장 큰 원반을 시작 기둥에서 도착 기둥으로 이동
        count += 1;
        move(n, start, destination);

        // 원반 n-1개를 보조 기둥에서 도착 기둥으로 이동
        count += hanoi(n-1, via, destination, start);
        return count;
    }
}
