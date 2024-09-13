package algorithm.doIt._10;


class Problem4 {
    public static void main(String[] args) {
        // 인접 행렬 그래프 생성
        GraphUsingMatrix matrixGraph = new GraphUsingMatrix(4);
        matrixGraph.addEdge(0, 1);
        matrixGraph.addEdge(0, 2);
        matrixGraph.addEdge(1, 2);
        matrixGraph.addEdge(2, 3);

        // 인접 리스트 그래프 생성
        GraphUsingList listGraph = new GraphUsingList(4);
        listGraph.addEdge(0, 1);
        listGraph.addEdge(0, 2);
        listGraph.addEdge(1, 2);
        listGraph.addEdge(2, 3);

        // 최적화된 DFS 탐색 수행
        System.out.println("DFS 탐색 (인접 행렬):");
        matrixGraph.dfs(0); // 인접 행렬 그래프에서 DFS 시작

        System.out.println("\nDFS 탐색 (인접 리스트):");
        listGraph.dfs(0); // 인접 리스트 그래프에서 DFS 시작
   }
}
