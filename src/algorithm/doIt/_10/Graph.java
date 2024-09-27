package algorithm.doIt._10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Graph {
    private int vertices;
    private LinkedList<Edge>[] adjList;

    class Edge {
        int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // 간선 추가 (src에서 dest로 가는 가중치가 있는 간선)
    public void addEdge(int src, int dest, int weight) {
        adjList[src].add(new Edge(dest, weight));
        adjList[dest].add(new Edge(src, weight)); // 방향이 없으면 양방향 추가
    }

    // 다익스트라 알고리즘
    public void dijkstra(int startVertex) {
        int[] distances = new int[vertices]; // 출발점에서 각 정점까지의 최단 거리를 저장할 배열
        Arrays.fill(distances, Integer.MAX_VALUE); // 무한대로 초기화
        distances[startVertex] = 0; // 시작 정점은 거리가 0

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(startVertex, 0));

        while (!pq.isEmpty()) {
            Edge currentEdge = pq.poll();
            int currentVertex = currentEdge.vertex;

            for (Edge neighbor : adjList[currentVertex]) {
                int newDist = distances[currentVertex] + neighbor.weight;
                if (newDist < distances[neighbor.vertex]) {
                    distances[neighbor.vertex] = newDist;
                    pq.add(new Edge(neighbor.vertex, newDist));
                }
            }
        }

        // 결과 출력
        System.out.println("출발점 " + startVertex + "에서의 최단 거리:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("정점 " + i + "까지의 거리: " + distances[i]);
        }
    }
}
