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
    private final Node TNULL; // 리프노드

    //키가 0이면서 검은색인 루트 노드 생성
    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.color = BLACK;
        root = TNULL;
    }

    // 새 노드 삽입
    public void insert(int key) {
        Node node = new Node(key); //새로운 노드를 생성하면서 양쪽 리프노드 연결
        root = insertRecursive(root, node); // 새로운 노드를 추가 그리고 변경된 root 업데이트
        insertFix(node); // 현재 노드를 파라미터로 전달
    }

    private Node insertRecursive(Node current, Node node) {
        // 재귀 베이스 케이스
        if (current == TNULL) {
            return node;
        }

        if (node.key < current.key) {
            current.left = insertRecursive(current.left, node);
            current.left.parent = current;
        } else {
            current.right = insertRecursive(current.right, node);
            current.right.parent = current;
        }

        return current;
    }

    //RedBlack 트리 특성 복구
    private void insertFix(Node node) {

    }
}
