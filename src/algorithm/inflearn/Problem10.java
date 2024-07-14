package algorithm.inflearn;

import java.util.Arrays;

/**
 * 10. 가장 짧은 문자거리
 */
public class Problem10 {
    public static void main(String[] args) {
        String s = "teachermode";
        char c = 'e';

        char[] chars = s.toCharArray();

        int[] answer = new int[chars.length];
        int p = 1000;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                p = 0;
            } else {
                p++;
            }

            answer[i] = p;
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == c) {
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