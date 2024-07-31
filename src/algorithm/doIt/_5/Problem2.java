package algorithm.doIt._5;

/**
 * 5-2. 유클리드 호제법
 */
public class Problem2 {
    static int gcd(int n, int m) {
        int remainder = n % m;
        if (remainder == 0) {
            return m;
        } else {
            return gcd(m, remainder);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(22,8));
    }
}