package dataStructure;

/**
 * 단순 연결 리스트
 */
class Node<E> {
    Node next;  // 다음 노드를 가리키는 포인터
    E data;   // 노드가 저장하는 데이터

    // 노드를 생성할 때 데이터와 다음 노드를 설정
    Node(E data) {
        this.data = data;
        this.next = null;
    }
}


public class List {
    static <E> Node insert(Node head, E data) {
        Node newNode = new Node(data);  // 새 노드를 생성하고 데이터 설정
        newNode.next = head;            // 새 노드의 다음 노드로 기존의 헤드 노드를 설정
        return newNode;                 // 새 노드를 반환하여 새로운 헤드로 설정
    }

    public static void main(String[] args) {
        Node head = null;
        head = insert(head, 1);  // 헤드 노드에 1을 삽입
        head = insert(head, "22");  // 헤드 노드에 2를 삽입
        head = insert(head, 3);  // 헤드 노드에 3을 삽입

        // 리스트의 모든 노드를 출력
        Node current = head;
        while (current != null) {
            System.out.println(current.data);  // 현재 노드의 데이터를 출력
            current = current.next;  // 다음 노드로 이동
        }
    }
}
