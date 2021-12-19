package algorithm;

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
        if (num >= max)
            throw new OverflowIntAryQueueException(); // 큐가 가득 참
        que[num++] = x;
    }

    public void deque() throws EmptyIntAryQueueException {
        if (num <= 0)
            throw new EmptyIntAryQueueException(); // 큐가 비어 있음
        int x = que[0];
        System.arraycopy(que, 1, que, 0, num - 1);
        num--;
    }

    public static void main(String[] args) {

    }
}
