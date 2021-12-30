package dataStructure;

/**
 * 배열 큐
 */
public class IntAryQueue {

    private int max;
    private int num;
    private int[] que;

    public static class OverflowIntAryQueueException extends RuntimeException {
        public OverflowIntAryQueueException() {
        }
    }

    public static class EmptyIntAryQueueException extends RuntimeException {
        public EmptyIntAryQueueException() {
        }
    }

    public IntAryQueue(int capacity) {
        num = 0;
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
        que[num++] = x;
    }

    public void deque() throws EmptyIntAryQueueException {
        if (num <= 0) {
            throw new EmptyIntAryQueueException();
        }
        //System.arraycopy(que, 1, que, 0, num - 1);
        for (int i = 0; i < num - 1; i++) {
            que[i] = que[i + 1];
        }
        num--;
    }

    public static void main(String[] args) {
        IntAryQueue iaq = new IntAryQueue(8);

        iaq.enque(1);
        iaq.enque(12);
        iaq.enque(11);
        iaq.enque(141);
        iaq.enque(11123122);

        iaq.deque();

        iaq.enque(777);
    }
}
