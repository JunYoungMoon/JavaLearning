package algorithm.doIt._10;


class Problem5 {
    public static void main(String[] args) {
        // 인접 행렬 그래프 생성
        GraphUsingMatrix matrixGraph = new GraphUsingMatrix(6);
        matrixGraph.addEdge(0, 1);
        matrixGraph.addEdge(0, 2);
        matrixGraph.addEdge(1, 3);
        matrixGraph.addEdge(1, 4);
        matrixGraph.addEdge(2, 5);

        // 인접 리스트 그래프 생성
        GraphUsingList listGraph = new GraphUsingList(6);
        listGraph.addEdge(0, 1);
        listGraph.addEdge(0, 2);
        listGraph.addEdge(1, 3);
        listGraph.addEdge(1, 4);
        listGraph.addEdge(2, 5);

        // DFS 탐색 수행
        System.out.println("DFS 탐색 (인접 행렬):");
        matrixGraph.dfs(0); // 인접 행렬 그래프에서 DFS 시작

        System.out.println("\nDFS 탐색 (인접 리스트):");
        listGraph.dfs(0); // 인접 리스트 그래프에서 DFS 시작

        // BFS 탐색 수행
        System.out.println("\nBFS 탐색 (인접 행렬):");
        matrixGraph.bfs(0); // 인접 행렬 그래프에서 BFS 시작

        System.out.println("\nBFS 탐색 (인접 리스트):");
        listGraph.bfs(0); // 인접 리스트 그래프에서 BFS 시작
   }
}
