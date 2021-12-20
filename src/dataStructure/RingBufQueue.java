package dataStructure;

/**
 * 링 버퍼 큐
 */
public class RingBufQueue {
    private int max;    //큐의 용량
    private int[] que;  //큐 본체
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

    public RingBufQueue(int capacity) {
        rear = front = num = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public void enque(int x) throws OverflowIntAryQueueException {
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

    public static void main(String[] args) {

        RingBufQueue iaq = new RingBufQueue(3);

        iaq.enque(1);
        iaq.enque(12);
        iaq.enque(11);

        iaq.deque();

        iaq.enque(777);
    }
}
