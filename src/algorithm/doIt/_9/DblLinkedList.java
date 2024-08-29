package algorithm.doIt._9;

import java.util.Comparator;

/**
 * 9-4 원형 이중 연결 리스트
 * 더미노드를 사용함으로써 리스트가 비어 있는 상태와 노드가 하나뿐인 상태를 특별히 처리하지 않아도 된다.
 */
public class DblLinkedList<E> {
    class Node<E> {
        private E data; // 데이터
        private Node<E> prev; // 앞쪽 포인터 (앞쪽 노드에 대한 참조)
        private Node<E> next; // 뒤쪽 포인터 (다음 노드에 대한 참조)

        // 노드 생성자
        Node() {
            data = null;
            //첫 더미 노드는 자기 자신을 가르키도록 한다.
            prev = next = this;
        }

        // 노드 생성자
        Node(E obj, Node<E> prev, Node<E> next) {
            data = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    //원형 이중 연결 리스트 생성자
    public DblLinkedList() {
        head = crnt = new Node<>();
    }

    // 리스트가 비어있는가?
    public boolean isEmpty() {
        return head.next == head;
    }

    //머리에 노드를 삽입
    public void addFirst(E obj) {
        crnt = head; // 더미 노드 head의 바로 뒤에 삽입
        add(obj);
    }

    //꼬리에 노드를 삽입
    public void addLast(E obj) {
        crnt = head.prev; // 꼬리 노드 head.prev의 바로 뒤에 삽입
        add(obj);
    }

    //머리 노드를 삭제
    public void removeFirst() {
        crnt = head.next;
        removeCurrentNode();
    }

    //꼬리 노드를 삭제
    public void removeLast() {
        crnt = head.prev;
        removeCurrentNode();
    }

    //선택 노드를 삭제
    public void removeCurrentNode() {
        if (!isEmpty()) {
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
            if (crnt == head) {
                crnt = head.next;
            }
        }
    }

    //모든 노드를 삭제
    public void clear() {
        while (!isEmpty()) {
            removeFirst();
        }
    }

    // 노드 검색
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head.next;

        while (ptr != head) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    //선택 노드를 하나 뒤쪽으로 이동
    public boolean next() {
        if (isEmpty() || crnt.next == head) {
            return false;
        }
        crnt = crnt.next;
        return true;
    }

    //선택 노드 바로 뒤에 노드 삽입
    public void add(E obj) {
        //새로 생성된 노드에 이전 노드와 연결
        Node<E> node = new Node<>(obj, crnt, crnt.next);
        //이전 노드의 다음 노드와 새로 생성된 노드 연결
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    //선택 노드를 출력
    public void printCurrentNode() {
        if (isEmpty()) {
            System.out.println("선택 노드가 없습니다.");
        } else {
            System.out.println(crnt.data);
        }
    }

    //모든 노드를 출력
    public void dump() {
        Node<E> ptr = head.next;

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    //모든 노드를 거꾸로 출력
    public void dumpReverse() {
        Node<E> ptr = head.prev;

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.prev;
        }
    }
}
