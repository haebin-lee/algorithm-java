package algorithm.leetcode.stack;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class StockSpanner {
    SortedMap<Integer, Integer> map = new TreeMap<>();
    public StockSpanner() {
        map = new TreeMap<>();
    }

    public int next(int price) {
        map.compute(price, (k, v) -> v == null? 1 : v + 1);

        Set<Integer> keys = map.keySet();
        int count = 0;
        for (Integer key: keys) {
            if (key > price) break;
            count += map.get(key);
        }

        return count;
    }
}
