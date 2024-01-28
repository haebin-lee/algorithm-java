package algorithm.leetcode.dfs;

import java.util.*;

public class DivisionEquation {

//    public static void main(String[] args) {
//        DivisionEquation p = new DivisionEquation();
//        // equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
//        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
//        double[] values = new double[]{2.0, 3.0};
//        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x"));
//
//        System.out.println(Arrays.toString(p.calcEquation(equations, values, queries)));
//    }
//
//    record Eq(double num, String ch){};
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        // a/b = 2 -> a=2b, b=0.5a
//        // b/c = 3 -> b=3c, c=1/3b
//        // a: 2b
//        // b: 0.5a, b=3c
//        // c: 1/3b
//        Map<String, List<Eq>> map = new HashMap<>();
//        for (int i = 0; i < values.length; i++) {
//            List<String> eq = equations.get(i);
//            double value = values[i];
//            map.putIfAbsent(eq.get(0), new ArrayList<>());
//            map.putIfAbsent(eq.get(1), new ArrayList<>());
//            map.get(eq.get(0)).add(new Eq(value, eq.get(1)));
//            map.get(eq.get(1)).add(new Eq( 1 / value, eq.get(0)));
//        }
//
//        for (List<String> q: queries) {
//
//        }
//
//    }
//
//    public double dfs(Map<String, List<Eq>>map, String p, String q) {
//        if (!map.containsKey(p) ||!map.containsKey(q)) return -1;
//        Set<String> visited = new HashSet<>();
//    }
}
