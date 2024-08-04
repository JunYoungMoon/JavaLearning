package algorithm.doIt._5;

/**
 * 5-3. 8퀸
 */
public class Problem3 {
    static int[] pos = new int[8];

    static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();

    }

    static void set(int s) {
        for (int i = 0; i < 8; i++) {
            pos[s] = i;
            if (s == 7) {
                print();
            } else {
                set(s + 1);
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}