package algorithm.leetcode.dfs;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RoomsAndKeys {

    public static void main(String[] args) {
        RoomsAndKeys p = new RoomsAndKeys();
        // [[1],[2],[3],[]]
        System.out.println(p.canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        // [[1,3],[3,0,1],[2],[0]]
        System.out.println(p.canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0))));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] locked = new boolean[rooms.size()];
        Arrays.fill(locked, true);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int count = 0;
        while(!stack.isEmpty()) {
            Integer key = stack.pop();
            if (locked[key]) {
                locked[key] = false;
                count++;
                List<Integer> keys = rooms.get(key);
                for (int i = 0; i < keys.size(); i++) {
                    if(locked[keys.get(i)])
                        stack.push(keys.get(i));
                }
            }
        }
        System.out.println(Arrays.toString(locked));

        return count == rooms.size();
    }
}
