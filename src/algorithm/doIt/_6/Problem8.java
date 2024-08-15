package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-6 퀵정렬 (비재귀)
 * 스택 자료구조를 통해 범위 데이터를 임시저장
 */

public class Problem8 {
    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void quickSort(int[] arr, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int pivot = arr[(left + right) / 2];

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
        int[] arr = {6, 2, 9, 44, 13, 3, 7, 1, 6, 14, 3, 4, 1};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }
}