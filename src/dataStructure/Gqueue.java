package dataStructure;

/**
 * 링 버퍼 큐 (제네릭)
 */
public class Gqueue<E> {
    private int max;    //큐의 용량
    private E[] que;    //큐 본체
    private int front;  //첫번째 요소 커서
    private int rear;   //마지막 요소 커서
    private int num;    //현재 데이터수

    public static class OverflowIntAryQueueException extends RuntimeException {
        public OverflowIntAryQueueException() {
        }
    }

    public static class EmptyIntAryQueueException extends RuntimeException {
        public EmptyIntAryQueueException() {
        }
    }

    public Gqueue(int capacity) {
        rear = front = num = 0;
        max = capacity;
        try {
            que = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public void enque(E x) throws OverflowIntAryQueueException {
        if (num >= max) {
            throw new OverflowIntAryQueueException();
        }
        que[rear++] = x;
        num++;

        if (rear == max) {
            rear = 0;
        }
    }

    public void deque() throws EmptyIntAryQueueException {
        if (num <= 0) {
            throw new EmptyIntAryQueueException();
        }
        front++;
        num--;

        if (front == max) {
            front = 0;
        }
    }

    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비었습니다.");
        else {
            //(i + front)값이 max와 같아지면 que 인덱스를 0으로 돌림
            for (int i = 0; i < num; i++)
                System.out.print(que[(i + front) % max] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Gqueue<Integer> iaq = new Gqueue<>(3);

        iaq.enque(1);
        iaq.enque(12);
        iaq.enque(11);

        iaq.deque();

        iaq.enque(777);
        iaq.dump();
    }
}
