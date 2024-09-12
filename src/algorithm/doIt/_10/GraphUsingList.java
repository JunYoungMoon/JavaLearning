package algorithm.doIt._10;

import java.util.LinkedList;

public class GraphUsingList {
    private LinkedList<Integer>[] adjList; // 인접 리스트
    private int numVertices; // 정점의 수

    // 그래프 초기화
    public GraphUsingList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // 간선 추가 (방향이 없는 경우)
    public void addEdge(int src, int dest) {
        adjList[src].add(dest); // 방향이 없는 그래프일 경우
        adjList[dest].add(src); // 반대 방향도 추가
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
