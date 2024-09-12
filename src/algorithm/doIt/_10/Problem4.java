package algorithm.doIt._10;


class Problem4 {
    public static void main(String[] args) {
//        GraphUsingMatrix graph = new GraphUsingMatrix(4);
        GraphUsingList graph = new GraphUsingList(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        graph.printGraph();
    }
}
