package algorithm.leetcode.binarysearch;

import com.sun.source.tree.Tree;

import java.util.*;

public class TimeMap {

    public static void main(String[] args) {
        //["TimeMap", "set", "get", "get", "set", "get", "get"]
        //[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
        TimeMap p = new TimeMap();
        p.set("foo", "bar", 1);
        System.out.println(p.get("foo", 1));
        System.out.println(p.get("foo", 3));
        p.set("foo", "bar2", 4);
        System.out.println(p.get("foo", 4));
        System.out.println(p.get("foo", 5));

//        System.out.println(p.binarySearch(new int[]{1,3,5,7,9}, 0)); // -1
//        System.out.println(p.binarySearch(new int[]{1,3,5,7,9}, 1)); // 1
//        System.out.println(p.binarySearch(new int[]{1,3,5,7,9}, 2)); // 1
//        System.out.println(p.binarySearch(new int[]{1,3,5,7,9}, 3)); // 3
//        System.out.println(p.binarySearch(new int[]{1,3,5,7,9}, 9)); // 9
//        System.out.println(p.binarySearch(new int[]{1,3,5,7,9}, 10)); // 9
//        System.out.println(p.binarySearch(new int[]{1}, 2));

    }
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, m -> new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> values = map.get(key);
        if (values != null) {
            Integer floorKey = values.floorKey(timestamp);
            if (floorKey != null) {
                return values.get(floorKey);
            }
        }
        return "";
    }

    public int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return arr[mid];
            else if (target < arr[mid]) {
                end = mid;
            } else {
                start = mid;
            }
            if ((end - start) <= 1) {
                if (arr[end] <= target) {
                    return arr[end];
                }
                if (arr[start] <= target)
                    return arr[start];
                return -1;
            }
        }
        return -1;
    }
}
