package algorithm.doIt._6;

public class IntStack {
    private int max;
    private int ptr;
    private int[] stack;

    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stack = new int[max];
        } catch (Exception e) {
            max = 0;
        }
    }

    public int push(int value) {
        if (ptr >= max) {
            throw new RuntimeException("Stack overflow");
        }

        return stack[ptr++] = value;
    }

    public int pop() {
        if (ptr <= 0) {
            throw new RuntimeException("Stack underflow");
        }

        return stack[--ptr];
    }

    public boolean isEmpty() {
        return ptr == 0;
    }
}
