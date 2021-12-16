package algorithm;

import java.util.Arrays;

public class IntStack {
    private int max;
    private int ptr;
    private int[] stk;

    public static class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    public static class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public void push(int x) throws OverflowIntStackException {
        if (this.isFull()) {
            throw new OverflowIntStackException();
        }
        stk[ptr++] = x;
    }

    public void pop() throws EmptyIntStackException {
        if (this.isEmpty()) {
            throw new EmptyIntStackException();
        }
        stk[--ptr] = 0;
    }

    public int peek() throws EmptyIntStackException {
        if (this.isEmpty()) {
            throw new EmptyIntStackException();
        }
        return stk[ptr - 1];
    }

    public void clear() {
        Arrays.fill(stk, 0);
        ptr = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    public int indexOf(int x) {
        for (int i = 0; stk[i] > 0; i++) {
            if (stk[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public void dump() {
        if (this.isEmpty()) {
            System.out.println("스택이 비어있음");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        IntStack s = new IntStack(8);

        System.out.println(s.isEmpty());

        s.push(1);
        s.push(12);
        s.push(11);
        s.push(141);
        s.push(112);
        s.push(141);
        s.push(11123122);

        System.out.println(s.isFull());

        s.pop();
        s.pop();

        s.peek();

        System.out.println(s.peek());
        System.out.println(s.indexOf(12));
        System.out.println(s.size());
        System.out.println(s.capacity());
        s.dump();

        s.clear();
    }
}
