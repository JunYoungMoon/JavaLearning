package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-6 퀵정렬 (비재귀)
 * 피벗 선택하기 (한쪽으로 치우친 경우 피하기)
 */

public class Problem9 {
    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    // x[a], x[b], x[c]를 sort (중앙값의 index를 반환)
    static int sort3Elem(int[] x, int a, int b, int c) {
        if (x[b] < x[a])
            swap(x, b, a);
        if (x[c] < x[b])
            swap(x, c, b);
        if (x[b] < x[a])
            swap(x, b, a);
        return b;
    }

    static void quickSort(int[] arr, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int pivot;

            int m = sort3Elem(arr, pl, (pl + pr) / 2, pr);
            pivot = arr[m];
            swap(arr, m, right - 1);
            pl++;
            pr--;


            do {
                while (arr[pl] < pivot) pl++;
                while (arr[pr] > pivot) pr--;

                if (pl <= pr) {
                    swap(arr, pl++, pr--);
                }
            } while (pl <= pr);

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }

            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,7,6,5,4,3,2,1};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }
}