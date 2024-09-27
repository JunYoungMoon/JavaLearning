package algorithm.doIt._10;


class Problem6 {
    public static void main(String[] args) {
        int numVertices = 5; // 정점의 수
        Graph graph = new Graph(numVertices);

        // 간선 추가 (src, dest, 가중치)
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 7);
        graph.addEdge(4, 1, 3);
        graph.addEdge(4, 2, 9);
        graph.addEdge(4, 3, 2);

        // 다익스트라 알고리즘 실행 (출발점은 0번 정점)
        graph.dijkstra(0);
   }
}
