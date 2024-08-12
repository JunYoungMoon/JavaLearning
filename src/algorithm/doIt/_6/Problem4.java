package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-4 삽입정렬 (왼쪽 요소와 비교)
 */

public class Problem4 {
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i], j;
            for (j = i; j > 0 && arr[j - 1] > tmp; j--) {
                arr[j] = arr[j - 1];
            }

            arr[j] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 1, 3, 7, 1, 2};
        insertionSort(arr);
    }
}