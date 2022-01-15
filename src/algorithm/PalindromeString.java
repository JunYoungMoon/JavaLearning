package algorithm;

import java.util.Scanner;

public class PalindromeString {
    public String solution(String str) {
        String answer = "YES";

//        char[] c = str.toCharArray();
//        int lt = 0, rt = str.length() - 1;
//        for (int i = 0; i < str.length() / 2; i++) {
//            if (c[lt] != c[rt]) {
//                answer = "NO";
//            }
//            lt++;
//            rt--;
//        }

//        str = str.toUpperCase();
//        int len = str.length();
//        for (int i = 0; i < len / 2; i++) {
//            if (str.charAt(i) != str.charAt(len - i - 1)) return "NO";
//        }

        String tmp = new StringBuilder(str).reverse().toString();
        if (!str.equalsIgnoreCase(tmp)) {
            answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        PalindromeString t = new PalindromeString();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(t.solution(str));
    }
}
