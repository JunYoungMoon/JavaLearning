package algorithm;

import java.util.Scanner;

public class StringCompression {
    public String solution(String str) {
        String answer = "";
        str += " ";
        int cnt = 1;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            } else {
                answer = answer + str.charAt(i) + ((cnt == 1) ? "" : cnt);
                cnt = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        Scanner kb = new Scanner(System.in);
        System.out.println(sc.solution(kb.nextLine()));
    }
}
