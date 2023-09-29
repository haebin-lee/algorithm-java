package algorithm.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {
    int capacity;
    LinkedHashMap<Integer, Integer> dic;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        dic = new LinkedHashMap<>(5, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return dic.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        dic.put(key, value);
    }
}

