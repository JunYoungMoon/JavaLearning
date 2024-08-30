package algorithm.doIt._10;


class Problem1 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* 이진 탐색 트리에 데이터를 삽입 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("이진 탐색 트리의 중위 순회 결과:");
        tree.inorder();

        System.out.println("\n\n키 값 40을 검색:");
        System.out.println(tree.search(40) ? "키 값 40이 존재합니다." : "키 값 40이 존재하지 않습니다.");

        System.out.println("\n키 값 20을 삭제합니다.");
        tree.deleteKey(20);
        System.out.println("이진 탐색 트리의 중위 순회 결과:");
        tree.inorder();
    }
}
