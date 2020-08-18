package algorithm.bfs;

import algorithm.dfs.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BFS {

    public static void main(String[] args) {

        Map<String, List<String>>data = new HashMap<>();
        data.put("A", Stream.of("B","C").collect(Collectors.toList()));
        data.put("B", Stream.of("A","D").collect(Collectors.toList()));
        data.put("C", Stream.of("A","G","H","I").collect(Collectors.toList()));
        data.put("D", Stream.of("B","E","F").collect(Collectors.toList()));
        data.put("E", Stream.of("D").collect(Collectors.toList()));
        data.put("F", Stream.of("D").collect(Collectors.toList()));
        data.put("G", Stream.of("C").collect(Collectors.toList()));
        data.put("H", Stream.of("C").collect(Collectors.toList()));
        data.put("I", Stream.of("C","J").collect(Collectors.toList()));
        data.put("J", Stream.of("I").collect(Collectors.toList()));

        System.out.printf("BFS result=%s\n", BFS.search(data, "A"));
        System.out.printf("DFS result=%s\n", DFS.search(data, "A"));
    }

    public static List<String> search(Map<String, List<String>> data, String start){
        List<String> visited = new ArrayList<>();
        List<String> needVisited = new ArrayList<>();

        needVisited.add(start);

        while(!needVisited.isEmpty()) {
            String node = needVisited.remove(0);

            if(!visited.contains(node)) {
                visited.add(node);
                needVisited.addAll(data.get(node));
            }

        }
        return visited;
    }
}
