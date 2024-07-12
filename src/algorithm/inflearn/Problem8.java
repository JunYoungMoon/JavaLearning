package algorithm.inflearn;

/**
 * 8. 유효한 팰린드롬
 */
public class Problem8 {
    public static void main(String[] args) {
        String s = "found7, time: study; Yduts; emit, 7Dnuof";

        s = s.replaceAll("[^a-zA-Z]","").toLowerCase();

        String rs = new StringBuilder(s).reverse().toString();

        if (s.equals(rs)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}