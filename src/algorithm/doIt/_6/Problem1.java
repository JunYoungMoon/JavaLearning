package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-2 버블정렬
 */

public class Problem1 {
    static void bubbleSort(int[] arr) {
        int tmp;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 1, 3, 7, 1, 2};
        bubbleSort(arr);
    }
}