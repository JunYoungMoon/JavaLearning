package algorithm.doIt._10;

/**
 * 10-2 AVL 트리
 * 이진 탐색 트리(BST)의 한 종류로, 트리가 자동으로 균형을 유지하도록 설계된 자료 구조다.
 * AVL 트리는 삽입, 삭제 등의 연산 후에도 트리의 높이 균형을 유지하기 위해
 * 회전(rotation) 연산을 사용하여 평균 및 최악의 경우 모두 O(log n)의 시간 복잡도를 보장한다.
 */
class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int d) {
        key = d;
        height = 1; // 리프 노드의 높이를 1로 초기화
    }
}

public class AVLTree {
    // AVL 트리의 노드를 나타내는 클래스
    AVLNode root;

    // 노드의 높이를 가져오는 유틸리티 함수
    int height(AVLNode N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    // 두 숫자 중 큰 값을 반환하는 유틸리티 함수
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // 오른쪽으로 회전하는 함수
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // 회전 수행
        x.right = y;
        y.left = T2;

        // 높이 업데이트
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // 새로운 루트를 반환
        return x;
    }

    // 왼쪽으로 회전하는 함수
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // 회전 수행
        y.left = x;
        x.right = T2;

        // 높이 업데이트
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // 새로운 루트를 반환
        return y;
    }

    // 노드의 균형 계수를 가져오는 함수
    int getBalance(AVLNode N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    // 키 값을 삽입하는 함수
    AVLNode insert(AVLNode node, int key) {
        // 1. 일반적인 BST 삽입
        if (node == null) {
            return (new AVLNode(key));
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // 중복 키는 허용되지 않음
            return node;
        }

        // 2. 노드의 높이 업데이트
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. 노드의 균형 상태를 확인하고 필요시 회전 수행
        int balance = getBalance(node);

        // LL(Left Left) 케이스
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // RR(Right Right) 케이스
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // LR(Left Right) 케이스
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL(Right Left) 케이스
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // 노드를 반환
        return node;
    }

    // 키 값을 삭제하는 함수
    AVLNode deleteNode(AVLNode root, int key) {
        // 1. 일반적인 BST 삭제
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            // 삭제할 노드를 찾음
            if ((root.left == null) || (root.right == null)) {
                AVLNode temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                if (temp == null) { // 자식이 없는 경우
                    temp = root;
                    root = null;
                } else { // 자식이 하나 있는 경우
                    root = temp; // 자식을 현재 노드로 복사
                }
            } else {
                // 자식이 둘 있는 경우
                AVLNode temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // 트리가 하나도 남지 않은 경우
        if (root == null) {
            return root;
        }

        // 2. 노드의 높이 업데이트
        root.height = max(height(root.left), height(root.right)) + 1;

        // 3. 노드의 균형 상태를 확인하고 필요시 회전 수행
        int balance = getBalance(root);

        // LL(Left Left) 케이스
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // LR(Left Right) 케이스
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR(Right Right) 케이스
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // RL(Right Left) 케이스
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // 가장 작은 값을 가진 노드를 찾는 함수
    AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // 중위 순회(in-order traversal) 메서드
    void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }
}
