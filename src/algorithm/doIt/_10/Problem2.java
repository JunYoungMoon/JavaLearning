package algorithm.doIt._10;


class Problem2 {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* AVL 트리에 데이터를 삽입 */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("AVL 트리의 중위 순회 결과:");
        tree.inorder(tree.root);
    }
}
