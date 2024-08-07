package algorithm.doIt._10;

/**
 * 10-1. 이진검색트리
 */

class Node {
    int data;
    Node left, right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class Problem1 {

    static Node insert(Node node, int data) {
        Node newNode = null;
        if (node == null) {
            newNode = new Node(data, null, null);
        } else {
            if (node.data > data) {
                //왼쪽
                if (node.left == null) {
                    newNode = new Node(data, null, null);
                    node.left = newNode;
                } else {
                    insert(node.left, data);
                }
            } else {
                //오른쪽
                if (node.right == null) {
                    newNode = new Node(data, null, null);
                    node.right = newNode;
                } else {
                    insert(node.right, data);
                }
            }
        }

        return newNode;
    }

    public static void main(String[] args) {
        Node root = insert(null, 11);

        insert(root, 12);
        insert(root, 13);
        insert(root, 14);
        insert(root, 5);
        insert(root, 3);
    }
}