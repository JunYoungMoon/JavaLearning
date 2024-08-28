package algorithm.doIt._9;

/**
 * 9-4 원형 이중 연결 리스트
 */
public class DblLinkedList<E> {
    class Node<E> {
        private E data; // 데이터
        private Node<E> prev; // 앞쪽 포인터 (앞쪽 노드에 대한 참조)
        private Node<E> next; // 뒤쪽 포인터 (다음 노드에 대한 참조)

        // 생성자
        Node(E obj, Node<E> prev, Node<E> next) {
            data = obj;
            this.prev = prev;
            this.next = next;
        }
    }
}
