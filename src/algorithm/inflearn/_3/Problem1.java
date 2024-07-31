package algorithm.inflearn._3;

import java.util.Arrays;

/**
 * 3-1. 두 배열 합치기
 */
public class Problem1 {

    public static void main(String[] args) {
        int[] ints1 = {0, 3, 3, 4, 5, 7, 9};
        int[] ints2 = {1, 2, 3, 3, 4, 6, 7, 8};
        int p1 = 0, p2 = 0;

        int length = ints1.length + ints2.length;
        int[] nints = new int[length];

        for (int i = 0; i < length; i++) {
            if (p1 >= ints1.length) {
                nints[i] = ints2[p2++];
            } else if (p2 >= ints2.length) {
                nints[i] = ints1[p1++];
            } else if (ints1[p1] > ints2[p2]) {
                nints[i] = ints2[p2++];
            } else {
                nints[i] = ints1[p1++];
            }
        }

        System.out.println(Arrays.toString(nints));
    }
}