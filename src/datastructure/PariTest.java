package datastructure;

import algorithm.leetcode.UndergroundSystem2;
import javafx.util.Pair;

import java.util.*;

public class PariTest {
    public static void main(String[] args) {
        Pair<String, Integer> tuple = new Pair<>("apple", 1);
        Pair<String, Integer> tuple2 = new Pair<>("banana", 2);
        Pair<String, Integer> tuple3 = new Pair<>("car", 3);;

        Set<Pair<String, Integer>> list = new TreeSet<>(Comparator.comparing(Pair::getKey));
        list.add(tuple);
        list.add(tuple2);
        list.add(tuple3);

        Iterator<Pair<String, Integer>> iter = list.iterator();
        while (iter.hasNext()){
            Pair<String, Integer> pair = iter.next();
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
