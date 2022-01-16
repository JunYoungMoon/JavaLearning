package algorithm;

import java.util.Scanner;

public class PalindromeStringReplaceAll {
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
        PalindromeStringReplaceAll t = new PalindromeStringReplaceAll();
        Scanner kb = new Scanner(System.in);
        System.out.println(t.solution(kb.nextLine()));
    }
}
