package algorithm.inflearn._1;

/**
 * 9. 숫자만 추출
 */
public class Problem9 {
    public static void main(String[] args) {
        String s = "tge0a1h205er";

        s = s.replaceAll("\\D", "");

        int a = Integer.parseInt(s);

        System.out.println(a);
    }
}