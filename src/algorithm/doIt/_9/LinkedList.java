package algorithm.doIt._9;

import java.util.Comparator;

/**
 * 9-2 포인터 연결 리스트
 */
public class LinkedList<E> {
    class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt; // crnt : current 현재 노드

    public LinkedList() {
        head = crnt = null;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr != null) {
            if (c.compare(ptr.data, obj) == 0) {
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }

        return null;
    }

    public void addFirst(E obj) {
        Node<E> ptr = head;  // 현재 헤드 노드를 ptr이 참조
        head = crnt = new Node<E>(obj, ptr);  // 새로운 노드를 생성하고, 이 노드를 헤드로 설정합니다.
    }

    public void addLast(E obj) {
        if (head == null) {
            addFirst(obj);
        } else {
            Node<E> ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = crnt = new Node<>(obj, null);
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = crnt = head.next;
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                removeFirst();
            } else {
                Node<E> ptr = head; //ptr : pointer
                Node<E> pre = head; //pre : previous

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                crnt = pre;
            }
        }
    }

    public void remove(Node p) {
        if (head != null) {
            if (p == head) {
                removeFirst();
            } else {
                Node<E> ptr = head;
                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null) {
                        return;
                    }
                }
                ptr.next = p.next;
                p.next = null; // 선택된 노드의 next 참조를 해지
                crnt = ptr;
            }
        }
    }

    public void removeCurrentNode() {
        remove(crnt);
    }

    public void clear() {
        while (head != null) {
            removeFirst();
        }
        crnt = null;
    }

    public boolean next() {
        if (crnt == null || crnt.next == null) {
            return false;
        }
        crnt = crnt.next;

        return true;
    }

    public void printCurrentNode() {
        if (crnt == null) {
            System.out.println("선택한 노드가 없습니다.");
        } else {
            System.out.println(crnt.data);
        }
    }

    public void dump() {
        Node<E> ptr = head;
        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}