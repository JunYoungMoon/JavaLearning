package algorithm.doIt._10;

/**
 * 레드-블랙 트리
 *
 * 레드-블랙 트리란?
 * 이진 탐색 트리(BST)의 한 종류로, 노드의 "색상"과 몇 가지 "규칙"을 통해 트리가 자동으로 균형을 유지하도록 설계된 자료 구조이다.
 *
 * 특징
 * - 덜 엄격한 균형 조건으로 삽입, 삭제시 AVL 트리 보다 더 적은 회전을 한다.
 * - 삽입, 삭제가 빈번한 현대 소프트웨어에서 AVL 트리보다 레드-블랙 트리가 좀더 자주 사용된다.
 * - 평균 및 최악의 경우 모두 O(log n)의 시간 복잡도를 보장한다.
 *
 * 레드-블랙 트리의 규칙
 * 1. 모든 노드는 RED 또는 BLACK이다.
 * 2. 루트 노드는 항상 BLACK이다.
 * 3. 모든 리프 노드(nil)는 BLACK이다.
 * 4. RED 노드의 자식 노드는 항상 BLACK이다. (즉, 연속적으로 RED가 나올 수 없다.)
 * 5. 임의의 노드에서 자손 리프 노드들까지 가는 경로의 BLACK 노드 개수는 모두 같다. (자기 자신은 카운트에서 제외한다.)
 *
 * 삭제 연산의 경우 (Deletion Cases)
 * - 레드-블랙 트리에서 삭제 연산을 수행할 때 발생할 수 있는 네 가지 경우와 그에 따른 해결 방법을 설명
 *
 * Case 1: "doubly black" 노드의 형제가 RED인 경우
 * 해결 방법: 형제와 부모의 색을 바꾸고, 부모를 기준으로 좌회전합니다. 그 후에 Case 2, 3, 4 중 하나로 해결한다.
 *
 * Case 2: "doubly black" 노드의 형제가 BLACK이고, 형제의 두 자녀가 모두 BLACK인 경우
 * 해결 방법: 형제 노드를 RED로 바꾸고 "doubly black"을 부모에게 전달한다.
 * 부모가 "red-and-black"이 되면 BLACK으로 바꾸고, "doubly black"이 되면 루트일 때는 BLACK으로 해결, 아니면 다시 Case 1, 2, 3, 4로 해결한다.
 *
 * Case 3: "doubly black" 노드의 형제가 BLACK이고, 형제의 왼쪽 자녀가 RED, 오른쪽 자녀는 BLACK인 경우
 * 해결 방법: 형제와 형제의 왼쪽 자녀의 색을 바꾸고, 형제를 기준으로 우회전한다. 이후 Case 4로 해결한다.
 *
 * Case 4: "doubly black" 노드의 형제가 BLACK이고, 형제의 오른쪽 자녀가 RED인 경우
 * 해결 방법: 형제의 색을 부모의 색으로 바꾸고, 형제의 오른쪽 자녀를 BLACK으로 바꾼 후 부모를 BLACK으로 변경한다. 그리고 부모를 기준으로 좌회전한다.
 *
 * 참고 자료
 * - 레드-블랙 트리 개념 참고 영상: https://www.youtube.com/watch?v=2MdsebfJOyM
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
        root = insertNodeRecursive(root, node); // 새로운 노드를 추가 그리고 변경된 root 업데이트

        //루트 노드일때는 2번 규칙 설정
        if (node.parent == null) {
            node.color = BLACK;
            return;
        }
        //깊이가 1일때는 굳이 Red Black 복구를 하지 않아도 된다.
        if (node.parent.parent == null) return;

        insertFix(node); // 현재 노드를 파라미터로 전달
    }

    private Node insertNodeRecursive(Node current, Node node) {
        // 재귀 베이스 케이스
        if (current == TNULL) {
            return node;
        }

        if (node.key < current.key) {
            current.left = insertNodeRecursive(current.left, node);
            current.left.parent = current;
        } else {
            current.right = insertNodeRecursive(current.right, node);
            current.right.parent = current;
        }

        return current;
    }

    //RedBlack 트리 특성 복구
    private void insertFix(Node k) {
        //나는 당연히 RED이고 부모가 RED일때 계층간 중복 레드는 균형을 잡아야 한다.(4번 규칙 위반)
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

    public void delete(int key) {
        //z : 삭제할 노드
        Node z = findNodeRecursive(root, key);
        if (z == TNULL) return; // Node not found

        //y : 삭제 노드를 대체할 노드, x:
        Node y, x;
        // 삭제되는 색을 통해서 속성 위반 여부를 확인
        boolean yOriginalColor = z.color;

        if (z.left == TNULL) { //노드 z의 자식이 없거나, 자식이 하나뿐인 경우
            x = z.right;
            //삭제 오른쪽 노드를 삭제 노드 위치로 변경
            transplant(z, z.right);
        } else if (z.right == TNULL) { //노드 z의 자식이 없거나, 자식이 하나뿐인 경우
            x = z.right;
            //삭제 왼쪽 노드를 삭제 노드 위치로 변경
            transplant(z, z.left);
        } else { //노드 z가 두 개의 자식을 가진 경우
            //삭제를 노드를 대체하기 위한 중위 후속자(inorder successor) 찾기
            y = minimum(z.right);
            //중위 후속자의 색깔로 체크
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) x.parent = y;
            else {
                //삭제 대체 노드 자식을 삭제 대체 노드 위치로 변경
                transplant(y, y.right);
                //삭제 대체 노드의 자식 변경
                y.right = z.right;
                y.right.parent = y;
            }
            //삭제 노드를 대체 노드로 변경
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        //삭제할 노드가 black 일때만 속성 5번을 위반한다.
        if (yOriginalColor == BLACK) deleteFix(x);
    }

    private void deleteFix(Node x) {
        while (x != root && x.color == BLACK) {
            if (x == x.parent.left) {
                Node u = x.parent.right;
                if (u.color == RED) { //case1
                    u.color = BLACK;
                    x.parent.color = RED;
                    leftRotate(x.parent);
                    u = x.parent.right;
                }
                if (u.left.color == BLACK && u.right.color == BLACK) { //case2
                    u.color = RED;
                    x = x.parent;
                } else { //왼쪽, 오른쪽, 아니면 모두의 자녀가 red이다.
                    if (u.right.color == BLACK) { //오른쪽 자녀가 black이니 왼쪽 자녀가 red이다. case3
                        u.left.color = BLACK;
                        u.color = RED;
                        rightRotate(u);
                        u = x.parent.right;
                    }
                    //case4
                    u.color = x.parent.color;
                    x.parent.color = BLACK;
                    u.right.color = BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                Node u = x.parent.left;
                if (u.color == RED) { //case1
                    u.color = BLACK;
                    x.parent.color = RED;
                    rightRotate(x.parent);
                    u = x.parent.left;
                }
                if (u.right.color == BLACK && u.left.color == BLACK) { //case2
                    u.color = RED;
                    x = x.parent;
                } else { //왼쪽, 오른쪽, 아니면 모두의 자녀가 red이다.
                    if (u.right.color == BLACK) { //오른쪽 자녀가 black이니 왼쪽 자녀가 red이다. case3
                        u.right.color = BLACK;
                        u.color = RED;
                        leftRotate(u);
                        u = x.parent.left;
                    }
                    //case4
                    u.color = x.parent.color;
                    x.parent.color = BLACK;
                    u.left.color = BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        //x가 흑색이며, 추가적인 흑색을 가지고 있는 상태를 위 while에서 처리했고 x를 흑색으로 변경
        x.color = BLACK;
    }

    //삭제를 노드를 대체하기 위한 중위 후속자(inorder successor) 찾기
    private Node minimum(Node node) {
        while (node.left != TNULL) node = node.left;
        return node;
    }

    //삭제를 하는 위치에 대체 노드를 연결
    private void transplant(Node z, Node v) {
        //삭제하려는 노드가
        if (z.parent == null) root = v; //root라면 v를 root설정
        else if (z == z.parent.left) z.parent.left = v; //왼쪽 노드라면 v를 왼쪽 노드로 설정
        else z.parent.right = v; //오른쪽 노드라면 v를 오른쪽 노드로 설정
        v.parent = z.parent; //v의 부모를 z의 부모로 설정
    }

    private Node findNodeRecursive(Node current, int key) {
        if (current == TNULL || current.key == key) {
            return current;
        }

        if (key < current.key) {
            return findNodeRecursive(current.left, key);
        } else {
            return findNodeRecursive(current.right, key);
        }
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
