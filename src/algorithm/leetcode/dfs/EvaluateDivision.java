package algorithm.leetcode.dfs;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        EvaluateDivision p = new EvaluateDivision();
        List<List<String>> eq = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> q = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        System.out.println(Arrays.toString(p.calcEquation(eq, values, q)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // a/b = 2 -> a=2b, b=0.5a
        // b/c = 3 -> b=3c, c=1/3b
        Map<String, Map<String, Double>> map = buildMap(equations, values);
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            if (!map.containsKey(a) || !map.containsKey(b)) {
                ans[i] = -1;
            } else {
                Set<String> visited = new HashSet<>();
                Double[] answer = {-1.0};
                dfs(map, visited, a, b, 1.0, answer);
                ans[i] = answer[0];
            }
        }
        return ans;
    }

    public void dfs(Map<String, Map<String, Double>> map, Set<String> visited, String src, String dest, Double current, Double[] answer) {
        if (visited.contains(src)) return;
        visited.add(src);

        if (src.equals(dest)) {
            answer[0] = current;
            return;
        }
        for (Map.Entry<String, Double> entry : map.get(src).entrySet()) {
            dfs(map, visited, entry.getKey(), dest, current * entry.getValue(), answer);
        }
    }

    public Map<String, Map<String, Double>> buildMap(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>(); // a = 2b (a, (b, 2))로 저장
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            double v = values[i];
            map.putIfAbsent(equation.get(0), new HashMap<>());
            map.putIfAbsent(equation.get(1), new HashMap<>());

            map.get(equation.get(0)).put(equation.get(1), v);
            map.get(equation.get(1)).put(equation.get(0), 1 / v);
        }
        System.out.println(map);
        return map;
    }
}
