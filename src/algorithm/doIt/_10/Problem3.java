package algorithm.doIt._10;


class Problem3 {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(20);
        tree.insert(10);
        tree.insert(5);
        tree.insert(50);
        tree.insert(80);
        tree.insert(40);
        tree.insert(35);
        tree.insert(20);

        tree.inorder();
    }
}