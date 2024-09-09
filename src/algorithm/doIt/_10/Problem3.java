package algorithm.doIt._10;


class Problem3 {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(35);
        tree.insert(20);
        tree.insert(50);
        tree.insert(10);
        tree.insert(30);
        tree.insert(40);
        tree.insert(80);
        tree.insert(5);
        tree.insert(15);
        tree.insert(12);
        tree.insert(16);
        tree.insert(13);
        tree.insert(25);
        tree.insert(33);
        tree.insert(37);
        tree.insert(45);
        tree.insert(2);
        tree.insert(27);

        tree.delete(10);
        tree.delete(15);
        tree.delete(33);
        tree.delete(37);
        tree.delete(35);
        tree.delete(40);

        tree.inorder();

    }
}
