package algorithm.doIt._5;

/**
 * 5-1. 팩토리얼
 */
public class Problem1 {
    static int factorial(int n) {
        if (n > 0) {
            System.out.println(n);
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(8));

        System.out.println(5%8);
    }
}