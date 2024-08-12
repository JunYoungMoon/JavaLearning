package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-3 선택정렬 (i 값과 그외의 값중 최소값을 구하여(선택) swap)
 */

public class Problem3 {
    static void selectionSort(int[] arr) {
        int tmp;

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 1, 3, 7, 1, 2};
        selectionSort(arr);
    }
}