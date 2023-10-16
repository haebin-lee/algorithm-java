package algorithm.leetcode;

import java.util.*;

public class TopKFrequency {

    public static void main(String[] args) {
        String[] item = new String[]{"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(item, 2));
    }
    record WordFrequency(String word, int count) {};
    public static List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<WordFrequency> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.count == o2.count) {
                return o1.word.compareTo(o2.word);
            }
            return o2.count - o1.count;
        });

        Map<String, Integer> map = new HashMap<>();
        for(String text: words) {
            map.put(text, map.getOrDefault(text, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new WordFrequency(entry.getKey(), entry.getValue()));
        }

        List<String> result = new ArrayList<>();
        while (k > 0 && !pq.isEmpty()) {
            result.add(pq.poll().word);
            k--;
        }

        return result;
    }
}
