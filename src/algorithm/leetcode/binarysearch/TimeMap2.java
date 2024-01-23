package algorithm.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap2 {

    record Pair(int timestamp, String val){};

    private Map<String, List<Pair>> map;
    public TimeMap2() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, m -> new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        String result = "";

        if (map.containsKey(key)) {
            List<Pair> arr = map.get(key);
            int low = 0, high = arr.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int time = arr.get(mid).timestamp;
                if (time == timestamp)
                    return arr.get(mid).val;
                else if (time < timestamp) {
                    result = arr.get(low).val;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return result;
    }
}
