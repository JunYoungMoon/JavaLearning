package algorithm;

import java.util.Scanner;

public class CaseConverter {
    public String solution(String str) {

        StringBuilder answer = new StringBuilder();

        //방법1
        for (char x : str.toCharArray()
        ) {
            if (Character.isLowerCase(x)) answer.append(Character.toUpperCase(x));
            else answer.append(Character.toLowerCase(x));
        }

        //방법2
        for (char x : str.toCharArray()
        ) {
            if (97 <= x && x <= 122) answer.append((char) (x - 32));
            else answer.append((char) (x + 32));
        }

        //내가한 방법3
        char[] c = str.toCharArray();
        char mask = 0x20;
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (c[i] ^ mask);
        }
        return new String(c);
    }

    public static void main(String[] args) {
        CaseConverter cc = new CaseConverter();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(cc.solution(str));
    }
}
