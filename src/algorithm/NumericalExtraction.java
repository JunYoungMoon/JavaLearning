package algorithm;

import java.util.Scanner;

public class NumericalExtraction {
    public int solution(String str) {
//        int answer = 0;
//        for (char x : str.toCharArray()) {
//            if (48 <= x && x <= 57) {
//                answer = answer * 10 + (x - 48);
//            }
//        }
//        return answer;

        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) answer += x;
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        NumericalExtraction t = new NumericalExtraction();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(t.solution(str));

    }
}
