package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-2 버블정렬 개선 (정렬 된 경우에는 검사하지 않음)
 */

public class Problem2 {
    static void bubbleSort(int[] arr) {
        int tmp, last = arr.length - 1;

        while (last > 0) {
            int k = 0;
            for (int j = 0; j < last; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    k = j + 1;
                }
            }

            last = k;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 1, 3, 7, 1, 2};
        bubbleSort(arr);
    }
}