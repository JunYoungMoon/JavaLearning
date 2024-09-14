package algorithm.doIt._10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 인접 리스트(Adjacency List)
 * 장점
 * 1. 메모리 사용량이 적음
 * 2. 엣지 추가가 빠름
 *
 * 단점
 * 1. 엣지 존재 여부 확인이 느림
 *  - 그특정 두 노드 간의 엣지이 존재하는지 확인하려면 해당 리스트를 탐색해야 하므로, 최악의 경우 O(V) 시간이 소요된다.
 * 2. 밀집 그래프(Dense Graph)에서는 비효율적
 *  - 엣지이 많은 밀집 그래프에서는 인접 리스트를 관리하는 오버헤드가 증가할 수 있다.
 */
public class GraphUsingList {
    private LinkedList<Integer>[] adjList; // 인접 리스트
    private int numVertices; // 정점의 수
    private boolean[] visited; // 방문 여부 확인 배열

    // 그래프 초기화
    public GraphUsingList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // 엣지 추가 (방향이 없는 경우)
    public void addEdge(int src, int dest) {
        adjList[src].add(dest); // 방향이 없는 그래프일 경우
        adjList[dest].add(src); // 반대 방향도 추가
    }

    // DFS 탐색
    public void dfs(int startVertex) {
        visited = new boolean[numVertices];
        dfsRecursive(startVertex);
    }

    // DFS 탐색 재귀
    private void dfsRecursive(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adjVertex : adjList[vertex]) {
            if (!visited[adjVertex]) {
                dfsRecursive(adjVertex);
            }
        }
    }

    // BFS 탐색
    public void bfs(int startVertex) {
        visited = new boolean[numVertices]; // 방문 여부 배열 초기화
        Queue<Integer> queue = new LinkedList<>(); // BFS용 큐 생성

        visited[startVertex] = true; // 시작 정점을 방문 처리
        queue.offer(startVertex); // 큐에 시작 정점 추가

        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // 큐에서 정점을 꺼냄
            System.out.print(vertex + " "); // 방문한 정점 출력

            // 인접한 모든 정점을 확인
            for (int adjVertex : adjList[vertex]) {
                if (!visited[adjVertex]) { // 아직 방문하지 않은 정점이면
                    visited[adjVertex] = true; // 방문 처리
                    queue.offer(adjVertex); // 큐에 추가
                }
            }
        }
    }

    // 그래프 출력
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("정점 " + i + ": ");
            for (Integer node : adjList[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
