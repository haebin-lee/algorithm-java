package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UndergroundSystem {

    // id 중복을 허용할까? - 일단 허용 안한다고 가정하자 - 오류나면 수정하도록
    // id 를 쉽게 찾는게 좋겠지? Map<String, Object> { 1: {}}
    // 평균시간도 쉽게 구해보자 {start, End, Time}

    // id, startStationName, startTime, endStationName, endStart
    private Map<Integer, CheckInNOut> people;
    private List<CheckInNOut> record;
    public UndergroundSystem() {
        people = new HashMap<>();
        record = new ArrayList<>();
    }

    public void checkIn(int id, String stationName, int t) {
        CheckInNOut checkInNOut = new CheckInNOut(stationName, t);
        people.put(id, checkInNOut);
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInNOut checkInNOut = people.get(id);
        checkInNOut.checkOut(stationName, t);
        people.put(id, checkInNOut);

        record.add(checkInNOut);
    }

    public double getAverageTime(String startStation, String endStation) {
        // 리스트 순회가 안좋은 방법인거 같은뎁 ㅠㅠ
        List<CheckInNOut> result = record.stream().filter(m -> m.find(startStation, endStation)).collect(Collectors.toList());
        return (double) result.stream().mapToInt(CheckInNOut::duration).sum() / result.size();
    }

    public static class CheckInNOut {
        private String start;
        private int startTime;

        private String end;

        private int endTime;

        public CheckInNOut(String start, int startTime) {
            this.start = start;
            this.startTime = startTime;
        }

        public void checkOut(String end, int endTime) {
            this.end = end;
            this.endTime = endTime;
        }

        public boolean find(String start, String end) {
            return start.equals(this.start) && end.equals(this.end);
        }

        public int duration() {
            return endTime - startTime;
        }
    }
}
