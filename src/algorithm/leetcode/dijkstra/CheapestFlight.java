package algorithm.leetcode.dijkstra;

import javax.sound.sampled.Line;
import java.util.*;

public class CheapestFlight {

    public static void main(String[] args) {
        //n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
//        System.out.println(findCheapestPrice(4, new int[][]{{0,1,100}, {1,2,100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1)); // 700
//        System.out.println(findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));// 200
//        System.out.println(findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 0));// 500
        System.out.println(findCheapestPrice(4, new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}}, 0, 3, 1));
        /**
         * (0, 1, 100)
         * (1, 2, 100), (1, 2, 100), (1, 3, 600)
         * (2, 3, 200)
         * */
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       List<List<Ticket>> adj = new ArrayList<>();
       for (int i = 0; i < n; i++)
           adj.add(new ArrayList<>());
       for (int[] flight : flights) {
           adj.get(flight[0]).add(new Ticket(flight[1], flight[2]));
       }

       Queue<Loc> q = new LinkedList<>();
       q.offer(new Loc(src, 0));

       int[] minCost = new int[n];
       Arrays.fill(minCost, Integer.MAX_VALUE);
       minCost[src] = 0;

       int stops = 0;
       while (!q.isEmpty() && stops <= k) {
           int size = q.size();
           while (size-- > 0) {
               Loc vertex = q.poll();
               for (Ticket ticket : adj.get(vertex.vertex)) {
                   if (minCost[ticket.dst] >= vertex.cost + ticket.cost) {
                       minCost[ticket.dst] = vertex.cost + ticket.cost;
                       q.offer(new Loc(ticket.dst, minCost[ticket.dst]));
                   }
               }
           }
           stops++;
           System.out.println(Arrays.toString(minCost) + " " + stops);
       }
       return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }

    public static class Ticket{
        public int dst;
        public int cost;
        public int stop = -1;

        public Ticket(int dst, int cost) {
            this.dst = dst;
            this.cost = cost;
        }
    }

    public static class Loc{
        public int vertex;
        public int cost = 0;

        public Loc(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
