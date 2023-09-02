package algorithm.dijkstra;

import algorithm.leetcode.ListNode;

import java.util.*;

public class DijkstraAlgorithms {

    public static void main(String[] args) {

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");

        A.addEdge(new Edge(B, 5));
        A.addEdge(new Edge(C, 1));
        B.addEdge(new Edge(D, 2));
        C.addEdge(new Edge(D, 1));
        C.addEdge(new Edge(E, 7));
        D.addEdge(new Edge(E, 3));

        dijkstra(new Graph(Arrays.asList(A, B, C, D, E)), A);
        List<Node> path = getShortestPathTo(E);
        path.forEach(m -> System.out.print(m.name + " "));
        System.out.println();

    }
    public static List<Node> getShortestPathTo(Node target) {
        List<Node> path = new ArrayList<>();
        for (Node node = target; node != null; node = node.getPrevious()) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }

    public static void dijkstra (Graph graph, Node source) {
        source.setDistance(0);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(source);

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Edge edge: current.getEdges()) {
                Node neighbor = edge.getTarget();
                int distanceThroughCurrent = current.getDistance() + edge.getWeight();
                System.out.println("current: " + current.name+ " neighbor:" + neighbor.name + " distanceThroughCurrent:" + distanceThroughCurrent + " distance: " + neighbor.getDistance());

                if (distanceThroughCurrent < neighbor.getDistance()) {
                    pq.remove(neighbor);
                    neighbor.setDistance(distanceThroughCurrent);
                    neighbor.setPrevious(current);
                    pq.add(neighbor);
                }
            }
        }
    }


    public static class Node implements Comparable<Node>{
        private String name;
        private List<Edge> edges;
        private int distance = Integer.MAX_VALUE;
        private Node previous;

        public Node(String name) {
            this.name = name;
            this.edges = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void addEdge(Edge edge){
            this.edges.add(edge);
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    public static class Edge {
        private Node target;
        private int weight;

        public Edge(Node target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        public Node getTarget() {
            return target;
        }

        public void setTarget(Node target) {
            this.target = target;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    public static class Graph {
        private List<Node> nodes;
        public Graph(List<Node> nodes) {
            this.nodes = nodes;
        }
    }
}
