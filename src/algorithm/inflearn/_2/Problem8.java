package algorithm.inflearn._2;

import java.util.Arrays;

/**
 * 2-8. 등수 구하기
 */
public class Problem8 {
    public static void main(String[] args) {
        int[] score = new int[]{92, 92, 92, 100, 2};
        int[] rank = new int[5];

        for (int i = 0; i < score.length; i++) {
            int cnt = 1;
            for (int j = 0; j < score.length; j++) {
                if (score[i] < score[j]) {
                    cnt++;
                }
            }

            rank[i] = cnt;
        }

        System.out.println(Arrays.toString(rank));
    }
}