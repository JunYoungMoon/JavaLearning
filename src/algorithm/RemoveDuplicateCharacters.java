package algorithm;

import java.util.Scanner;

public class RemoveDuplicateCharacters {
    public String solution(String str) {
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) {
                answer += str.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        RemoveDuplicateCharacters sr = new RemoveDuplicateCharacters();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(sr.solution(str));
    }
}
