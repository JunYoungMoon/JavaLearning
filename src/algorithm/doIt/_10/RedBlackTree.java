package algorithm.doIt._10;

/**
 * 10-3 RedBlack 트리
 * 새로운 노드를 RED로 생성
 */
public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        int key;
        Node left, right, parent;
        boolean color; // RED 혹은 BLACK

        Node(int key) {
            this.key = key;
            this.color = RED;
            this.left = TNULL;
            this.right = TNULL;
            this.parent = null;
        }
    }

    private Node root;
    private final Node TNULL; // 리프를 위한 감시노드

    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.color = BLACK;
        root = TNULL;
    }
}
