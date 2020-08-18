package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DFS {

    public static void main(String[] args) {

    }

    public static List<String> search(Map<String, List<String>> data, String start){
        List<String> visited = new ArrayList<>();
        List<String> needVisited = new ArrayList<>();

        needVisited.add(start);

        while(!needVisited.isEmpty()) {
            String node = needVisited.remove(needVisited.size()-1);

            if(!visited.contains(node)) {
                visited.add(node);
                needVisited.addAll(data.get(node));
            }

        }
        return visited;
    }
}
