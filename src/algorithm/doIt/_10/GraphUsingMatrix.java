package algorithm.doIt._10;

public class GraphUsingMatrix {
    private int[][] adjMatrix; // 인접 행렬
    private int numVertices; // 정점의 수

    // 그래프 초기화
    public GraphUsingMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // 간선 추가
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1; // 방향이 없는 그래프일 경우
        adjMatrix[j][i] = 1; // 반대 방향도 추가
    }

    // 간선 제거
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
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
