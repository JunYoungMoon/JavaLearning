package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-6 퀵정렬 (재귀)
 * 피벗을 기준으로 좌우 값을 구분하고 다시
 */

public class Problem7 {
    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = arr[(pl + pr) / 2];

        System.out.printf("a[%d]~a[%d] : {", left, right);
        for (int i = left; i < right; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("%d}\n", arr[right]);

        //pl,pr이 교차 할때까지 포인트를 증가,감소 하면서 swap을 진행한다.
        //피벗을 기준으로 좌측은 피벗보다 작은 값들이 우측은 피벗보다 큰 값들이 배치된다.
        do {
            while (arr[pl] < pivot) pl++;
            while (arr[pr] > pivot) pr--;
            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) {
            quickSort(arr, left, pr);
        }
        if (pl < right) {
            quickSort(arr, pl, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 9, 44, 13, 3, 7, 1, 6, 14, 3, 4, 1};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }
}