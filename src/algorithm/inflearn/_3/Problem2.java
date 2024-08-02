package algorithm.inflearn._3;

import java.util.Arrays;

/**
 * 3-2. 공통 원소 구하기
 */
public class Problem2 {

    public static void main(String[] args) {
        int[] ints1 = {1, 4, 3, 2, 5, 11, 9};
        int[] ints2 = {4, 2, 2, 3, 4, 7, 7, 5};
        int p1 = 0, p2 = 0;

        Arrays.sort(ints1);
        Arrays.sort(ints2);

        while (ints1.length > p1 && ints2.length > p2) {
            if (p1 >= ints1.length) {
                p2++;
            } else if (p2 >= ints2.length) {
                p1++;
            } else if (ints1[p1] > ints2[p2]) {
                p2++;
            } else if (ints2[p2] > ints1[p1]) {
                p1++;
            } else {
                System.out.println(ints1[p1]);
                p1++;
                p2++;
            }
        }
    }
}