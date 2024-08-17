package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-7 병합정렬 (정렬을 마친 배열 병합)
 */

public class Problem10 {
    static void merge(int[] a, int na, int[] b, int nb, int[] c) {
        int pa = 0, pb = 0, pc = 0;

        while (pa < na && pb < nb) {
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
        }

        while (pa < na) {
            c[pc++] = a[pa++];
        }

        while (pb < nb) {
            c[pc++] = b[pb++];
        }

    }

    public static void main(String[] args) {
        int[] a = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] b = {1, 2, 3, 4, 5, 6, 7};
        int[] c = new int[a.length + b.length];

        merge(a, a.length, b, b.length, c);
        System.out.println(Arrays.toString(c));
    }
}