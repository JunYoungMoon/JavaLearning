package algorithm.inflearn._1;

import java.util.Arrays;

/**
 * 10. 가장 짧은 문자거리
 */
public class Problem10 {
    public static void main(String[] args) {
        String s = "teachermode";
        char c = 'e';

        int[] answer = new int[s.length()];
        int p = Integer.MAX_VALUE / 2; // 초기 거리를 큰 값으로 설정

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                p = 0;
            } else {
                p++;
            }

            answer[i] = p;
        }

        p = Integer.MAX_VALUE / 2; // 다시 초기화

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                p = 0;
            } else {
                p++;
            }

            if (answer[i] > p) {
                answer[i] = p;
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}