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

    public void pop() throws EmptyIntStackException {
        if (this.isEmpty()) {
            throw new EmptyIntStackException();
        }
        --ptr;
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

    public static void main(String[] args) {
        Gstack<Integer> gsInt = new Gstack<>(8);

        System.out.println("비어있는가 " + gsInt.isEmpty());

        gsInt.push(1);
        gsInt.push(12);
        gsInt.push(11);
        gsInt.push(141);
        gsInt.push(112);
        gsInt.push(141);
        gsInt.push(11123122);

        System.out.println("가득차 있는가 " + gsInt.isFull());

        gsInt.pop();
        gsInt.pop();

        System.out.println("꼭대기 데이터 " + gsInt.peek());
        System.out.println("몇번지 인덱스인가 " + gsInt.indexOf(12));
        System.out.println("현재 데이터수 " + gsInt.size());
        System.out.println("용량 " + gsInt.capacity());
        gsInt.dump();

        gsInt.clear();

        Gstack<String> gsStr = new Gstack<>(8);

        gsStr.push("aa");
        gsStr.push("bb");
        gsStr.push("cc");
        gsStr.push("dd");

        gsStr.pop();
        gsStr.pop();

        System.out.println("꼭대기 데이터 " + gsStr.peek());
        System.out.println("몇번지 인덱스인가 " + gsStr.indexOf("bb"));
        System.out.println("현재 데이터수 " + gsStr.size());
        System.out.println("용량 " + gsStr.capacity());
        gsStr.dump();

        gsStr.clear();
    }
}
