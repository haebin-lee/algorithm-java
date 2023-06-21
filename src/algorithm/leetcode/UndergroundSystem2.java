package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UndergroundSystem2 {
    // 성능을 고려한 예제들이 많긴 한데, 과연 좋은 건가 싶다.
    // 내꺼가 현업에서는 더 이해하기 쉽지 않을까? 문제를 풀기만 하면 되는건가.

    public static void main(String[] args) {
        UndergroundSystem2 system2 = new UndergroundSystem2();
        system2.checkIn(45, "Leyton", 3);
        system2.checkIn(32, "Paradise", 8);
        system2.checkIn(27, "Leyton", 10);
        system2.checkOut(45, "Waterloo", 15);
        system2.checkOut(27, "Waterloo", 20);
        system2.checkOut(32, "Cambridge", 22);
        system2.getAverageTime("Paradise", "Cambridge");
        system2.getAverageTime("Leyton", "Waterloo");
        system2.checkIn(10, "Leyton", 24);
        system2.getAverageTime("Leyton", "Waterloo");
        system2.checkOut(10, "Waterloo", 38);
        system2.getAverageTime("Leyton", "Waterloo");
    }
    private Map<Integer, Pair<String, Integer>> m;
    private Map<Pair<String, String>, List<Integer>> avg;

    public UndergroundSystem2() {
        m = new HashMap<>();
        avg = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        m.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> temp = m.get(id);
        int duration = t - temp.second;

        Pair<String, String> key = new Pair<>(temp.first, stationName);
        avg.computeIfAbsent(key, k -> new ArrayList<>()).add(duration);
    }

    public double getAverageTime(String startStation, String endStation) {
        Pair<String, String > key = new Pair<>(startStation, endStation);
        List<Integer> temp = avg.getOrDefault(key, new ArrayList<>());

        double sum = 0;
        for (int time: temp) {
            sum += time;
        }
        return sum / (temp.size() * 1.0);
    }

    public static class Pair<T, U> {
        public T first;
        public U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}
