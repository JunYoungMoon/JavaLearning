package algorithm.inflearn._1;

/**
 * 7. 회문 문자열
 */
public class Problem7 {
    public static void main(String[] args) {
        String s = "gokog";

        s = s.toLowerCase();

        String rs = new StringBuilder(s).reverse().toString();

        if (s.equals(rs)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}