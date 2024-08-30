package algorithm.doIt._10;

/**
 * 10-1 이진 탐색 트리
 * 이진 트리의 한 종류이며 왼쪽 자식은 부모보다 작고, 오른쪽 자식은 부모보다 큰 규칙을 따르기 때문에
 * 정렬된 데이터를 빠르게 O(log n) 검색, 삽입, 삭제할 수 있다. 단, 불균형해질 때의 문제 O(n)가 있다.
 */

// 노드 클래스 정의
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// 이진 탐색 트리 클래스 정의
class BinarySearchTree {
    Node root;

    // 생성자
    BinarySearchTree() {
        root = null;
    }

    // 새로운 키를 삽입하는 메서드
    void insert(int key) {
        root = insertRec(root, key);
    }

    // 이진 탐색 트리에 새로운 노드를 재귀적으로 삽입
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // 키 값을 삭제하는 메서드
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    // 이진 탐색 트리에서 노드를 재귀적으로 삭제
    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    // 오른쪽 서브트리에서 가장 작은 값을 찾는 메서드
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // 키 값을 검색하는 메서드
    boolean search(int key) {
        return searchRec(root, key) != null;
    }

    // 이진 탐색 트리에서 키 값을 재귀적으로 검색
    Node searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }

    // 중위 순회(in-order traversal) 메서드
    void inorder() {
        inorderRec(root);
    }

    // 중위 순회 재귀 호출
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}

