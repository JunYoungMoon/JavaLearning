package dataStructure;

/**
 * 스택 (제네릭)
 */
public class Gstack<E> {
    private int max;
    private int ptr;
    private E[] stk;

    public static class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    public static class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

    public Gstack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public void push(E x) throws OverflowIntStackException {
        if (this.isFull()) {
            throw new OverflowIntStackException();
        }
        stk[ptr++] = x;
    }

    public E pop() throws EmptyIntStackException {
        if (this.isEmpty()) {
            throw new EmptyIntStackException();
        }
        return stk[--ptr];
    }

    public E peek() throws EmptyIntStackException {
        if (this.isEmpty()) {
            throw new EmptyIntStackException();
        }
        return stk[ptr - 1];
    }

    public void clear() {
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

    public int indexOf(E x) {
        for (int i = 0; ptr > 0; i++) {
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
            System.out.print("모든 데이터 ");
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }
}
