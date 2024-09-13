package algorithm.doIt._10;

import java.util.ArrayList;
import java.util.List;

/**
 * 인접 행렬(Adjacency Matrix)
 * 장점
 * 1. 배열 인덱스로 엣지 존재 여부를 빠르게 확인 가능
 * 
 * 단점
 * 1. 메모리 사용량이 많음
 *  - 그래프의 정점 수가 V일 때, 메모리 사용량은 O(V²)이다.
 *  - 엣지가 적은 희소 그래프(Sparse Graph)에서 메모리를 비효율적으로 사용하게 된다.
 * 2. 모든 엣지 정보를 전체 순회
 *  - 모든 엣지에 대한 정보를 순회하려면 배열 전체를 확인해야 하기 때문에 O(V²)의 시간 복잡도를 가진다.
 */
public class GraphUsingMatrix {
    private int[][] adjMatrix; // 인접 행렬
    private int numVertices; // 정점의 수
    private boolean[] visited; // 방문 여부 확인 배열

    // 그래프 초기화
    public GraphUsingMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // 엣지 추가
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1; // 방향이 없는 그래프일 경우
        adjMatrix[j][i] = 1; // 반대 방향도 추가
    }

    public void dfs(int startVertex) {
        visited = new boolean[numVertices];
        dfsRecursive(startVertex);
    }

    private void dfsRecursive(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                dfsRecursive(i);
            }
        }
    }

    // 그래프 출력
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
