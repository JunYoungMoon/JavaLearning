package algorithm;

import java.util.Scanner;

public class PalindromeString2 {
    public static String solution(String str) {
        String answer = "YES";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();

        if (!str.equals(tmp)) {
            answer = "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        PalindromeString2 t = new PalindromeString2();
        Scanner kb = new Scanner(System.in);
        System.out.println(t.solution(kb.nextLine()));
    }
}
