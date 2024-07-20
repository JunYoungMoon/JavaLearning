package algorithm.inflearn._2;

/**
 * 2-4. 피보나치 수열
 */
public class Problem4 {
    public static void main(String[] args) {
        int a = 1, b = 1, c, cnt = 5;

        System.out.printf(a + " " + b + " ");

        for (int i = 2; i < cnt; i++) {
            c = a + b;
            System.out.printf(c + " ");
            a = b;
            b = c;
        }
    }
}