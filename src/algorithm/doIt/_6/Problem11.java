package algorithm.doIt._6;

import java.util.Arrays;

/**
 * 6-7 병합정렬 (재귀)
 */

public class Problem11 {
    static int[] buff;

    static void __mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            __mergeSort(arr, left, center);
            __mergeSort(arr, center + 1, right);

            for (i = left; i <= center; i++) {
                buff[p++] = arr[i];
            }

            while (i <= right && j < p) {
                arr[k++] = (buff[j] <= arr[i]) ? buff[j++] : arr[i++];
            }

            while (j < p) {
                arr[k++] = buff[j++];
            }
        }
    }

    static void mergeSort(int[] arr, int n) {
        buff = new int[n];

        __mergeSort(arr, 0, n - 1);

        buff = null;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};

        mergeSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }
}