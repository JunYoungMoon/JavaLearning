package dataStructure;

/**
 * 이진트리
 */
public class BinaryTree {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    static class SimpleBinaryTree {
        Node root;

        SimpleBinaryTree() {
            root = null;
        }

        void insert(int value) {
            root = insertRec(root, value);
        }

        Node insertRec(Node root, int value) {
            if (root == null) {
                root = new Node(value);
                return root;
            }
            if (value < root.value) {
                root.left = insertRec(root.left, value);
            } else if (value > root.value) {
                root.right = insertRec(root.right, value);
            }
            return root;
        }

        void printTree() {
            printRec(root);
        }

        void printRec(Node root) {
            if (root != null) {
                printRec(root.left);
                System.out.print(root.value + " ");
                printRec(root.right);
            }
        }
    }

    public static void main(String[] args) {
        SimpleBinaryTree tree = new SimpleBinaryTree();

        // 노드 삽입
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        // 트리 출력
        System.out.print("이진 트리의 값들: ");
        tree.printTree();
    }
}

