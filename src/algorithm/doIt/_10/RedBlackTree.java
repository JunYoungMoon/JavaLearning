package algorithm.doIt._10;

/**
 * 10-3 RedBlack 트리
 * 개념 참고 주소 : https://www.youtube.com/watch?v=2MdsebfJOyM
 * 속성 5가지
 * 1.모든 모드는 RED 혹은 BLACK
 * 2.루트 노드는 BLACK
 * 3.모든 leaf 노드는 BLACK
 * 4.RED가 연속적으로 존재할 수 없다.
 * 5.임의의 노드에서 자손 leaf 노드들까지 가는 경로들의 BLACK 수는 같다. (자기자신은 카운트에서 제외)
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

        //루트 노드일때는 2번 규칙 설정
        if (node.parent == null) {
            node.color = BLACK;
            return;
        }
        //깊이가 1일때는 굳이 Red Black 복구를 하지 않아도 된다.
        if (node.parent.parent == null) return;

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
    private void insertFix(Node k) {
        //나는 당연히 RED이고 부모가 RED일때 계층간 중복 레드는 균형을 잡아야 한다.(4번 규칙 위배)
        while (k.parent.color == RED) {
            //부모의 위치 구분
            if (k.parent == k.parent.parent.right) { //부모가 오른쪽
                Node u = k.parent.parent.left; //왼쪽은 삼촌

                //삼촌과 부모가 RED 일때 조상:RED 삼촌,부모:BLACK 변경 (변경해도 5번 규칙 성립)
                if (u.color == RED) {
                    u.color = BLACK;
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    //현재 노드를 나에서 할아버지로 변경한 다음 다시 체크 필요
                    k = k.parent.parent;
                } else {
                    //내가 부모의 좌측 노드일때 즉 조상,부모,나에서 봤을떄 '>' 이런 모양
                    if (k == k.parent.left) {
                        //부모를 기준으로 우측 회전
                        k = k.parent;
                        //우측 회전을 하게 되면 ↘ 이러한 형태로 아래쪽으로 쭉 펴준다.
                        //개념 참고 링크에서 Case2에 해당
                        rightRotate(k);
                    }

                    //그리고 부모와 조상의 색깔을 변경후 좌측으로 회전시킨다.
                    //개념 참고 링크에서 Case1에 해당
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    leftRotate(k.parent.parent);
                }
            } else { //부모가 왼쪽
                Node u = k.parent.parent.right; //오른쪽은 삼촌

                if (u.color == RED) {
                    u.color = BLACK;
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    rightRotate(k.parent.parent);
                }
            }

            if (k == root) break;
        }
        root.color = BLACK; //2번 규칙 적용
    }

    //오른쪽 회전
    private void rightRotate(Node x) {
        Node y = x.left;
        //y의 우측에 붕뜨는 노드를 떼어낼 x노드의 좌측에 연결하고 부모값도 설정한다.
        x.left = y.right;
        if (y.right != TNULL) y.right.parent = x;
        //y를 이제 우측 회전하기 위에 잡아 당겨 올린다.
        y.parent = x.parent;
        if (x.parent == null) root = y; //x의 부모가 없을때는 y가 루트노드가 된다.
        else if (x == x.parent.right) x.parent.right = y; //x의 부모의 right가 x라면 y를 x의 부모의 right로 설정 한다.
        else x.parent.left = y; //x의 부모의 left가 x라면 y를 x의 부모의 left로 설정 한다.
        //떼어낸 x의 노드를 y의 오른쪽에 붙이고 부모로 설정한다.
        y.right = x;
        x.parent = y;
    }

    //왼쪽 회전
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    //올바르게 정렬이 되었는지 중위 탐색
    public void inorder() {
        inorderHelper(this.root);
        System.out.println();
    }

    private void inorderHelper(Node node) {
        if (node != TNULL) {
            inorderHelper(node.left);
            System.out.print(node.key + " ");
            inorderHelper(node.right);
        }
    }
}